package com.mh.restapi02.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http 요청을 처리하고 응답할수 있게하는 어노테이션
@RestController
// final 지정된 필드만 생성자 생성, Allargs...는 모든필드가 대상
@RequiredArgsConstructor
public class MemberController {

    // select... insert...
    private final MemberRepository memberRepository;

    // select 기능 어노테이션
    @GetMapping("member")
    public List<Member> allMember(){
        // select 구문이 실행됩니다..
        // findAll - JpaRespository 에서 제동되는 메서드중 하나로
        // 데이터베이스의 해당 엔티티에 대한 모든 정보를 리스트형태로 변환한다
        List<Member> list = memberRepository.findAll();
        System.out.println(list);
        return list;
    }

    // insert 기능 어노테이션
    @PostMapping("member")
    public Member memberSave(String username, String email){
        System.out.println(username);
        System.out.println(email);
        // insert 구문이 실행됩니다...
        Member member = Member.builder()
                .username(username)
                .email(email)
                .build();
        Member dbmember = memberRepository.save(member);

        return dbmember;
    }

    // update 기능 어노테이션
    @PutMapping("member")
    public Member update(Long id, String username, String email){
        Member member = Member.builder()
                .id(id)
                .username(username)
                .email(email)
                .build();
        Member dbmember = memberRepository.save(member);

        return dbmember;

    }

    // delete 기능 어노테이션
    @DeleteMapping("member")
    public String delete(Long id){
        memberRepository.deleteById(id);
        return "deleted id = " + id;

    }

}
