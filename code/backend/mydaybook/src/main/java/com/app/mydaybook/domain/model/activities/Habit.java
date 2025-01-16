package com.app.mydaybook.domain.model.activities;

import java.util.Date;

import com.app.mydaybook.domain.enums.HabitFrecuency;
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
    private Date startDate;
    private Date endDate;
    private HabitFrecuency frequency;
    private Category category;
}
