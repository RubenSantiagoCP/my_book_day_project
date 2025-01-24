package com.app.mydaybook.activities.domain.model;

import java.util.List;

import com.app.mydaybook.user.domain.model.User;

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

public class Category {
    private Long id;
    private String name;
    private String description;
    private User user;
    private List<Habit> habits;
}
