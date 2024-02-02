package org.example.member;

import java.util.Scanner;

public class MemberCLI {

    public Member inputMember(){   // 회원가입 매서드
        Scanner scan = new Scanner(System.in);

        System.out.println("이메일을 입력 하세요.");
        String email = scan.nextLine();
        System.out.println("주소을 입력 하세요.");
        String addr = scan.nextLine();
        System.out.println("이름을 입력 하세요.");
        String name = scan.nextLine();
        System.out.println("패스워드를 입력 하세요.");
        String password = scan.nextLine();

//        return new Member(email,null,null, password);

        // builder를 활용한 맴버 객체 생성
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .addr(addr)
                .build();
    }

    public Member loginMember(){ // 로그인 매서드
        Scanner scan = new Scanner(System.in);

        System.out.println("이메일을 입력 하세요.");
        String email = scan.nextLine();
        System.out.println("패스워드를 입력 하세요.");
        String password = scan.nextLine();

        // builder를 활용한 맴버 객체 생성 email과 password를 설정한후 build 메서드를 호출하여 Member객체를 생성하고 반환
        return Member.builder()
                .email(email)
                .password(password)
                .build();
//        return new Member(email,null,null, password);
    }
}
