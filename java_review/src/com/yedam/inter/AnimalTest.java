package com.yedam.inter;

import org.junit.jupiter.api.Test;
/*
 * 다형성
 * 부모타입의 참조변수가 자식객체 참조
 * 참조하는 자식객체의 메서드를 호출
 * */
public class AnimalTest {

	@Test
	public void test() {

		Animal animal = new Cat(); // 부모타입(Animal)의 참조객체(cat)가 = 자식객체를 참조 가능
		animal.sound();
	}
}
