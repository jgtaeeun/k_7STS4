package edu.pnu;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@GetMapping("/login")
	public void login() {
		System.out.println("login 요청");
	}
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		
			System.out.println("loginSuccess 요청");
		}
	@GetMapping("/accessDenied")
	public void accessDenied() {
		
			System.out.println("accessDenied");
		}
	@GetMapping("/auth")
	 public @ResponseBody ResponseEntity<?> auth(@AuthenticationPrincipal User user) {
	 if (user == null) {
	 return ResponseEntity.ok("로그인 상태가 아닙니다.");
	 }
	 return ResponseEntity.ok(user);
	 }

}



