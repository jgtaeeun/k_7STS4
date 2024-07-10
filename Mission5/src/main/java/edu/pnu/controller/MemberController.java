package edu.pnu.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dao.LogDao;
import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController


public class MemberController {

	@Autowired
	 private MemberService memberService;


	 public MemberController(MemberService memberService) {
		this.memberService=memberService;
	 }
	
	
	 
	@GetMapping("/members")
	public List<MemberDTO> getAllMember() throws SQLException{
		return memberService.getAllMember();
	}
	@GetMapping("/member")
	public MemberDTO getMemberById(int id) throws SQLException{
		return memberService.getMemberById(id);
	}
	@PostMapping("/member")
	public MemberDTO addMember(MemberDTO m) throws SQLException {
		return memberService.addMember(m);
	}
	@PutMapping("/member")
	public int updateMember(MemberDTO membervo) throws SQLException {
		return memberService.updateMember(membervo);
	}
	@DeleteMapping("/member")
	public int removeMember(int id) throws SQLException {
		return memberService.removeMember(id);
	}
}
