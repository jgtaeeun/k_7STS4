package edu.pnu.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;
import lombok.RequiredArgsConstructor;


@Service

public class MemberService {
	
	

	@Autowired
	 private MemberDao memberDao;


	 public MemberService( MemberDao memberDao) {
		this.memberDao=memberDao;
	 }
	
    
	
	public List<MemberDTO> getAllMember() throws SQLException{
		return memberDao.getAllMember();
	}
	
	
	public MemberDTO getMemberById(int id) throws SQLException {
		return memberDao.getMemberById(id);
	}
	
	public MemberDTO addMember(MemberDTO m) throws SQLException {

		
		return memberDao.addMember(m);
	}

	public int updateMember(MemberDTO membervo) throws SQLException {
		
		return memberDao.updateMember(membervo);
		
		
	}
	
	public int removeMember(int id) throws SQLException {
	
	
		return memberDao.removeMember(id);
	}
}
