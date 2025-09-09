package com.example.service;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {
	private Long bookNo;
	private String bookName;
	private String bookCoverImg;
	private String bookDate;
	private String bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private Long totalRentPrice;
	private Long rentCount;
}
