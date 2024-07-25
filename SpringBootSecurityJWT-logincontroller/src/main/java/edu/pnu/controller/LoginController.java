package edu.pnu.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


import edu.pnu.domain.Member;
import edu.pnu.service.SecurityUserDetailsService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class LoginController {


    private final SecurityUserDetailsService UserDetailsService;

   

    @PostMapping("/login")
    public ResponseEntity<?> loginProc(@RequestBody Member member) {
        try {
        	 User user = (User) UserDetailsService.loadUserByUsername(member.getUsername()); 
        	System.out.println(user);
            
            String token = JWT.create()
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                    .withClaim("username", user.getUsername())
                    .sign(Algorithm.HMAC256("edu.pnu.jwt"));

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .build();

        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Authentication failed: " + e.getMessage());
        }
    }
   
}