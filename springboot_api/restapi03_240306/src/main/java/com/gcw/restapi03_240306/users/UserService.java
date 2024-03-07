package com.gcw.restapi03_240306.users;

import com.gcw.restapi03_240306.exception.ErrorCode;
import com.gcw.restapi03_240306.exception.LogException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User regist(User user){

        User emailUser = userRepository.findByEmail(user.getEmail());
        if (emailUser != null){
            System.out.println(user.getEmail() + "중복되는 이메일이 있습니다");
            throw new LogException(ErrorCode.DUPLICATE);
        }

        // insert 구문 실행...
        User dbUser = userRepository.save(user);
        return dbUser;
    }

    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
