package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
//h2데이터베이스에서 저장되어있는 아이디를 가지고 와서 로그인하기 위함이다.ㅣ
@Service
public class BoardUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberRepository memRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// memRepo에서 사용자 정보를 검색해서
		Member member = memRepo.findById(username).orElseThrow(()->new UsernameNotFoundException("Not Found"));
		System.out.println(member); // 검색된 사용자 정보를 console에 출력해서 확인
		//UserDetails 타입의 객체를 생성해서 리턴 (o.s.s.core.userdetails.User)
		// 여기에서 리턴된 User 객체와 로그인 요청 정보를 비교한다.
		return new User(member.getUsername(), member.getPassword(),AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}