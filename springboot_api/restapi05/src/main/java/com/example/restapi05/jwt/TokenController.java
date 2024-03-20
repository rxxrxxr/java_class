package com.example.restapi05.jwt;

import com.example.restapi05.member.Member;
import com.example.restapi05.member.MemberRepository;
import com.example.restapi05.member.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.Advice;
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
        System.out.println(tokenDto.getEmail());
        System.out.println(tokenDto.getPassword());
        Member member = memberRepository.finByEmailAndPassword(tokenDto.getEmail(), tokenDto.getPassword());
//        Member member = Member.builder()
//                .email("aaa@naver.com")
//                .id(1l)
//                .username("홍길동")
//                .role(Role.USER)
//                .build();
        if ( = null){
            throw new RuntimeException("인증안됨");
        }
        return tokenManager.generateToken(member);

    }

}
