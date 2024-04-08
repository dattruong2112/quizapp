package com.dattruong.exam.mapper;

import com.dattruong.exam.dto.ExamDto;
import com.dattruong.exam.entity.Exam;

public class ExamMapper {
    public static ExamDto mapToExamDto(Exam exam) {
        ExamDto examDto = new ExamDto();
        examDto.setId(exam.getId());
        examDto.setContent(exam.getContent());
        examDto.setTitle(exam.getTitle());
        examDto.setStatus(exam.getStatus());
        examDto.setType(exam.getType());
        examDto.setDuration(exam.getDuration());
        examDto.setCreatedBy(exam.getUserId());
        return examDto;
    }

    public static Exam mapToExam(ExamDto examDto) {
        Exam exam = new Exam();
        exam.setId(examDto.getId());
        exam.setContent(examDto.getContent());
        exam.setTitle(examDto.getTitle());
        exam.setStatus(examDto.getStatus());
        exam.setType(examDto.getType());
        exam.setDuration(examDto.getDuration());
        exam.setUserId(examDto.getCreatedBy());
        return exam;
    }
}
