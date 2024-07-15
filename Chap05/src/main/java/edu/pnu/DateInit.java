package edu.pnu;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Component
public class DateInit implements ApplicationRunner {
	@Autowired
	private final BoardRepository boardRepo;
	
	@Override
	public void run(ApplicationArguments args ) throws Exception{
		for (int i= 1 ; i<=100 ; i++) {
			boardRepo.save(Board.builder()
					.title("title"+i)
					//.writer("member1")
					.content("content1"+i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.build()
					);
		}
		for (int i= 1 ; i<=100 ; i++) {
			boardRepo.save(Board.builder()
					.title("title"+i)
				//	.writer("member2")
					.content("content2"+i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.build()
					);
		}
	}
	
	
}
