package org.example.conf;

import org.example.member.MemberRepository;
import org.example.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {
    @Bean
    public MemberRepository memberRepository (){
        MemberRepository memberRepository = new MemberRepository();
        return memberRepository;
    }

    @Bean
    public MemberService memberService(){
        MemberService memberService = new MemberService();
        memberService.
        return memberService;
    }

}
