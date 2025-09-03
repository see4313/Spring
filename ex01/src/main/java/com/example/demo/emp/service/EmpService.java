package com.example.demo.emp.service;

import java.util.List;

// use case diagram
public interface EmpService {
	
	// 건수조회 ( 전체조회와 건수조회는 같은 조건이 들어가야됨) ex.(EmpVO empVO)
		Long selectCount(EmpVO empVO);
		
		// 전체조회
		List<EmpVO> selectEmp(EmpVO empVO);
		
		// 단건조회
		EmpVO selectEmpById(Long employeeId); // 값이 하나뿐이면 값을 기본형으로 넣어주면 됨.
		
		// 등록
		   int insertEmp(EmpVO empVO);
		   
		// 수정
		   
		// 삭제
		   
		// 퇴사
	

}
