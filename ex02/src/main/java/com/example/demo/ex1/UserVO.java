package com.example.demo.ex1;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "회원정보") //DTO의 필드를 문서화
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	@Schema(description = "회원이름") 
//	@JsonProperty("username")
	String name;
	
	@Schema(description = "회원나이")
//	@JsonIgnore
	int age;
	
	@Schema(description = "가입일자")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	@JsonFormat(pattern = "yyyy-MM")
	private Date wdate; 
	
	@Schema(description = "관심분야")
	// = String[] hobby; 동일의미.
	List<String> hobby; // 같은이름의 hobby가 여러개 넘어올 떄 list에 담아서 사용가능.
}
