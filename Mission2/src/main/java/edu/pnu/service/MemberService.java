package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

public class MemberService {
	private List<MemberVO> list = new ArrayList<>();
	
	public MemberService() {
		
		for (int i=1;i<=5; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setName("name"+i);
			m.setPass("pass"+i);
			m.setRegidate(new Date());
			list.add(m);
		}
		
	}
	
	public List<MemberVO> getAllMember(){
		return list;
	}
	
	
	public MemberVO getMemberById(int id) {
		for (MemberVO m : list) {
			if (m.getId()==id)
				return m;
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO m) {
		if (getMemberById(m.getId())!=null) {
			System.out.println("이미 존재하는 아이디"+m.getId()+"입니다.");
			return null;
		}
		m.setRegidate(new Date());
		list.add(m);
		return m;
	}
	
	public int updateMember(MemberVO membervo) {
		MemberVO m=	getMemberById(membervo.getId());
		if (m==null) {
			System.out.println("등록되어있지 않는 아이디입니다.");
			return 0;
		}
		m.setPass(membervo.getPass());
		m.setName(membervo.getName());
		m.setRegidate(new Date());
		
		return 1;
		
		
	}
	
	public int removeMember(int id) {
		try {
			list.remove(getMemberById(id));
		}catch (Exception e) {
			System.out.println("존재하지 않는 아이디입니다.");
			return 0;
		}
		return 1;
	}
}
