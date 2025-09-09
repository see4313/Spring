package com.example.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Posts;
import com.example.demo.dto.PostsListResponseDto;

@Repository
// extends : 인터페이스끼리의 상속에서 사용
public interface PostsRepository extends JpaRepository<Posts, Long> { //<클래스이름, 기본키타입>
	
	
	@Query("SELECT p FROM Posts p ")
	Page<PostsListResponseDto> findAllPage(Pageable pageable);

}
