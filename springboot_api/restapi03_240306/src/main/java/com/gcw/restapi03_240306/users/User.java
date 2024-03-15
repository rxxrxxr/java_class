package com.gcw.restapi03_240306.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


// 데이터 베이스의 테이블과 매핑되며 해당 테이블에 대한 CRUD 작업을 수행할 수 있다.
// 쓸 수 있는 어노테이션
// @Table = 특정 테이블의 이름을 지정하고 싶을때
// @Id = 기본 키(primary key) 필드를 지정한다
// @GenerateValue = 보통 auto-increment 를 쓸때 사용한다
// @column = 특정 컬럼의 이름, 유니크 여부, 길이를 설정할 수 있다
@Entity
// 문자열 표현을 자동으로 생성해준다
@ToString
//
@Getter
//
@Setter
//
@Builder
//
@AllArgsConstructor
//
@NoArgsConstructor
@Table(name = "users")
@Schema(description = "User Table 에 대한 내용입니다.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "사용자 ID", description = "table 에서 자동으로 생성되는 컬럼입니다.")
    private Long id;

    @Column(length = 50)
    @Schema(title = "사용자 username", description = "시용자 이름을 넣어주시면 됩니다.")
    private String username;

    @Column(length = 50, unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String grade;

    // @Enumerated(EnumType.ORDINAL) male = 0 , female = 1
    // @Enumerated(EnumType.STRING) => Male,feMale
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

}
