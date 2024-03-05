package com.mh.restapi02.member;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Date = getter setter equals hashCode toString이 포함된 어노테이션
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    // primary key 역할을 함
    @Id
    // Mysql에서 auto_incrememt와 같은 역할을 한다
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

}
