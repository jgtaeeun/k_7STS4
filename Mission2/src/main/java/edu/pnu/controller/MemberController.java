package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
@RestController
class MemberController {
	
	private MemberService ms = new MemberService();
		
	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return ms.getAllMember();
	}
	@GetMapping("/member")
	public MemberVO getMemberById(int id){
		return ms.getMemberById(id);
	}
	@PostMapping("/member")
	public MemberVO addMember(MemberVO m) {
		return ms.addMember(m);
	}
	@PutMapping("/member")
	public int updateMember(MemberVO membervo) {
		return ms.updateMember(membervo);
	}
	@DeleteMapping("/member")
	public int removeMember(int id) {
		return ms.removeMember(id);
	}
}