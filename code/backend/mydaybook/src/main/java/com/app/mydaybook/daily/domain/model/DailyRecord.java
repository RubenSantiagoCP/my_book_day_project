package com.app.mydaybook.daily.domain.model;

import java.time.LocalDate;

import com.app.mydaybook.user.domain.model.User;

//import com.app.mydaybook.activities.domain.model.EmotionalState;

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
    private LocalDate date;
    //private EmotionalState emotionalState;
    private String notes;
    private User user;

    public Long getUserId() {
        return user.getId();
    }
}
