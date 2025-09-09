package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.domain.Posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
	
	   private Long id;
	   private String title;
	   private String author;
	   private LocalDateTime modifiedDate;
	   
	   public PostsListResponseDto() {}; // 기본생성자.
	   
	   public PostsListResponseDto(Posts entity) {
	      this.id = entity.getId();
	      this.title = entity.getTitle();
	      this.author = entity.getAuthor();
	      this.modifiedDate = entity.getModifiedDate();
	   }
}
