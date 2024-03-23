package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;
import com.yonathandj.portal.constant.RoleEnum;

@Entity
@Table(name = "m_role")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleEnum role;

    @OneToOne(mappedBy = "role")
    private Credential credential;
}
