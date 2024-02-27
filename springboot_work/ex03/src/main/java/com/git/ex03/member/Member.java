package com.git.ex03.member;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member {
    private int idx;
    private String email;
    private String password;
    private LocalDate localDate;
}
