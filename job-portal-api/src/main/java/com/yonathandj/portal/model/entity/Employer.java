package com.yonathandj.portal.model.entity;

import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "m_employer")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "establishment_date", nullable = false)
    private LocalDate establishmentDate;

    @Column(name = "website_url", nullable = false)
    private String websiteUrl;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id", nullable = false, referencedColumnName = "id")
    private Credential credential;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_picture_id", referencedColumnName = "id")
    private ProfilePicture profilePicture;
}
