package com.example.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.service.BookVO;

@Mapper
public interface BookMapper {

	// 전체조회
	List<BookVO> selectBook(BookVO bookVO);
	
	// 렌트
	List<BookVO> selectRent(BookVO bookVO);
	
	
	// 등록
	int insertBook(BookVO bookVO);
}
