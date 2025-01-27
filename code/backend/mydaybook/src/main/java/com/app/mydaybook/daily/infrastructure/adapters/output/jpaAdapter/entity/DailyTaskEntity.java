package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity;

import java.time.LocalDate;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "daily_entity"
)

@Getter
@Setter
public class DailyTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
