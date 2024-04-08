package com.dattruong.user.service.fallback;

import com.dattruong.user.dto.ExamDto;
import com.dattruong.user.service.client.ExamFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamFallback implements ExamFeignClient {

    @Override
    public ResponseEntity<List<ExamDto>> fetchExamDetails(String quizCorrelationId, int userId) {
        return null;
    }
}
