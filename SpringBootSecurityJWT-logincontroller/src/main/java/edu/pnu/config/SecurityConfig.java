package edu.pnu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
   

    @Bean
     PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

 

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	 http.csrf(csrf->csrf.disable()); // CSRF 보호 비활성화
    	 http.authorizeHttpRequests(auth->auth
    	  .requestMatchers("/member/**").authenticated() 
    	 .requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
    	  .requestMatchers("/admin/**").hasRole("ADMIN")
    	  .anyRequest().permitAll());
    	  http.formLogin(frmLogin->frmLogin.disable());
    	  http.httpBasic(basic->basic.disable());
    	  // Form을 이용한 로그인을 사용하지 않겠다는 설정
    	 // Http Basic인증 방식을 사용하지 않겠다는 설정
    	 // 세션을 유지하지 않겠다고 설정 ➔ Url 호출 뒤 응답할 때 까지는 유지되지만 응답 후 삭제된다는 의미.
    	  http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    	  return http.build();
    }
}