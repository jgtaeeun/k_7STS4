package edu.pnu.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
// 로그인세션정보확인용URL
@GetMapping("/oauth")
public @ResponseBody String auth(@AuthenticationPrincipal OAuth2User user) {
if (user == null) return "OAuth2:null";
// 자동회원가입을한다면이용할정보확인
System.out.println("attributes:" + user.getAttributes());
return "OAuth2:" + user;
}

@GetMapping("/login")
public String login() {
	return "login";
}
@PostMapping("/login")
public String loginSuccess() {
	return "loginSuccess";
}
}