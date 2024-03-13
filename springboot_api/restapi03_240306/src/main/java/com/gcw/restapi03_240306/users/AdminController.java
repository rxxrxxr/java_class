package com.gcw.restapi03_240306.users;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.gcw.restapi03_240306.exception.ErrorCode;
import com.gcw.restapi03_240306.exception.UsersException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;

    @GetMapping("users/{id}")
    public MappingJacksonValue getUserById(@PathVariable Long id) {

//        Optional<User> user = userRepository.findById(id);
//        if (user.isEmpty()){
//            throw new UsersException(ErrorCode.NOTFOUND);
//        }

//        다른 방법
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsersException(ErrorCode.NOTFOUND)
        );

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(user, adminUser);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(adminUser);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AdminUser",
                SimpleBeanPropertyFilter.filterOutAllExcept("username", "email", "password")
        );
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @DeleteMapping("users/{id}")
    public User deleteUserById(Long id) {

        return new User();
    }


}
