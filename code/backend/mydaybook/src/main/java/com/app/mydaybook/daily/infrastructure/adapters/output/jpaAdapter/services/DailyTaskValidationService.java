package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.services;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ITaskRepository;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.daily.domain.model.DailyTask;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyTaskValidationService implements IDailyTaskValidationService {

    private final IUserRepository userRepository;
    private final ITaskRepository taskRepository;
    private final ExceptionManager exceptionManager;

    @Override
    public void validateUserAndTask(DailyTask dailyTask) {
        UserEntity userEntity = userRepository.findById(dailyTask.getUser().getId())
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.USER_NOT_FOUND));

        TaskEntity taskEntity = taskRepository.findById(dailyTask.getTask().getId())
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.TASK_NOT_FOUND));

        if (!taskEntity.getUser().getId().equals(userEntity.getId())) {
            throw exceptionManager.createException(ErrorCode.TASK_DONE_BY_OTHER_USER);
        }
    }
    
}
