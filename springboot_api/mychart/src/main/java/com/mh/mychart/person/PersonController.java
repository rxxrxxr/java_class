package com.mh.mychart.person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonSerivce personSerivce;

    @GetMapping("/one/{id}")
    public PersonDto getPersonById(@PathVariable Long id) {
        return personSerivce.getPersonById(id);
    }

}
