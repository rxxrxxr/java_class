package com.example.restapi05.member;

import jakarta.security.auth.message.callback.PrivateKeyCallback;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.crypto.ExemptionMechanism;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public String member(Authentication authentication) {
        Member member = (Member) authentication.getAuthorities();

        return "getMember email = " + member.getUsername()
                + " : username : " + member.getUsername()
                + " : role : " + member.getRole();
    }

    @PostMapping("")
    public String member(@Valid @RequestBody MemberDTO memberDTO) {
        System.out.println(memberDTO);
        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDTO, Member.class);
        memberService.save(member);
        return "member";
    }

}
