package com.example.restapi05.jwt;

import com.example.restapi05.member.Member;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {
    @Value("${spring.jwt.secret}")
    private String mykey;

    // 토큰 만들어주는 함수
    public String generateToken(Member member) {
        return Jwts.builder()
                .subject("gcwToken")
                .claim("id", member.getId())
                .claim("username", member.getUsername())
                .claim("role", member.getRole())
                .claim("email", member.getEmail())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512,mykey.getBytes())
                .compact();
    }

    public String validateToken(String password) {
        return null;
    }

    // 토큰 검증해주는 함수

}
