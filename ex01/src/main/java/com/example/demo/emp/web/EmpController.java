package com.example.demo.emp.web;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.Paging;
import com.example.demo.emp.service.EmpService;
import com.example.demo.emp.service.EmpVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RequestMapping("/emp")
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
		return "emp/empList"; // empList.html
	}
	
	@GetMapping("emp") // localhost/emp?employeeId = 100
	public String emp(Model model, @RequestParam("employeeId") Long employeeId) {
		model.addAttribute("emp", empService.selectEmpById(employeeId));
		return "emp/emp";
	}
	
	// pdf파일 업로드
	@Autowired
	DataSource datasource;
	   @RequestMapping("report")
	    public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        Connection conn = datasource.getConnection();
	        
	        // 소스 컴파일 jrxml -> jasper
	        InputStream stream = getClass().getResourceAsStream("/reports/emp.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(stream);
	        //파라미터 맵
	        HashMap<String,Object> map = new HashMap<>();
	        map.put("P_EMPNAME", "SONY");
	        
	        response.setContentType("application/pdf");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
	        JasperExportManager.exportReportToPdfStream( jasperPrint, response.getOutputStream());
	    }
}
