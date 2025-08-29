package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 노드의 라우터와 같음
public class HomeController {
	
	@Autowired
	Animal animal;

	@GetMapping("/")
	@ResponseBody
	public String home() {
		animal.sound();
		return "Halo"; //json
	}
	
	@GetMapping("/main")
	public String main() {
		return "main"; // templates/main.html 으로 감.
	}
}
