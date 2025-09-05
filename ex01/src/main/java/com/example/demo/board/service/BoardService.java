package com.example.demo.board.service;

import java.util.List;

public interface BoardService {

	// 전체조회
	List<BoardVO> selectBoard(BoardVO boardVO);
	
	// 단건조회
	BoardVO selectBoardById(Long bno);
	
	// 등록
	int insertBoard(BoardVO boardVO);
	
	// 수정
	
	// 삭제 
	int deleteBoard(Long bno);
	
}
