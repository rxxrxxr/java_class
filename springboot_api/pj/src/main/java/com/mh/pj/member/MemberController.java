package com.mh.pj.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    // select... insert...
//    @Autowired
    private final MemberRepository memberRepository;

    @GetMapping("auth")
    public String auth(Authentication authentication){
        System.out.println(authentication.getPrincipal());
        return "auth";
    }

    @GetMapping("member")
    public List<Member> allMember(){
        // select 구문이 실행됩니다..
        List<Member> list = memberRepository.findAll();
        System.out.println(list);
        return list;
    }

    @PostMapping("member")
    public Member memberSave(String username,String email){
        System.out.println(username);
        System.out.println(email);

        Member member = Member.builder()
                .username(username)
                .email(email)
                .build();
        Member dbMember = memberRepository.save(member);
        return dbMember;
    }

    @PutMapping("member")
    public Member update(Long id, String username, String email){
        Member member = Member.builder()
                .id(id)
                .username(username)
                .email(email)
                .build();
        Member dbMember = memberRepository.save(member);
        return dbMember;
    }

    @DeleteMapping("member")
    public String delete(Long id){
        memberRepository.deleteById(id);
        return "deleted id = "+id;
    }

}
