package com.dattruong.exam.service;

import com.dattruong.exam.dto.ExamDto;

import java.util.List;


public interface IExamService {
    void createExam(String quizCorrelationId,ExamDto examsDto);
    List<ExamDto> fetchExamByCreatedUser(int userId);
    List<ExamDto> findAll();

}
