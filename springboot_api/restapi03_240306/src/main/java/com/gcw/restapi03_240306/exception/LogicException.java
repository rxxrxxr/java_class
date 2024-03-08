package com.gcw.restapi03_240306.exception;


import lombok.Getter;

@Getter
public class LogicException extends RuntimeException{

    private ErrorCode errorCode;

    public LogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
