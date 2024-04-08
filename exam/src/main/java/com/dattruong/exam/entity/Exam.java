package com.dattruong.exam.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Exam {
    @Id
    private int id;

    private String type;
    private String title;
    private String content;
    private Timestamp duration;

    private String status;

    @Column(name = "created_by")
    private int userId;

}
