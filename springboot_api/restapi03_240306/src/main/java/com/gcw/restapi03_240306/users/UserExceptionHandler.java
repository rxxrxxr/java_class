package com.gcw.restapi03_240306.users;

import com.gcw.restapi03_240306.exception.ErrorResponse;
import com.gcw.restapi03_240306.exception.LogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LogException.class)
    public final ResponseEntity<ErrorResponse> handelLogException(LogException ex){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getErrorCode().getErrorCode())
                .errorMessage(ex.getErrorCode().getMessage())
                .errorDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(errorResponse);
    }

}
