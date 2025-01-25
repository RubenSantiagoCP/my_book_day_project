package com.app.mydaybook.user.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.user.domain.enums.LoginType;

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
public class User {
    
    private Long id;
    private String username;
    private String password;
    private LoginType loginType;
    private String email;
    private String name;
    private String surname;
    private LocalDateTime createdAt;

    private List<Habit> habits;
    private List<Task> tasks;
    private List<Category> categories;
    private List<DailyRecord> dailyRecords;
}
