package edu.pnu;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired 
	private MemberRepository memberRepo;
//	@Order(1)
//	@Test
//	public void testFindByTitle() {
//		List<Board> list = boardRepo.findByTitle("title10");
//		System.out.println("--->testFindByTitle");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Order(2)
//	@Test
//	
//	public void testFindByContent() {
//		List<Board> list = boardRepo. findByContentContaining("5");
//		System.out.println("--->testFindByContent");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Order(3)
//	@Test
//	public void testFindByTitleContent() {
//		List<Board> list = boardRepo. findByTitleContainingOrContentContaining("17","17");
//		System.out.println("--->testFindByTitleContent");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Order(4)
//	@Test
//	public void testFindByTitleAndContent() {
//		List<Board> list = boardRepo.findByTitleContainingAndContentContaining("17","17");
//		System.out.println("--->testFindByTitleContent");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Order(5)
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> list = boardRepo. findByTitleContainingOrderBySeqDesc("17");
//		System.out.println("--->testFindByTitleContainingOrderBySeqDesc");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Order(6)
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable  paging = PageRequest.of(1,6);   //2번째 페이지 6개 출력
//		List<Board> list = boardRepo.findByTitleContaining("title" , paging);
//		System.out.println("--->testFindByTitleContaining");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> list = boardRepo.queryAoontationTest1("title10");
//		System.out.println("--->testQueryAnnotationTest1");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest1_1() {
//		List<Board> list = boardRepo.queryAoontationTest1_1("t","itle13");
//		System.out.println("--->testQueryAnnotationTest1_1");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Board> list = boardRepo.queryAoontationTest2("title10");
//		System.out.println("--->testQueryAnnotationTest2");
//		for (Board  b : list) {
//			System.out.println(b);
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest3() {
//		List<Object[]> list = boardRepo. queryAoontationTest3("title10");
//		System.out.println("--->testQueryAnnotationTest3");
//		for (Object[] b : list) {
//			System.out.println(Arrays.toString(b));
//		}
//	}
}
