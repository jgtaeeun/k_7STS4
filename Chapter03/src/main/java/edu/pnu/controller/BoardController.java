package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.BoardVO;
import lombok.extern.slf4j.Slf4j;


	@RestController
	@Slf4j
	public class BoardController {
		
		public BoardController() {
			System.out.println("BoardController 생성자");
		log.error("error");
		log.info("info");
		log.debug("debug");
		log.warn("warn");
		log.trace("trace");
		}
		
		@GetMapping("/hello")
		public String hello(String name) {
			return "Hello:" + name;
		}
		@GetMapping("/getBoard")
		public BoardVO getWriter(BoardVO board) {
			return board;
		}
		
		
}
