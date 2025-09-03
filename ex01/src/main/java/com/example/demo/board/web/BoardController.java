package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;


@Controller
public class BoardController {
	@Autowired BoardService boardService; // new X, 객체(빈)거 주입됨.
	
	// 전체조회
	@GetMapping("boardList")
	public String BoardList(Model model, BoardVO boardVO) {
		model.addAttribute("boardList", boardService.selectBoard(boardVO));
		return "boardList"; // empList.html
	}
	
	// 단건조회
	@GetMapping("board") 
	public String board(Model model, @RequestParam("bno") Long bno) {
		model.addAttribute("board", boardService.selectBoardById(bno));
		return "board";
	}
	
	// 등록
	
	// 수정
	
	// 삭제
//	@DeleteMapping("deleteBoard")
//	public String deleteBoard(@RequestParam("bno") Long bno) {
//		mapper.
//	}
//	
}
