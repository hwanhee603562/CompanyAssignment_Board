package com.example.demo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("MemberInfoDto")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
@Builder
public class MemberInfoDto implements Serializable{
	
	private int mno;
	private String mname;
	private String mid;
	private String mpwd;
	private String memail;
	

}
