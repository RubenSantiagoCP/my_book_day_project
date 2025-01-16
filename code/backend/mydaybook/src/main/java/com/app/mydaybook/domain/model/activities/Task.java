package com.app.mydaybook.domain.model.activities;

import java.util.Date;

import com.app.mydaybook.domain.enums.TaskFrequency;
import com.app.mydaybook.domain.enums.TaskState;

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
    private Date startDate;
    private Date endDate;
    private int priority;
    private TaskFrequency frequency;
    private TaskState state;
}
