package edu.pnu.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;
import lombok.RequiredArgsConstructor;


@Service

public class MemberService {

	@Autowired
	private MemberDao dao;
	
	
	public  MemberService() throws SQLException {
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
