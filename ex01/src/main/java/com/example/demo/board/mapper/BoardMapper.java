package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.BoardVO;


@Mapper
public interface BoardMapper {
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
