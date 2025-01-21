package com.app.mydaybook.common.exception;

import org.springframework.stereotype.Component;

import com.app.mydaybook.common.enums.exception.ErrorCode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ExceptionManager {
    
    private final ErrorMessagesService errorMessagesService;

    public CustomException createException(ErrorCode errorCode){
        System.out.println(errorMessagesService.getErrorMessages());
        String message = errorMessagesService.getMessage(errorCode.toString());
        return new CustomException(errorCode.toString(), message);
    }
}
