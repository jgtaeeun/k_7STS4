package edu.pnu.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
		MemberService ms;
		
		public MemberController() throws SQLException {
			ms = new MemberService();
		}
		
		
		@GetMapping("/members")
		public Map<String,Object> getAllMember() throws SQLException{
			return ms.getAllMember();
		}
		@GetMapping("/member")
		public Map<String,Object> getMemberById(int id) throws SQLException{
			return ms.getMemberById(id);
		}
		@PostMapping("/member")
		public Map<String,Object> addMember(MemberDTO m) throws SQLException {
			return ms.addMember(m);
		}
		@PutMapping("/member")
		public Map<String, Object> updateMember(MemberDTO membervo) throws SQLException {
			return ms.updateMember(membervo);
		}
		@DeleteMapping("/member")
		public Map<String, Object> removeMember(int id) throws SQLException {
			return ms.removeMember(id);
		}
}
