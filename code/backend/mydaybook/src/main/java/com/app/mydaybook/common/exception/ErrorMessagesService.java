package com.app.mydaybook.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.config.ActivitiesErrorCodesConfig;
import com.app.mydaybook.user.config.UserErrorCodesConfig;

@Service
public class ErrorMessagesService {
    private Map<String, String> errorMessages = new HashMap<>();

    public ErrorMessagesService(ActivitiesErrorCodesConfig errorCodesConfig, UserErrorCodesConfig userErrorCodesConfig) {
        errorMessages.putAll(errorCodesConfig.getMessages());
        errorMessages.putAll(userErrorCodesConfig.getMessages());
    }

    public String getMessage(String errorCode){
        return errorMessages.getOrDefault(errorCode, "Unknown error");
    }
}
