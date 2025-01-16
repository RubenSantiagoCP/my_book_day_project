package com.app.mydaybook.daily.domain.model;

import com.app.mydaybook.activities.domain.model.Habit;

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
