package com.mh.pj.jwt;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private String errorCode;
    private String message;

    public static ErrorResponse of(ErrorCode errorCode){
        return ErrorResponse.builder()
                .errorCode(errorCode.getHttpStatus().toString())
                .message(createErrorMessage(errorCode))
                .build();
    }

    public static String createErrorMessage(ErrorCode code)
    {
        return String.format("[ %s %s]",code.getMessage(),code.getDesc());
    }
}
