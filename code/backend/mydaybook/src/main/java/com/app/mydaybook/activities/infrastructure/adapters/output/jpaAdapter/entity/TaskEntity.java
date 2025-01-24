package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity;

import java.time.LocalDateTime;

import com.app.mydaybook.activities.domain.enums.TaskFrequency;
import com.app.mydaybook.activities.domain.enums.TaskState;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "task",
    uniqueConstraints = @UniqueConstraint(columnNames = {"title", "startDate"})
)

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 100)
    private String title;

    @Column
    @Size(max = 500)
    private String description;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskFrequency frequency;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskState state;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
