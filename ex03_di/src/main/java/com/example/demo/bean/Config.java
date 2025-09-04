package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public MemberMapper memberMapper() {
		return new MemberMapper();
	}
	
	
	@Bean
	public MemberService memberService() {
		MemberService service = new MemberService(memberMapper());
//		service.setMemberMapper(memberMapper() );
		return service;
	}
}
