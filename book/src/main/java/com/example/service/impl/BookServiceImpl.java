package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.BookService;
import com.example.service.BookVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService{

	@Autowired BookMapper bookMapper;

	@Override
	public List<BookVO> selectBook(BookVO bookVO) {
		return bookMapper.selectBook(bookVO);
	}
	
	
	@Override
	public List<BookVO> selectRent(BookVO bookVO) {
		return bookMapper.selectRent(bookVO);
	}
	
	@Override
	public int insertBook(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}

}
