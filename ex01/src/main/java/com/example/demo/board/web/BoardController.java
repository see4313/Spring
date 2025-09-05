package com.example.demo.board.web;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;


@Controller
public class BoardController {
	
	@Autowired BoardService boardService; // new X, 객체(빈)거 주입됨.
	
	// 전체조회
	@GetMapping("/board/boardList")
	public String BoardList(Model model, BoardVO boardVO) {
		model.addAttribute("boardList", boardService.selectBoard(boardVO));
		return "/board/boardList"; // empList.html
	}
	
	// 단건조회
	@GetMapping("/board/board") 
	public String board(Model model, @RequestParam("bno") Long bno) {
		model.addAttribute("board", boardService.selectBoardById(bno));
		return "/board/board";
	}
	
	// 등록 페이지로 이동
	@GetMapping("/board/register")
	public String boardpage(BoardVO boardVO) {
		return "board/register";
	}  
	
	
	@Value("${file.upload.dir}")
	String UPLOAD_DIR;
	
	// 등록 처리
	@PostMapping("/board/register")
	public String boardRegister(BoardVO boardVO, MultipartFile file) throws IllegalStateException, IOException {
		if(! file.isEmpty() && file.getSize() > 0) {
		// 첨부파일 업로드
		file.transferTo(new File(UPLOAD_DIR, file.getOriginalFilename()));
		
		//파일명을 DB에 저장
		boardVO.setAttach(file.getOriginalFilename());
		}
		
		boardService.insertBoard(boardVO);
		return "redirect:/board/boardList";
	}
	
	
	// 파일 다운로드 
	@GetMapping("/board/download/{filename}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws MalformedURLException {
		// 파일 경로 설정
		Path filePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();

		// 파일을 Resource 로 로드
		Resource resource = new UrlResource(filePath.toUri());
		if (!resource.exists()) {
			return ResponseEntity.notFound().build();
		}

		// Content-Disposition 헤더에 다운로드용 파일명 지정
		String contentDisposition = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM) // 이진 파일
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
	}
	
	
	
	// 수정
	
	// 삭제
//	@DeleteMapping("deleteBoard")
//	public String deleteBoard(@RequestParam("bno") Long bno) {
//		mapper.
//	}
//	
}
