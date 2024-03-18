package com.example.restapi05.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // MockMvc를 사용하기 위한 어노테이션
class MemberControllerTest {

    // post
    @Autowired
    MockMvc mockMvc;

    @Test
    void member() throws Exception {

        ResultActions resurtActions = mockMvc.perform(MockMvcRequestBuilders.get("/member"));

        resurtActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("member"));

    }
}