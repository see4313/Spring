package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardVO;


@Controller
public class BoardController {
	@Autowired BoardMapper boardMapper; // new X, 객체(빈)거 주입됨.
	
	@GetMapping("boardList")
	public String BoardList(Model model, BoardVO boardVO) {
		model.addAttribute("boardList", boardMapper.selectBoard(boardVO));
		return "boardList"; // empList.html
	}
	
	@GetMapping("board") 
	public String board(Model model, @RequestParam("bno") Long bno) {
		model.addAttribute("board", boardMapper.selectBoardById(bno));
		return "board";
	}
}
