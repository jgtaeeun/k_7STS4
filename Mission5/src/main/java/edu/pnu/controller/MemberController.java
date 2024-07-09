package edu.pnu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController


public class MemberController {

	
	@Autowired
	private MemberService ms ;
	
	public MemberController() throws SQLException {
		ms = new MemberService();
	}
		
	 
	@GetMapping("/members")
	public List<MemberDTO> getAllMember() throws SQLException{
		return ms.getAllMember();
	}
	@GetMapping("/member")
	public MemberDTO getMemberById(int id) throws SQLException{
		return ms.getMemberById(id);
	}
	@PostMapping("/member")
	public MemberDTO addMember(MemberDTO m) throws SQLException {
		return ms.addMember(m);
	}
	@PutMapping("/member")
	public int updateMember(MemberDTO membervo) throws SQLException {
		return ms.updateMember(membervo);
	}
	@DeleteMapping("/member")
	public int removeMember(int id) throws SQLException {
		return ms.removeMember(id);
	}
}
