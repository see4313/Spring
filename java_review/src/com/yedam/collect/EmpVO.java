package com.yedam.collect;

import lombok.AllArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Data //Data가 아래 주석처리 된 것들을 다 포함.
//@Getter
//@Setter
//@ToString
@AllArgsConstructor 
//@RequiredArgsConstructor
@NoArgsConstructor // 위에 @RequiredArgsConstructor랑 같이 사용 불가능

public class EmpVO {
	// 필드 선언
	final private int empno;
	final private String ename;
	private int dept;
	
	
	
	
}
