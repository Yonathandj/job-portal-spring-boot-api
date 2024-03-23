package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "m_profile_picture")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "file_name", unique = true)
    private String fileName;

    @Column(name = "path_name", unique = true)
    private String pathName;

    @OneToOne(mappedBy = "profilePicture")
    private Applicant applicant;

    @OneToOne(mappedBy = "profilePicture")
    private Employer employer;
}
