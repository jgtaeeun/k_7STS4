package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;
	
	
	@Order(1)
	@Test
	public void testInsertBoard() {
		Board board =  new Board();
		board.setTitle("첫번째 게시글");
		board.setContent("잘 등록 되나요?");
		//board.setWriter("테스터");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRepo.save(board);
		
	}
	
	@Order(2)
	@Test
	public void testGetBoard() {
		Board board= boardRepo.findById(1L).get();
		System.out.println(board);
	}
	
	@Order(3)
	@Test
	public void testUpdateBoard() {
		System.out.println("==1번 게시글 조회==");
		Board board= boardRepo.findById(1L).get();
		System.out.println("==게시글 수정==");
		board.setTitle("제목을 수정했습니다.");
		boardRepo.save(board);
	}
	
	@Order(4)
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
	
}
