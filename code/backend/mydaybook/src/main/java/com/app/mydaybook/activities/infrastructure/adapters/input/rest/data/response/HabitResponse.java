package com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response;

import java.time.LocalDateTime;

import com.app.mydaybook.activities.domain.enums.HabitFrequency;
import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private HabitFrequency frequency;
    
    private Long categoryId;

    private Long userId;
}
