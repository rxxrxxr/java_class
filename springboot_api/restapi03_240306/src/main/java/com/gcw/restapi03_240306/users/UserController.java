package com.gcw.restapi03_240306.users;

import com.gcw.restapi03_240306.exception.ErrorCode;
import com.gcw.restapi03_240306.exception.UsersException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.UserTransaction;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Tag(name = "User-Controller", description = "유저 조회 등록 수정 삭제")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("usernameemail")
    public ResponseEntity<List<User>> getAllUserName(@RequestBody UserDto userDto){
        List<User> list = (List<User>) userRepository.findByUsernameContainingOrEmailContaining(userDto.getUsername(),userDto.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(summary = "사용자 전체 목록 보기", description = "사용자 전체 정보를 조회할 수 있습니다.")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "ok"), @ApiResponse(responseCode = "404", description = "사용자들이 없을때 나옵니다."),})
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        if (list.size() == 0) throw new UsersException(ErrorCode.NOTFOUND);
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@Parameter(description = "조회하고자 하는 사용자 ID 입력하세요", name = "사용자 ID", required = true) @PathVariable Long id) {
        System.out.println(id);

        User user = userService.getUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping()
    public EntityModel<User> addUser(@RequestBody @Valid UserDto userDto) {
        userDto.setWdate(LocalDateTime.now());

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);

        User dbuser = userService.regist(user);

        EntityModel<User> userEntityModel = EntityModel.of(dbuser);
        userEntityModel.add(
                WebMvcLinkBuilder.linkTo(UserController.class)
                        .slash("/users")
                        .slash(dbuser.getId())
                        .withSelfRel()
        );

        return userEntityModel;
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);
        user.setWdate(LocalDateTime.now());

        User dbUser = userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

    @DeleteMapping("all")
    public ResponseEntity<String> deleteUserAll(@PathVariable Long id) {
        userService.delete();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

    //영속성에 의해서 setter 메서드 사용시  dbUpdate 실행
    //jakarta 속성 말고 springboot 속성으로 import
    @Transactional(readOnly = true)
    @GetMapping("tran")
    public String userstran() {

        User dbUser = userRepository.findById(1L).orElseThrow();
        //업데이트 구문
        dbUser.setUsername("김길동");
        //업데이트 구문
        dbUser.setEmail("aa@naver.com");

        return "tran";
    }

}

