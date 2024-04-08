package com.dattruong.user.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ExamDto {
    private Integer id;
    private String type;
    private String title;
    private String content;
    private Timestamp duration;
    private String status;
}
