package com.gcw.restapi03_240306.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User regist(User user){

        // insert 구문 실행
        User dbuser = userRepository.save(user);

        return dbuser;

    }

}
