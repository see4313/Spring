package com.example.demo.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.Paging;
import com.example.demo.emp.service.EmpService;
import com.example.demo.emp.service.EmpVO;

@Controller
public class EmpController {

	@Autowired EmpService empService; // new X, 객체(빈)거 주입됨.
	
	@GetMapping("empList") //empList?page=2 (페이지에따라 다름)
	public String empList(Model model, EmpVO empVO, Paging paging) {
		paging.setPageUnit(5);
		paging.setTotalRecord(empService.selectCount(empVO));
		empVO.setFirst(paging.getFirst());
		empVO.setLast(paging.getLast());
		model.addAttribute("empList", empService.selectEmp(empVO));
		return "empList"; // empList.html
	}
	
	@GetMapping("emp") // localhost/emp?employeeId = 100
	public String emp(Model model, @RequestParam("employeeId") Long employeeId) {
		model.addAttribute("emp", empService.selectEmpById(employeeId));
		return "emp";
	}
}
