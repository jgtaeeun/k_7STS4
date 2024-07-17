package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.pnu.domain.Member2;

public interface MemberRepository extends JpaRepository <Member2, String>{
		
}
