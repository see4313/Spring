package com.yedam.collect.lambda;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.yedam.collect.EmpVO;


// 밑에 익명클래스를 사용해서 굳이 따로 class 를 작성안해줘도 됨.
//class NameComp implements Comparator<EmpVO>{
//
//	@Override
//	public int compare(EmpVO o1, EmpVO o2) {
//		return o1.getDept() - o2.getDept();
//	}
//
//}



public class LambdaTest {

	@Test
	public void test() {
		List<EmpVO> list = Arrays.asList(
				new EmpVO(100, "홍길동", 10),
				new EmpVO(101, "동길동", 50),
				new EmpVO(102, "길동길", 20),
				new EmpVO(103, "홍길길", 30)
				);
		
		//익명클래스 -> 람다식( 추상메서드가 하나인 경우)
		list.sort((EmpVO o1, EmpVO o2) -> o2.getEname().compareTo(o1.getEname()));

		System.out.println(list);
	}
}
