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

		
		return dao.addMember(m);
	}
	
	public int updateMember(MemberDTO membervo) throws SQLException {
		
		return dao.updateMember(membervo);
		
		
	}
	
	public int removeMember(int id) throws SQLException {
	
	
		return dao.removeMember(id);
	}
	
}
