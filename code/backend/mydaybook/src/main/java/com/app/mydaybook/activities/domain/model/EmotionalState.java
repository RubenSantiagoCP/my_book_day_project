package com.app.mydaybook.activities.domain.model;

import com.app.mydaybook.activities.domain.enums.Emotion;
import com.app.mydaybook.user.domain.model.User;

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

public class EmotionalState {
    private Long id;
    private Emotion emotion;
    private String comments;
    private User user;
}
