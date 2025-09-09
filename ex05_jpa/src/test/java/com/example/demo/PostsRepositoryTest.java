package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Posts;
import com.example.demo.repository.PostsRepository;

@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired PostsRepository postsRepository;
	
	@AfterAll // 모든 테스트가 끝난 후 실행 => 삭제 
	public void cleanup() {
		postsRepository.deleteAll(); // deleteAll() : 모든 데이터 지움.
	}
	
//	@Transactional // 데이터안들어감.
//	@Rollback(true)
	@Test
	public void inssert() {
		// 방법 1
//		Posts posts = new Posts("", "", "");
		
		// 방법 2
		Posts posts = Posts.builder().author("손이영")
									 .title("포스트제목")
									 .content("테스트방쿠")
									 .build();
		postsRepository.save(posts);
	}

}
