package com.yonathandj.portal.model.entity;

import lombok.*;
import java.time.LocalDate;
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

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", nullable = false, referencedColumnName = "id")
    private Gender gender;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id",  nullable = false, referencedColumnName = "id")
    private Credential credential;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_picture_id",  nullable = false, referencedColumnName = "id")
    private UserPicture userPicture;
}
