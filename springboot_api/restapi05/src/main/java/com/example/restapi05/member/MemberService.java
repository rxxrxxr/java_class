package com.example.restapi05.member;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// MemberService 는 UserDetailsService 이다
// 그러므로 spring security 에서 자동으로 등록된다
@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("일로오나111");
        return null;
    }
}
