package com.example.demo.domain;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;

//@Setter Post에 필드값을 변경하면 DB에 반영되서 setter은 사용안함
@Getter
@Entity
public class Posts extends BaseTimeEntity{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "post_title", length = 100, nullable = false)
	private String title;
	private String content;
	
//	@Transient // @Transient : 컬럼에서 안보이게함.
	private String author;

	// 날짜만 따로 상속 해줘서 여기선 사용 x
//	@CreatedDate
//	@Temporal(TemporalType.TIMESTAMP) // @Temporal : 컬럼추가.
//	private Date wdate;
//	
//	
//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date upddate;
	
	// 기본생성자 ( 단건조회할때 필요 )
	public Posts() {};
	
	
	// 생성자 생성(Constructor)
	@Builder
	public Posts(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
	
	

}
