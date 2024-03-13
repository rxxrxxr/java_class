package com.gcw.restapi03_240306.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 스프링의 빈으로 등록하여 데이터베이스와 상호작용하는 클래스임을 나타낸다
@Repository
// JpaRepository에 상속
public interface UserRepository extends JpaRepository<User,Long> {
    // findAll(), save(), findById() 이런것들을 쓸수있게 된다



    // findByEmail 메서드를 선언, 주어진 이메일에 해당하는 사용자를 조회하여 반환한다
    // Jpa라서 자동으로 쿼리문을 생성한다
    // select * from user where email = ?;
    public User findByEmail(String email);
}
