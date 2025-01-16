package com.app.mydaybook.daily.domain.model;

import com.app.mydaybook.activities.domain.model.EmotionalState;

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

public class DailyRecord {
    private Long id;
    private String date;
    private EmotionalState emotionalState;
    private String notes;
}
