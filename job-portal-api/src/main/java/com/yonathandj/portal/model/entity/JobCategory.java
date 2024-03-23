package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "m_job_category")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class JobCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}