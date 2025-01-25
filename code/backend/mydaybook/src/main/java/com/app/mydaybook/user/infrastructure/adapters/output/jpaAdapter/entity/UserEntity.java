package com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyRecordEntity;
import com.app.mydaybook.user.domain.enums.LoginType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "user"
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Size(max = 100)
    private String username;

    @Column
    @Size(max = 100)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column(unique = true, nullable = false)
    @Size(max = 100)
    private String email;

    @Column
    @Size(max = 100)
    private String name;

    @Column
    @Size(max = 100)
    private String surname;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<HabitEntity> habits;

    @OneToMany(mappedBy = "user")
    private List<TaskEntity> tasks;

    @OneToMany(mappedBy = "user")
    private List<CategoryEntity> categories;

    @OneToMany(mappedBy = "user")
    private List<DailyRecordEntity> dailyRecords;

}
