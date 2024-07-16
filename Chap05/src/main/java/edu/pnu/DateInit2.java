package edu.pnu;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DateInit2 implements ApplicationRunner {
	//member객체 만들고 db에 넣고 그것을 board에 전달해야 하는 과정이다.
	
	@Autowired
	private final MemberRepository memberRepo;
	@Autowired
	private final BoardRepository boardRepo;
	
	@Override
	public void run(ApplicationArguments args ) throws Exception{
		
//		Member m1 =Member.builder()
//							.id("member1")
//							.password("member111")
//							.name("둘리")
//							.role("User")
//							.build();
//		memberRepo.save(m1);
//		
//		Member m2 =Member.builder()
//				.id("member2")
//				.password("member222")
//				.name("도우너")
//				.role("Admin")
//				.build();
//		memberRepo.save(m2);
//		
//		
//		for (int i= 1 ; i<=100 ; i++) {
//			boardRepo.save(Board.builder()
//					.title("title"+i)
//					.content("content1"+i)
//					.createDate(new Date())
//					.cnt((long)(Math.random()*100))
//					.member(m1)
//					.build()
//					);
//		}
//		for (int i= 1 ; i<=100 ; i++) {
//			boardRepo.save(Board.builder()
//					.title("title"+i)
//					.content("content2"+i)
//					.createDate(new Date())
//					.cnt((long)(Math.random()*100))
//					.member(m2)
//					.build()
//					);
//		}
//		Board board = boardRepo.findById(5L).get();
//		System.out.println("["+board.getSeq()+"]");
//		System.out.println("제목"+board.getTitle());
//		System.out.println("내용"+board.getContent());
//		System.out.println("작성자"+board.getMember().getName());
//		System.out.println("작성자 권한"+board.getMember().getRole());
		
		
		
//			Member member = memberRepo.findById("member1").get();
//			
//			System.out.println("=============");
//			System.out.println(member.getName() +"가(이) 저장한 게시글 목록");
//			System.out.println("=============");
//			List <Board > list = member.getBoardList();
//			for(Board b : list) {
//				System.out.println(b.toString());
//			}
		
	}
	
	
}
