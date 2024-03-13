package com.gcw.restapi03_240306.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HeaderController {

    @GetMapping(value = "header", headers = "v1=1")
    public String paramV1() {
        return "headerV1";
    }

    @GetMapping(value = "header", headers = "v1=2")
    public String paramV2() {
        return "headerV2";
    }
}
