package com.yedam.collect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * List
 * Set
 * Map
 */
public class ListTest {
	@DisplayName("Map")
	@Test
	public void test3() {
		// 검색( 검색할 때는 주로 map)
		Map<String, String> map = new HashMap<>();
		map.put("100", "홍길동");
		map.put("101", "김유신");
		
		map.get("100"); // 검색속도 map:1    list:n
	}
	
	@DisplayName("List")
	@Test
	// @Ignore : 테스트 실행X 
	public void test1() {
		List<String> list = new ArrayList<>();
//		List<String> list = new LinkedList<>(); 
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		assertEquals(list.size(), 3); // 중복가능
		
		Set<String> set = new HashSet<>(list);
		assertEquals(set.size(), 2);
	}
	
	@DisplayName("Set")
	@Test
	public void test2() {
		Set<String> list = new HashSet<>();
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		assertEquals(list.size(), 2); // Set은 중복 무시 => 3개면 거짓
	}
}
