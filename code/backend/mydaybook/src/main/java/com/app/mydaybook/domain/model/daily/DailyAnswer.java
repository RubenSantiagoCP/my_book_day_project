package com.app.mydaybook.domain.model.daily;

import com.app.mydaybook.domain.model.activities.Question;
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

public class DailyAnswer {
    private Long id;
    private DailyRecord dailyRecord;
    private Question question;
    private String answer;
}
