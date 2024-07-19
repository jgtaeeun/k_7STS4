package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RelationMappingTest {
	@Autowired
	private MemberRepository memberRepo ;
	@Autowired
	private  BoardRepository boardRepo ;
	
//	@Test
////	영속성 삭제
//	public void testCascadeDelete() {
//		memberRepo.deleteById("member3");
//	}
//	
	
//	@Test 
//	@Order(1)
//	//영속성 삽입
//	public void testManyToOneInsert (){
//		
//		Member m1 =Member.builder()
//							.id("member3")
//							.password("member4")
//							.name("둘리")
//							.role("User")
//							.build();
////		memberRepo.save(m1);
////		
//		Member m2 =Member.builder()
//				.id("member4")
//				.password("member4")
//				.name("도우너")
//				.role("Admin")
//				.build();
////		memberRepo.save(m2);
//		
//		for (int i= 1 ; i<=3 ; i++) {
//			Board board =Board.builder()
//					.title("title"+i)
//					.content("content1"+i)
//					.createDate(new Date())
//					.cnt((long)(Math.random()*100))
//					.build();
//			board.setMember(m1);
//		}
//		
//		memberRepo.save(m1);
//		
//		for (int i= 1 ; i<=3 ; i++) {
//			Board board =Board.builder()
//		.title("title"+i)
//		.content("content1"+i)
//		.createDate(new Date())
//		.cnt((long)(Math.random()*100))
//		
//		.build();
//		board.setMember(m2);
//		}
//		memberRepo.save(m2);
//	}
//	
	
//	
//	@Test
//	@Order(1)
//	public void testManyToOneSelect() {
//		Board board = boardRepo.findById(5L).get();
//		System.out.println("["+board.getSeq()+"]");
//		System.out.println("제목"+board.getTitle());
//		System.out.println("내용"+board.getContent());
//		System.out.println("작성자"+board.getMember().getName());
//		System.out.println("작성자 권한"+board.getMember().getRole());
//	}
	
	
//	@Test
//	@Order(2)
//	public void testTwoWayMapping(){
//		Member member = memberRepo.findById("member1").get();
//		
//		System.out.println("=============");
//		System.out.println(member.getName() +"가(이) 저장한 게시글 목록");
//		System.out.println("=============");
//		List <Board > list = member.getBoardList();
//		for(Board b : list) {
//			System.out.println(b.toString());
//		}
//	}
}
