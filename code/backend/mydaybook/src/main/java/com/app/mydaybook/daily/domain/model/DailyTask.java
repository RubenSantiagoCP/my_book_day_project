package com.app.mydaybook.daily.domain.model;

import java.time.LocalDate;

import com.app.mydaybook.activities.domain.model.Task;
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

public class DailyTask {
    private Long id;
    private LocalDate date;
    private Task task;
    private User user;
}
