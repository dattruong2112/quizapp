package com.dattruong.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private int groupId;

    private String username;

    private String email;
    private String firstName;
    private String lastName;

}
