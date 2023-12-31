package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SendEmailService;

@RestController
public class SendEmailController {
	
	@Autowired
	SendEmailService sendEmailService;
	
	// 이메일 전송
	@PostMapping("/sendEmail")
	public boolean sendEmail( @RequestParam String toEmail ) {
		
		return sendEmailService.sendEmail( toEmail );
	}
	
	// 이메일 인증정보 확인
	@PostMapping("/checkEmail")
	public boolean checkEmail( @RequestParam String inputEemail ) {
		
		return sendEmailService.checkEmail( inputEemail );
	}
	
	
}
