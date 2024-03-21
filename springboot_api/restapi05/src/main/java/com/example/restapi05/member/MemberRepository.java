package com.example.restapi05.member;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// CRUD 자동 생성
public interface MemberRepository extends JpaRepository<Member, Long> {

    // select * from member where email= ?
    // 해당하는 email 이 있는지 검사하는 메서드
    Optional<Member> findByEmail(String email);

    // select * from member where email =? and password =?
    Member findByEmailAndPassword(String email, String password);
}
