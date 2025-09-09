package com.example.service;

import java.util.List;

public interface BookService {
	
	// 전체조회
	List<BookVO> selectBook(BookVO bookVO);
	
	// 렌트
	List<BookVO> selectRent(BookVO bookVO);
	

	
	
	// 등록
	int insertBook(BookVO bookVO);
}
