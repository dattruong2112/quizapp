package com.dattruong.user.service.client;

import com.dattruong.user.dto.ExamDto;
import com.dattruong.user.service.fallback.ExamFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "exam", fallback = ExamFallback.class)
public interface ExamFeignClient {

    @GetMapping(value = "/fetch", consumes = "application/json")
    ResponseEntity<List<ExamDto>> fetchExamDetails(@RequestHeader("quiz-correlation-id")String quizCorrelationId, @RequestHeader("id") int userId);

}
