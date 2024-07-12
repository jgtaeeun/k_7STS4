package edu.pnu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {
	@Autowired
	private final BoardRepository boardRepo;
	
	@GetMapping("/board")
	public List<Board> getBoards(){
		return boardRepo.findAll();
	}
	@GetMapping("/board/{seq}")	
	public Board getBoard(@PathVariable Long seq){
		return boardRepo.findById(seq).orElseThrow();
	}
	@PostMapping("/board")
	public  Board  postBoard(@RequestBody Board board){
		
		return boardRepo.save(board);
	}
	@PutMapping("/board")
	public  Board  putBoard(@RequestBody Board board) {
		Board b =  boardRepo.findById(board.getSeq()).orElseThrow();
		if (b.getTitle() !=null ) b.setTitle(board.getTitle());
		if (b.getContent() !=null ) b.setContent(board.getContent());
		
		return boardRepo.save(b);
		
	}
	@DeleteMapping("/board/{seq}")
	public  Board  deleteBoard(@PathVariable Long seq){
		Board b =  boardRepo.findById( seq).orElseThrow();
		boardRepo.deleteById(seq);
		return b;
	}
}
