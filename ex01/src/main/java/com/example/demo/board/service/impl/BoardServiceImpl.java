package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	final BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> selectBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public BoardVO selectBoardById(Long bno) {
		return boardMapper.selectBoardById(bno);
	}

	@Override
	public int deleteBoard(Long bno) {
		return boardMapper.deleteBoard(bno);
	}

}
