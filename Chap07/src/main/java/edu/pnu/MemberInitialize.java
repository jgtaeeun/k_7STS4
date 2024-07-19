package edu.pnu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
//암호화 적용된 사용자 생성 및 테스트
public class MemberInitialize implements ApplicationRunner{
	 private final MemberRepository memRepo;
	 private final PasswordEncoder encoder;
	
	 @Override
	 public void run(ApplicationArguments args) throws Exception {
		 memRepo.save(Member.builder().username("member").password(encoder.encode("abcd"))
				 .role(Role.ROLE_MEMBER).enabled(true).build());
		 memRepo.save(Member.builder().username("manager").password(encoder.encode("abcd"))
				 .role(Role.ROLE_MANAGER).enabled(true).build());
		memRepo.save(Member.builder().username("admin").password(encoder.encode("abcd"))
				 .role(Role.ROLE_ADMIN).enabled(true).build());
	 
	 }
	 
}
