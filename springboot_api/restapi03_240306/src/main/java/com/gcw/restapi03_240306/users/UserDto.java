package com.gcw.restapi03_240306.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private Long id;

    @NotBlank
    private String username;
    private String email;
    private String password;
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

//    public static User of(UserDto userDto){
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setUsername(user.getUsername());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setGender(userDto.getGender());
//        user.setWdate(LocalDateTime.now());
//
//        return user;
//    }

}
