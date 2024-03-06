package com.gcw.restapi03_240306.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// 테이블 생성
@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 테이블 이름 변경
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String username;

    // unique = insert 중복체크
    @Column(length = 50, unique = true)
    private String email;
    private String password;

    // .ordinal = male = 0, femaie = 1
    // .String = male, female
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

}