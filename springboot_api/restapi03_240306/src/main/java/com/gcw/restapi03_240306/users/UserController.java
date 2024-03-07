package com.gcw.restapi03_240306.users;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    /*
        get 사용자 조회
        post 사용자 등록
        put 사용자 수정
        delete 사용자 삭제
     */
    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> list = userService.getAllUsers();

        return ResponseEntity.ok(list);

//        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserDto userDto) {

//        User user = UserDto.of(userDto);

        userDto.setWdate(LocalDateTime.now());

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);

        User dbuser = userService.regist(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(dbuser);
    }

}

