package com.app.mydaybook.daily.domain.model;

import com.app.mydaybook.activities.domain.model.Task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class DailyTask {
    private Long id;
    private DailyRecord dailyRecord;
    private Task task;
    private boolean isCompleted;
}
