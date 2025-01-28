package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter;

import org.springframework.stereotype.Component;

import com.app.mydaybook.daily.application.ports.output.IDailyTaskCommPersitentPort;
import com.app.mydaybook.daily.domain.model.DailyTask;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyTaskEntity;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.mapper.IDailyTaskJpaMapper;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository.IDailyTaskRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DailyTaskCommandAdapter implements IDailyTaskCommPersitentPort{
    
    private final IDailyTaskRepository dailyTaskRepository;
    private final IDailyTaskJpaMapper dailyTaskJpaMapper;


    @Override
    public void markTaskDone(DailyTask dailyTask) {
        DailyTaskEntity dailyTaskEntity = dailyTaskRepository.findByDateAndUserIdAndTaskId(dailyTask.getDate(), dailyTask.getUser().getId(), dailyTask.getTask().getId());
        if(dailyTaskEntity==null){
            dailyTaskEntity = dailyTaskJpaMapper.toDailyTaskEntity(dailyTask);
            dailyTaskEntity = dailyTaskRepository.save(dailyTaskEntity);
        }
    }

    @Override
    public void markTaskUndone(DailyTask dailyTask) {
        DailyTaskEntity dailyTaskEntity = dailyTaskRepository.findByDateAndUserIdAndTaskId(dailyTask.getDate(), dailyTask.getUser().getId(), dailyTask.getTask().getId());
        if(dailyTaskEntity!=null){
            dailyTaskRepository.delete(dailyTaskEntity);;
        }
    }
}
