package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyVO;

@SpringBootTest
public class ReplyMapperTest {
	
	@Autowired ReplyMapper replyMapper;
	
	// 게시글의 댓글목록조회
	@Test
	public void getList() {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(1L);
		vo.setFirst(1);
		vo.setLast(10);
		List<ReplyVO> list = replyMapper.getList(vo);
		list.forEach(System.out::print);
//		list.forEach( reply -> System.out.println(reply));
	}
	
	@Test
	public void insert() {
		// 테스트의 3단계 : given - when - then
		// given : 데이터 준비
		ReplyVO reply = new ReplyVO();
		reply.setBno(1L);                  // 게시글번호
		reply.setReplyer("park");          // 작성자
		reply.setReply("댓글인데 왜 댓글?");   // 댓글내용
		
		// when : 테스트 수행
		int result = replyMapper.insert(reply);
		
		// then : 테스트결과확인
		assertEquals(result, 1);
	}
}
