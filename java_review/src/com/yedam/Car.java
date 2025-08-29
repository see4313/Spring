package com.yedam;

/*
 * 클래스 = 설계도 : 속성(필드) + 행위(메서드)
 * 1. 클래스 선언
 * 2. 객체(인스턴스) 생성 = 메모리 영역 할당 
 * 3. 객체 사용  
 * 캡슐화 : 외부접근 막고, setter/getter 제어
 */
public class Car {

	//static: 공유필드(=클래스필드) = 모든 인스턴스 공유필드 
	private String model;
	
	// 캡슐화
	
	
//	// 기본생성자 
//	public Car() {}
	
	// 2. 생성자 : 객체 생성 시 호출되는 메서드. 필드 초기화
	public Car(String model) {
		this.model = model; // 필드초기화
	}
	
	// 캡슐화 (getter/setter)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	// 1. 자기 자신을 저장할 정적 변수
	private static Car instance;

	// 3. 유일한 객체 반환 (필요할 때 생성)
	public static Car getInstance(String model) {
		if (instance == null) {
			instance = new Car(model);
		}
		return instance;
	}
	
	public void drive() {
		System.out.println(model + "운행");
		
	}
}
