package com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request;

import java.util.Date;

import com.app.mydaybook.activities.domain.enums.HabitFrequency;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HabitRequest {
    @JsonIgnore
    private Long id;

    @NotBlank(message = "The name is required")
    private String name;

    private String description;

    @NotNull(message = "The start date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @NotNull(message = "The end date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    private HabitFrequency frequency;

    private Long categoryId;

    @NotNull(message = "The user id is required")
    private Long userId;
}
