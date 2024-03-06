package com.gcw.restapi03_240306.users;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("users")
    public User addUser(@RequestBody User requser) {

        User user = User.builder()
                .email(requser.getEmail())
                .gender(requser.getGender())
                .password(requser.getPassword())
                .username(requser.getUsername())
                .wdate(LocalDateTime.now())
                .build();
        User dbuser = userService.regist(user);

        return dbuser;
    }

}
