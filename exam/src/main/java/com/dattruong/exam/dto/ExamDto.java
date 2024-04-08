package com.dattruong.exam.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ExamDto {
    private int id;

    private String type;
    private String title;
    private String content;
    private Timestamp duration;

    private String status;
    private int createdBy;
}
