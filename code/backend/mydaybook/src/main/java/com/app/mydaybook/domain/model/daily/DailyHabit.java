package com.app.mydaybook.domain.model.daily;

import com.app.mydaybook.domain.model.activities.Habit;
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

public class DailyHabit {
    private Long id;
    private DailyRecord dailyRecord;
    private Habit habit;
    private boolean isCompleted;
}
