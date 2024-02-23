package org.example.member;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository  = memberRepository;
    }

    public void regist(MemberDto memberDto) {
        Member member = new Member(
                0,
                memberDto.getEmail(),
                memberDto.getName(),
                memberDto.getPassword(),
                memberDto.getConfirmPassword(),
                LocalDate.now()
        );

        memberRepository.insert(member);

    }

    public void list(){
        Collection<Member> collection =  memberRepository.select();
        collection.stream().forEach(System.out::println);
    }
}
