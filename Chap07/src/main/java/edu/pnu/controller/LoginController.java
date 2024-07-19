package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.service.MemberService;

@Controller
public class LoginController {
	
	
	private static final boolean True = false;

	@GetMapping("/login")
	public void login() {
		System.out.println("login 요청");
	}
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		
			System.out.println("loginSuccess 요청");
		}
	
	//로그인 했을 때 , 역할에 따른 접근제한
	@GetMapping("/accessDenied")
	 public void accessDenied() {
	 System.out.println("accessDenied");
	 }
	
	 // 로그인 세션 정보 확인용 URL
	//로그인 상태일 때,  링크 입력시 로그인 정보 출력
	 @GetMapping("/auth")
	 public @ResponseBody ResponseEntity<?> auth(@AuthenticationPrincipal User user) {
	 if (user == null) {
	 return ResponseEntity.ok("로그인 상태가 아닙니다.");
	 }
	 return ResponseEntity.ok(user);
	 } 
	 
	 
	 @Autowired
	 private MemberService memberService;
	 
	 //회원가입 창으로 이동
	 @GetMapping("/join")
	 public void join() {
		 
	 }
	 
	 
	 //회원정보 입력 후 가입완료하면 post해서 오면 db에 저장되고 welcome창으로 이동
	 @PostMapping ("/join")
	 public String joinProc(@RequestParam("username") String username,
             @RequestParam("password") String password,
             @RequestParam("role") String roleStr) {
		 
		 Role role;
		 role = Role.valueOf(roleStr);
		 Member member = new Member(username, password, role ,True);
		 memberService.save(member);
		 return "welcome";
	 }
}




