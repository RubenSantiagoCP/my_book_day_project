package com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskDailyRequest {
    
    @NotNull(message = "taskId is required")
    private Long taskId;

    @NotNull(message = "userId is required")
    private Long userId;

    @NotNull(message = "date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
}
