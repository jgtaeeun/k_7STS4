package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member2;

import edu.pnu.persistence.MemberRepository;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepo;
	
	
	public Member2 getMember(Member2 member){
		 Optional<Member2> findMember= memberRepo.findById(member.getId());
		 if(findMember.isPresent())
			 return findMember.get();
		 else return null;
	}
	
}