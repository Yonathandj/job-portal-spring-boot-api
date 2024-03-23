package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;

import com.yonathandj.portal.constant.GenderEnum;

@Entity
@Table(name = "m_gender")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, unique = true)
    private GenderEnum gender;

    @OneToOne(mappedBy = "gender")
    private Applicant applicant;
}
