package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "m_user")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id", referencedColumnName = "id")
    private Credential credential;
}
