package com.example.restapi01_240304.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //ioc컨테이너에 넣기
@RequiredArgsConstructor
public class MainController {

//    @Autowired
//    MainService mainService;

    // Autowired보다 @RequiredArgsConstructor를 써서 객체주입하는것이 권장된다
    private final MainService mainService;
    @GetMapping("main")
    public String main() {
        System.out.println(mainService);
        return "main"; // main.html생성
    }

    @GetMapping("mainapi")
    public @ResponseBody String mainapi(){
        return "mainapi"; // 문자열을 보냄
    }

}
