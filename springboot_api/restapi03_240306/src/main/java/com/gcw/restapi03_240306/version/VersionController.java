package com.gcw.restapi03_240306.version;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class VersionController {

    @GetMapping("hello")
    public String hello() {


        return "hello1";
    }

}
