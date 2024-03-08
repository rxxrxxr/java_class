package com.gcw.restapi03_240306.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // findAll(), save(), findById()

    // select * from user where email = ?;
    public User findByEmail(String email);
}
