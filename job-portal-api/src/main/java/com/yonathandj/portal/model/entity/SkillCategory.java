package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "m_skill_category")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SkillCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
}