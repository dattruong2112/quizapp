package com.dattruong.exam.controller;

import com.dattruong.exam.constants.ExamConstants;
import com.dattruong.exam.dto.ExamDto;
import com.dattruong.exam.dto.ResponseDto;
import com.dattruong.exam.service.IExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
    private final IExamService iExamService;

    public ExamController(IExamService iExamService) {
        this.iExamService = iExamService;
    }

    @PostMapping
    private ResponseEntity<ResponseDto> createExam(@RequestHeader("quiz-correlation-id") String quizCorrelationId, @RequestBody ExamDto examsDto) {
        iExamService.createExam(quizCorrelationId,examsDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ExamConstants.STATUS_201, ExamConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    private ResponseEntity<List<ExamDto>> fetchExamByCreatedUser(@RequestHeader("quiz-correlation-id") String quizCorrelationId,@RequestHeader("id") int userId) {
        logger.debug("quiz correlation Id" + quizCorrelationId);
        List<ExamDto> exams = iExamService.fetchExamByCreatedUser(userId);
        return ResponseEntity.ok(exams);
    }

    @GetMapping
    private ResponseEntity<List<ExamDto>> findAll(@RequestHeader("quiz-correlation-id") String quizCorrelationId) {
        List<ExamDto> exams = iExamService.findAll();
        return ResponseEntity.ok(exams);
    }
}
