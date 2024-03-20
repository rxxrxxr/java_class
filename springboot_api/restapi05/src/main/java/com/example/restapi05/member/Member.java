package com.example.restapi05.member;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
// DB에 저장하는 클래스
public class Member {

    // primary key 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // null값이 들어오면 insert 실패
    @Column(length = 50, nullable = false)
    private String username;
    private String password;

    // email이 중복이면 insert 실패
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    // USER, ADMIN
    @Enumerated(EnumType.STRING)
    private Role role;

    // insert 한 시간 들어감
    @CreatedDate
    private LocalDateTime writeDate;

    // update한 시간 들어감
    @LastModifiedDate
    private LocalDateTime modifyDate;

}
