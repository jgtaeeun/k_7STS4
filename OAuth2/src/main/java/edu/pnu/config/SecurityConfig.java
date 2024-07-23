package edu.pnu.config;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.pnu.OAuth2SuccessHandler;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 private final OAuth2SuccessHandler successHandler;

   


   
	 
	 
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		 // 구글 로그인을 실행하면 DefaultOAuth2UserService가 실행됨.
		 // 로그인에 성공했을 때 추가적인 작업이 필요하면 DefaultOAuth2UserService를 상속한 클래스의
		// loadUser 메소드에서 하면 됨.
		 
		
		 
		 
		 http.authorizeHttpRequests(security->security
				 .requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				 .requestMatchers("/admin/**").hasRole("ADMIN")
				 .anyRequest().permitAll());
				 http.csrf(cf->cf.disable());
				 http.formLogin(form->form.loginPage("/login").defaultSuccessUrl("/loginSuccess", true));
					/* http.formLogin(form->{}); */
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));	
		http.logout(logout->logout.invalidateHttpSession(true)
									.deleteCookies("JSESSIONID")
									.logoutSuccessUrl("/login"));
		http.headers(hr->hr.frameOptions(fo->fo.disable()));
		http.oauth2Login(oauth2->oauth2
				 .loginPage("/login")
				 .defaultSuccessUrl("/loginSuccess", true));
		http.oauth2Login(oauth2->oauth2.successHandler(successHandler));
		return http.build(); 
		 
		 
		 
		 
		 
		 }
	
}
