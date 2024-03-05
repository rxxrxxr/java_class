package com.example.restapi01_240304.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainApiController {

    @GetMapping("main/api/aa") // @RequestParam 생략 가능
    public String mainApiaa(String str, String id, String age) {
        System.out.println("id = " + id);
        System.out.println("age = " + age);
        return "문자열이 보내집니다." + str;
    }

}
