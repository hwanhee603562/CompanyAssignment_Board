package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mappers.MemberMapper;
import com.example.demo.model.MemberInfoDto;

import jakarta.servlet.http.HttpSession;

@Service
@Transactional
public class MemberService {
		
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	HttpSession session;

	// 아이디 중복검사
	public Boolean checkId( String mid ) {
		
		Integer result = memberMapper.checkId( mid );
		
		try {
			
			// 중복검사 결과 신규 아이디인 경우
			if( result == null ) return true;		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 회원가입
	public Boolean signUp( MemberInfoDto memberInfo ) {
		
		memberMapper.postMember(
				memberInfo.getMname(), 
				memberInfo.getMid(), 
				memberInfo.getMpwd(), 
				memberInfo.getMemail()
			);
		
		return true;  
		
	}
	
	// 로그인
	public MemberInfoDto logIn( String mid, String mpwd ) {

		// DB 상 회원조회
		MemberInfoDto member = memberMapper.logIn( mid, mpwd );
		
		// DB 상 등록된 회원일 경우
		if( member != null ) {
			
			// 세션 저장
			session.setAttribute("memberInfo", member);
			System.out.println( "session : "+ (MemberInfoDto)session.getAttribute("memberInfo"));
			
			return member;
		}
		
		return null;
				
	}
	
	// 로그아웃
	public boolean logOut() {
		
		try {
			
			// 세션 삭제
			session.removeAttribute("memberInfo");
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
		
	}
	
	
	
}















