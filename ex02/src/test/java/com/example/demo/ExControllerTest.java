package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.ex1.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ExControllerTest.class)
public class ExControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test 
	public void testList() throws Exception { 
//	    UserVO reply = new UserVO(); 
//	    UserVO.setName("마이콜"); 
//	    UserVO.setAge("댓글작성"); 
//	 String jsonStr = new ObjectMapper().writeValueAsString(reply); 
		
	String result = mvc.perform( get("api/rest1")
//	       .param("page", "1") 
//	       .param("name", "kum")
	       ) 
           .andExpect(status().isOk()) 
           .andReturn().getResponse().getContentAsString();
	 System.out.println(result);


}
