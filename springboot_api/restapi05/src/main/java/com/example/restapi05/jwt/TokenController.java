package com.example.restapi05.jwt;

import com.example.restapi05.member.Member;
import com.example.restapi05.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenManager tokenManager;
    private final MemberRepository memberRepository;

    @GetMapping("/token")
    public String token(@RequestBody TokenDto tokenDto) {
        System.out.println("email = " + tokenDto.getEmail());
        System.out.println("password = " + tokenDto.getPassword());
        Member dbmember = memberRepository.findByEmailAndPassword(tokenDto.getEmail(), tokenDto.getPassword());
        if (dbmember == null){
            throw new RuntimeException("인증안됨");
        }
        return tokenManager.generateToken(dbmember);
    }

    @GetMapping("/valid")
    public String valid(HttpServletRequest request){

        String auth = request.getHeader("Authorization");
        System.out.println(auth);

//        tokenManager.validateToken("eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtaFRva2VuIiwiaWQiOjEsInVzZXJuYW1lIjoi7ZmN6ri464-ZIiwicm9sZSI6IlVTRVIiLCJlbWFpbCI6ImFhYUBuYXZlci5jb20iLCJleHAiOjE3MTA5ODMzNjF9.JEIux5Tac-1pUFaRt8ByoDWJlENI9xo_j9LEL9aOaAJZxyNoaPJiYCgvl0Wnxi6S");

        return "valid";
    }

    @GetMapping("auth")
    public String loginTest(Authentication authentication) {
        System.out.println(authentication);
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());
        return "loginTest";
    }
}
