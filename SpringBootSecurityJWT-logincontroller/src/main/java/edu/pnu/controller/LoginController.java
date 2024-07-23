package edu.pnu.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


import edu.pnu.domain.Member;



@RestController
public class LoginController {


    private final AuthenticationManager authenticationManager;

    public LoginController( AuthenticationManager authenticationManager) {
        
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginProc(@RequestBody Member member) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword()));
            User user = (User) auth.getPrincipal();

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