package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity;

import java.time.LocalDate;

import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "daily_record"
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DailyRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;
    //private EmotionalState emotionalState;

    @Column
    @Size(max = 5000)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}