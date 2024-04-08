package com.dattruong.user.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private List<ExamDto> exams;
}
