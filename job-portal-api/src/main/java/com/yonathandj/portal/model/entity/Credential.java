package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "m_credential")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "credential")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",  nullable = false, referencedColumnName = "id")
    private Role role;
}
