package com.example.restapi05.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 저장하는 메서드
    // email 중복체크후 중복이면 에러로 빠진다
    public Member save(Member member) {

        Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());

        // inPresent - optionalMember에 이미 존재하면
        if (optionalMember.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원 입니다.");
        }

        return memberRepository.save(member);
    }

}
