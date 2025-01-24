package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity;

import java.util.List;

import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    name = "category"
)

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Size(max = 100)
    private String name;

    @Column
    @Size(max = 500)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<HabitEntity> habits;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
