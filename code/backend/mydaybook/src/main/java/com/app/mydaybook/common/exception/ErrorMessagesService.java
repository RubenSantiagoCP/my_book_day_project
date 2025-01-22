package com.app.mydaybook.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.config.ActivitiesErrorCodesConfig;

@Service
public class ErrorMessagesService {
    private Map<String, String> errorMessages = new HashMap<>();

    public ErrorMessagesService(ActivitiesErrorCodesConfig errorCodesConfig) {
        errorMessages.putAll(errorCodesConfig.getMessages());
    }

    public String getMessage(String errorCode){
        return errorMessages.getOrDefault(errorCode, "Unknown error");
    }
}
