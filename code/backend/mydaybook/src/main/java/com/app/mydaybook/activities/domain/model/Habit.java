package com.app.mydaybook.activities.domain.model;

import java.time.LocalDateTime;

import com.app.mydaybook.activities.domain.enums.HabitFrequency;
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

public class Habit {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private HabitFrequency frequency;
    private Category category;
    private User user;
}
