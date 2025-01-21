package com.app.mydaybook.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.config.ErrorCodesConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ErrorMessagesService {
    private final Map<String, String> errorMessages = new HashMap<>();

    public ErrorMessagesService(ErrorCodesConfig errorCodesConfig) {
        errorMessages.putAll(errorCodesConfig.getMessages());
    }

    public String getMessage(String errorCode){
        return errorMessages.getOrDefault(errorCode, "Unknown error");
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }
}
