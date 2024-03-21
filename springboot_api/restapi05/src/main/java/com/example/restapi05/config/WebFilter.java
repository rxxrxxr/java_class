package com.example.restapi05.config;

import com.example.restapi05.jwt.TokenManager;
import com.example.restapi05.member.Member;
import com.example.restapi05.member.MemberRepository;
import com.example.restapi05.member.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class WebFilter extends OncePerRequestFilter {

    private final TokenManager tokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("필터동작");
        String myheader = request.getHeader("my-header");
        System.out.println(myheader);

        String token = request.getHeader("Authorization");
        String address = request.getRequestURI();

        String url = request.getRequestURI();

        if (url.contains("login") || url.contains("join") || url.contains("token")) {

            filterChain.doFilter(request, response);
            return;
        }

        try {
            Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer ".length()));

            List<SimpleGrantedAuthority> roles = (List<SimpleGrantedAuthority>) jws.getBody().get("role");

            System.out.println(roles);

            // 로그인한 유저 정보를 authentication에 저장해라
            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                    Member.builder()
                            .email(jws.getPayload().get("email").toString())
                            .username(jws.getPayload().get("username").toString())
                            .id(jws.getPayload().get("id",  Long.class))
                            .role(
                                   Role.fromString(jws.getPayload().get("role").toString())
                            )
                            .build(),null,roles

            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 원래 요청대로 진행해라
            // 게시글을 작성을 할때
            // 로그인했을경우 작성자를 자동으로 등록되도록 만들고 싶다
            filterChain.doFilter(request, response);

        }catch (ExpiredJwtException e){
            System.out.println("토큰 만료");
            throw new RuntimeException("JWT 토큰 만료");
        }catch (Exception e){
            System.out.println("토큰검증 실패");
            throw new RuntimeException("JWT 토큰 만료");
        }

        if (token == null || !token.startsWith("Bearer ")){
            System.out.println("token이 없습니다");
            throw new RuntimeException("token이 없습니다");
        }

        // 그다음으로 이동해서 진행해라 member -> test -> todo
//        filterChain.doFilter(request, response);
    }
}
