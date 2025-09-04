package com.example.demo;


import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Component //빈등록
@Data
@RequiredArgsConstructor
public class SampleHotel {
	
	// 1. 필드생성(@Autowired) 
	// 2.생성자(@RequiredArgConstructor + final) -> 권장
	// 3.setter(@Setter(onMethod_ = {@Autowired}
	
	final Chef chef;
	
}
