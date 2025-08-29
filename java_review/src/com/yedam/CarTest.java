package com.yedam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	
	@Test
	public void test3() {
		Car car1 = new Car("쏘렌토");
		car1.setModel("벤츠"); // writer
		System.out.println(car1.getModel()); // read
	}
	
	@DisplayName("객체생성")
	@Test 
	public void test2() {
		Car car1 = new Car("쏘렌토");
		Car car2 = new Car("테슬라");
		
		assertEquals(car1,car2);
	}
		
	
	@DisplayName("싱글톤")
	@Test 
	public void test() {
		Car car1 = new Car("쏘렌토");
		Car car2 = new Car("테슬라");

		assertEquals(car1, car2);
	}
}
