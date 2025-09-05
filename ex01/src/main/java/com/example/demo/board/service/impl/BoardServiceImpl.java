package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.aop.PrintExecutionTime;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	final BoardMapper boardMapper;
	
	@Override
	@PrintExecutionTime
	public List<BoardVO> selectBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public BoardVO selectBoardById(Long bno) {
		return boardMapper.selectBoardById(bno);
	}

	
	@Transactional // 정상적으로 전체가 실행되면 -> commit, 하나라도 에러가 발생하면 -> rollback 을 알아서 해줌
	@Override
	public int deleteBoard(Long bno) {
		// 댓글삭제
		
		// 첨부파일 삭제
		
		//게시글 삭제
		
		
		return boardMapper.deleteBoard(bno);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

}
