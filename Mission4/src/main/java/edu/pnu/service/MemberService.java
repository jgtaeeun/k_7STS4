package edu.pnu.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

public class MemberService {
	MemberDao dao;
	
	public MemberService() throws SQLException {
		 dao = new MemberDao();
	}
	
	
	
	public Map<String,Object> getAllMember() throws SQLException{
		return dao.getAllMember();
	}
	
	
	public Map<String,Object> getMemberById(int id) throws SQLException {
		return dao.getMemberById(id);
	}
	
	
	public Map<String,Object> addMember(MemberDTO m) throws SQLException {

		
		return dao.addMember(m);
	
	}
	
	public Map<String, Object> updateMember(MemberDTO membervo) throws SQLException {
		
		return dao.updateMember(membervo);
		

	}
	
	public Map<String, Object> removeMember(int id) throws SQLException {
	
	
		return dao.removeMember(id);
	}
	
}