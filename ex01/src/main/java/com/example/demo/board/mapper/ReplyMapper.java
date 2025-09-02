package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.ReplyVO;

@Mapper
public interface ReplyMapper {
	
	int insert(ReplyVO reply);
	
	int update(ReplyVO reply);
	
	int delete(Long rno);
	
	ReplyVO read(ReplyVO reply);
	
	List<ReplyVO> getList(ReplyVO reply);

	int getCountByBno(Long bno);
	
}
