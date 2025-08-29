package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper // 인터페이스 구현클래스를 생성(싱글톤)해서 스프링 컨테이너에 빈 등록해줌.
public interface EmpMapper {
	// 전체조회
	List<EmpVO> selectEmp();
	
	// 단건조회
	EmpVO selectEmpById(Long employeeId); // 값이 하나뿐이면 값을 기본형으로 넣어주면 됨.
	
	// 등록
	   int insertEmp(EmpVO empVO);
}
