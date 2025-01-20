package com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request;

import java.time.LocalDateTime;

import com.app.mydaybook.activities.domain.enums.TaskFrequency;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.AssertTrue;
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

public class TaskRequest {
    @JsonIgnore
    private Long id;
    
    @NotBlank(message = "The title is required")
    private String title;

    private String description;

    @NotNull(message = "The start date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @NotNull
    private int priority;

    private TaskFrequency frequency;

    @AssertTrue(message = "End time must be after start time")
    public boolean isEndTimeAfterStartTime() {
        return startDate != null && endDate != null && endDate.isAfter(startDate);
    }
}
