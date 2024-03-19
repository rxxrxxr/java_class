package com.example.restapi05.todo;

import com.example.restapi05.member.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String todo;

    @ManyToOne
    private Member member;

}
