package com.example.demo.ex1;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RequestMapping("/api")
@Controller
public class Ex1Controller {

	@GetMapping("/sample") //templates/api/main.html
	public ModelAndView sample() {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("today", new Date());
		return mv;
	}
	
	@GetMapping("/main") //templates/api/main.html
	public void main() {}
	
	// 커맨드 객체
	@GetMapping("/ex1")
	public String ex1(@ModelAttribute UserVO userVO,
			           Model model) {
//	      model.addAttribute("user", mapper.select());
	      log.info(userVO);
	      return "sample";
	   }
	
	//인덱스를 지정해서 객체배열로 받기가능
	@GetMapping("/ex2") //userList[0].name userList[0].age
	public String ex2(UserListVO list) { //userList[1].name userList[1].age
		log.info(list);
		return "sample";
	}
	
	// request.getParameter() 방식과 동일 
	// 원시데이터형 (String, int ... ) 하나씩받기 
	@GetMapping("/ex3")
	public String ex3(@RequestParam String name, 
					  @RequestParam(value = "userage", required = false, defaultValue = "20") Integer age) { 
		// age가 null 값일때 required = false 사용해서 null값이 들어가도록 해줌  
		// age가 null 일 때 기본값으로 20이 들어 갈 때 defaultValue = "20"
		log.info(name +":" + age);
		return "sample";
	}
	
	// Map 에 모든 파라미터 담음
	@GetMapping("/ex4")
	public String ex4(@RequestParam Map<String, Object> map) {
		log.info(map);
		return "sample";
		}
	
	
	@GetMapping("/ex5/{name}/{age}") // http://localhost/api/ex5/name/age
	public String ex5(@PathVariable String name, @PathVariable int age) {
		log.info("path=" + name +":" + age);
		return "sample";
	}
	
	// 첨부파일
	@PostMapping("/ex6") // 등록은 PostMapping 사용
	public String ex6(UserVO vo, MultipartFile pic) {
		log.info(pic.getOriginalFilename());
		log.info(pic.getSize());
		log.info(vo);
		return "sample";

		
	}
	
	
}
