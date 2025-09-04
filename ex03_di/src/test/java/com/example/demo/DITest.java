package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DITest { 
	// DI(의존성 주입): 소스코드를 건들지 않고 객체변경해서 사용 가능.
	// 객체를 컨테이너에 생성
	// 필요할때마다 불러와서 사용

	
	@Autowired TV tv;
	@Autowired SampleHotel hotel;
	
//	@Test
	public void test() {
//		TV tv = new SamsungTv();
		tv.powerOn();
		tv.volumUp();
	}
	
//	@Test
	public void hotel_test() {
		System.out.println(hotel.getChef());
	}
}
