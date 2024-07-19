package edu.pnu.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {
	@Bean

	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//로그인하지 않을 경우, member, manager, admin url의 경우 로그인 창으로 이동
		http.authorizeHttpRequests(security->security
				 .requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				 .requestMatchers("/admin/**").hasRole("ADMIN")
				 .anyRequest().permitAll());
		http.csrf(cf->cf.disable());
		//로그인창
		http.formLogin(form-> form.loginPage("/login").defaultSuccessUrl("/loginSuccess", true));
		//로그인 한 상태에서 member, manager, admin링크 클릭 시 접근제한일 때 에러메세지403 대신 안내문 출력
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		//로그아웃
		http.logout(logout->logout
				 .invalidateHttpSession(true) //현재 브라우저와 연결된 세션 강제종료
				 .deleteCookies("JSESSIONID") //세션 아이디가 저장된 쿠키 삭제
				 .logoutSuccessUrl("/login")); //로그아웃 후 이동할 url 지정
		http.headers(hr->hr.frameOptions(fo->fo.disable()));
		return http.build();
	}
		//h2데이터 베이스에 비밀번호를 암호화해서 저장하기 위한 것이다.
	 @Bean
	 PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
	 }
	//자동 생성 사용자 -메모리 사용자 설정
//	 @Autowired
//	 public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.inMemoryAuthentication()
//		 .withUser("manager")
//		 .password("{noop}abcd")
//		 .roles("MANAGER");
//		 auth.inMemoryAuthentication()
//		 .withUser("admin")
//		 .password("{noop}abcd")
//		 .roles("ADMIN");
//	 }
}