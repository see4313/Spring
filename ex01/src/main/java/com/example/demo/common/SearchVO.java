package com.example.demo.common;

import lombok.Data;

// int : 0, Integer : null (초기값을 기준으로 선택해서 사용)
//Integer는 초기값이 null 이면 에러, int는 초기값이 null이여도 0으로 들어감

@Data
public class SearchVO {
	Integer first; 
	Integer last;
}
