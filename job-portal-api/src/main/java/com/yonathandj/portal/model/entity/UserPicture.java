package com.yonathandj.portal.model.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "m_user_picture")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "file_name", unique = true)
    private String fileName;

    @Column(name = "path_name", unique = true)
    private String pathName;

    @OneToOne(mappedBy = "userPicture")
    private User user;
}
