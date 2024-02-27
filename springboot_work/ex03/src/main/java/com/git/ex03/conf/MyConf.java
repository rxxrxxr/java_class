package com.git.ex03.conf;

import com.git.ex03.member.MemberController;
import com.git.ex03.member.MemberRepository;
import com.git.ex03.member.MemberService;
import com.git.ex03.myanno.ManualBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
/*
    memberController
    memberService
    memberRepository
    Member

    regist ->
    List ->

 */

// 환경설정
@Configuration
@ComponentScan(value = "aa.bb.cc",
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class)
        })
public class MyConf {

    @Bean
    public MemberService MemberRepository() {
        return new MemberService();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

}
