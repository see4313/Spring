package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Lazy // 지연로딩
@Scope("singleton")
@Component
//@RequiredArgsConstructor //final 붙은 것만.
public class SamsungTV implements TV {

//	@Autowired // @Autowired 안해주면 nullPoint에러 발생. // 주입받을 스피커에는 @Component 해줘야됨.
//	final Speaker speaker;
	
	@Setter(onMethod_ = {@Autowired} ) // 배열에 넣으면 여러개도 가능
	Speaker speaker;
	
	Date date;
	

//	// 기본생성자(생성자 주입방법) => @Autowired가 없으면 생성자 있어야됨.
//	public SamsungTV(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
//	// setter도 @Autowired필요
//	@Autowired
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	@Override
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}
	@Override
	public void volumUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumDown() {
		speaker.volumeDown();
	}
}
