package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class customconfig {
	//	SecurityConfig의 passwordEncoder 와 OAuth2SuccessHandler의 passwordEncoder의 충돌로 인해 순환이 이뤄진다. 그래서 따로 빼서 둔다.
	 @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
