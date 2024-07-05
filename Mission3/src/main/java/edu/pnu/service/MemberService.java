package edu.pnu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;


public class MemberService {
	MemberDao dao;
	
	public MemberService() throws SQLException {
		 dao = new MemberDao();
	}
	
	
	
	public List<MemberDTO> getAllMember() throws SQLException{
		return dao.getAllMember();
	}
	
	
	public MemberDTO getMemberById(int id) throws SQLException {
		return dao.getMemberById(id);
	}
	
	
	public MemberDTO addMember(MemberDTO m) throws SQLException {
		if (getMemberById(m.getId())!=null) {
			System.out.println("이미 존재하는 아이디"+m.getId()+"입니다.");
			return null;
		}
		
		return dao.addMember(m);
	}
	
	public int updateMember(MemberDTO membervo) throws SQLException {
		MemberDTO m=	getMemberById(membervo.getId());
		if (m==null) {
			System.out.println("등록되어있지 않는 아이디입니다.");
			return 0;
		}
		return dao.updateMember(m);
		
		
	}
	
	public int removeMember(int id) throws SQLException {
	
		if (getMemberById(id)==null) {
			System.out.println("등록되어있지 않는 아이디입니다.");
			return 0;
		}
		return dao.removeMember(id);
	}
	
}
