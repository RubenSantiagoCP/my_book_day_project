package com.app.mydaybook.activities.domain.model;

import java.time.LocalDateTime;
import com.app.mydaybook.activities.domain.enums.TaskFrequency;
import com.app.mydaybook.activities.domain.enums.TaskState;
import com.app.mydaybook.user.domain.model.User;

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

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private TaskFrequency frequency;
    private TaskState state;
    private User user;

    public Long getUserId() {
        return user.getId();
    }
}
