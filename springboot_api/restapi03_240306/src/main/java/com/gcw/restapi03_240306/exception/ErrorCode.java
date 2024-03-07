package com.gcw.restapi03_240306.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    DUPLICATE(HttpStatus.BAD_REQUEST, "A001", "중복된내용이 있습니다"),
    NOTFOUND(HttpStatus.NOT_FOUND, "B001", "내용이 없습니다"),
    TEST(HttpStatus.NOT_ACCEPTABLE, "C001", "Test입니다")
    ;

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
