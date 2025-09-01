package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.service.EmpVO;

@Mapper // 인터페이스 구현클래스를 생성(싱글톤)해서 스프링 컨테이너에 빈 등록해줌.
public interface EmpMapper {
	// 건수조회 ( 전체조회와 건수조회는 같은 조건이 들어가야됨) ex.(EmpVO empVO)
	Long selectCount(EmpVO empVO);
	
	// 전체조회
	List<EmpVO> selectEmp(EmpVO empVO);
	
	// 단건조회
	EmpVO selectEmpById(Long employeeId); // 값이 하나뿐이면 값을 기본형으로 넣어주면 됨.
	
	// 등록
	   int insertEmp(EmpVO empVO);
}
