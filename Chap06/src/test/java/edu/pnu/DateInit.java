package edu.pnu;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member2;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@SpringBootTest
public class DateInit {
	@Autowired
	private  MemberRepository memberRepo;
	@Autowired
	private  BoardRepository boardRepo;
	
	
	@Test
	public void testInsertn( ) {
		Member2 m1 =Member2.builder()
				.id("member1")
				.password("member1")
				.name("둘리")
				.role("User")
				.build();
		memberRepo.save(m1);

		Member2 m2 =Member2.builder()
						.id("member2")
						.password("member2")
						.name("도우너")
						.role("Admin")
						.build();
		memberRepo.save(m2);


		for (int i=3 ; i<=5 ; i++) {
			boardRepo.save(Board.builder()
					
					.title("title"+i)
					.content("content1"+i)
					.writer("member"+i)
					.build()
					
					);
		}
	}
	
	
}
