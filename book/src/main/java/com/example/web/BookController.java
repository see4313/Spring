package com.example.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.BookService;
import com.example.service.BookVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	// 전체조회
	@GetMapping("/bookList")
	public String BookList(Model model, BookVO bookVO) {
		model.addAttribute("bookList", bookService.selectBook(bookVO));
		return "/bookList";
	}

	// 렌트조회
	@GetMapping("/rentList")
	public String RentList(Model model, BookVO bookVO) {
		model.addAttribute("rentList", bookService.selectRent(bookVO));
		return "/rentList";
	}

	// 등록 페이지로 이동
	@GetMapping("/registe")
	public String bookpage(BookVO bookVO) {
		return "/registe";
	}


	// 등록 처리
	@PostMapping("/registe")
	public String boardRegister(BookVO bookVO, MultipartFile file) throws IllegalStateException, IOException {
		bookService.insertBook(bookVO);
		return "redirect:/bookList";
	}
}
