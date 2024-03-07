package com.gcw.restapi03_240306.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // findAll(), save(), deletefyId()

    // select * from user where email 자동생성
    public User findByEmail(String email);
}
