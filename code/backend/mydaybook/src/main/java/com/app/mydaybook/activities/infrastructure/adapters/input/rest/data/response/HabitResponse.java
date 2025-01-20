package com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response;

import java.util.Date;

import com.app.mydaybook.activities.domain.enums.HabitFrequency;
import com.app.mydaybook.activities.domain.model.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HabitResponse {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private HabitFrequency frequency;
    private Category category;
}
