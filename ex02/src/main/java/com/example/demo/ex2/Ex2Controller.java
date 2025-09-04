package com.example.demo.ex2;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.ex1.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;


@Tag(name = "회원관리 API", description = "게임사이트 회원가입")  //API 그룹 설정 (description = 설명)
@RequestMapping("/api")
@RestController
public class Ex2Controller {

	@Tag(name = "회원관리 API")
	@Operation(summary = "회원조회") //API의 메소드 단위 설명(= 메소드의 설명)
	// UserVO 단건조회
	@GetMapping("/rest1")
	public UserVO rest1() {
		return new UserVO("홍길동", 20, new Date(), Arrays.asList("춤추고", "노래해"));
	}
	
	@Tag(name = "회원관리 API")
	@Operation(summary = "회원단건조회")
	// UserVO 단건조회
	// query String : name = aaa&age=19 형태로 받음.
		@GetMapping("/rest2") // json 스트링으로 파라미터 받을때는 get방식 X.
		public UserVO rest2(UserVO userVO) {
			return userVO;
		}
		
	// 등록 
	// json 스트링 : {"name":"aaa", "age": 19}  ==> VO
		@PostMapping("/rest3") // json 스트링으로 받아서 VO객체에 담음.
		public UserVO rest3(@RequestBody UserVO userVO) {
			return userVO;
		}
		

		@GetMapping("/rest4")
		public Map rest4() {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://jsonplaceholder.typicode.com/todos/1";
			return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", Map.class);
			
		}
		
		
		@GetMapping("/rest5")
		public String getPost() { 
			  WebClient webClient = WebClient.create();
			  String response = webClient.get()
			        .uri("https://jsonplaceholder.typicode.com/posts/1") 
			        .retrieve() 
			        .bodyToMono(String.class).block(); 
			  return response.toString(); 
			}
		
		
}
