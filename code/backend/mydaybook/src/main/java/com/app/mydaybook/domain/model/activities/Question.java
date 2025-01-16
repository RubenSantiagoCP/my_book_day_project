package com.app.mydaybook.domain.model.activities;
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
public class Question {
    private Long id;
    private String question;
    private boolean isActive;
}
