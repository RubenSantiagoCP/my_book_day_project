package com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
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
public class CategoryRequest {
    @JsonIgnore
    private Long id;

    @NotBlank(message = "The name is required")
    private String name;
    
    private String description;
}
