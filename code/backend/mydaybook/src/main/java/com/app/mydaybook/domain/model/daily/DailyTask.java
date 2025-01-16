package com.app.mydaybook.domain.model.daily;

import com.app.mydaybook.domain.model.activities.Task;
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
