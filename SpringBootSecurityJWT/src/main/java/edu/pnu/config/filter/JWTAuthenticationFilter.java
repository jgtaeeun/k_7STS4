package edu.pnu.config.filter;

import java.io.IOException;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.domain.Member;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	//인증객체
	private final AuthenticationManager authenticationManager;
	private final Logger log = LoggerFactory.getLogger(getClass()); // Logger 초기화
	
	//post/login 요청이 왔을 때 인증을 시도하는 메소드
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		//request에서 json타입의 username/password읽어서 member객체를 생성한다
		 ObjectMapper mapper = new ObjectMapper();
		 try {
		 Member member = mapper.readValue(request.getInputStream(), Member.class);
		 // Security에게 자격 증명 요청에 필요한 객체 생성
		Authentication authToken = new UsernamePasswordAuthenticationToken(
		 member.getUsername(), member.getPassword());
		 // 인증 진행-> UserDetailsService의 loadUserByUsername에서 DB로부터 사용자 정보를 읽어온 뒤
		// 사용자 입력 정보와 비교한 뒤 자격 증명에 성공하면 Authenticaiton객체를 만들어서 리턴한다.
		 return  authenticationManager.authenticate(authToken);
		 } catch (Exception e) {
		 log.info(e.getMessage()); // “자격 증명에 실패하였습니다.” 로그 출력
		}
		 response.setStatus(HttpStatus.UNAUTHORIZED.value());
		 return null;
	}
	
	//인증 성공했을 때 실행되는 후처리 메서도(토큰을 만든다.)
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//자격증명 성공하면 loadUserByUsername에서 만든 객체가 authResult에 담겨져 있다
		User user = (User)authResult.getPrincipal();
		
		System.out.println(user);
		// username으로 JWT를 생성해서 Response Header - Authorization에 담아서 돌려준다
		 String token = JWT.create()
				 .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*10))
				 .withClaim("username", user.getUsername())
				 .sign(Algorithm.HMAC256("edu.pnu.jwt"));
				 response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
				 response.setStatus(HttpStatus.OK.value());
	}
}
