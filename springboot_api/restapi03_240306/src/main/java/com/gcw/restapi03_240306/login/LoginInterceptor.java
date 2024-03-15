package com.gcw.restapi03_240306.login;

import com.gcw.restapi03_240306.exception.ErrorCode;
import com.gcw.restapi03_240306.exception.UsersException;
import com.gcw.restapi03_240306.users.User;
import com.gcw.restapi03_240306.users.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("일로오나");
        String password = request.getHeader("password");
        String email = request.getHeader("email");

        System.out.println(password);
        System.out.println(email);

        User dbuser = userRepository.findByEmailAndPassword(email, password);
        if (dbuser == null) {
            throw new UsersException(ErrorCode.LOGINFAIL);
        }

        return true;
    }
}
