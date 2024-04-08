package com.dattruong.exam.service.fallback;

import com.dattruong.exam.dto.UserDto;
import com.dattruong.exam.service.client.UserFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeignClient {

    @Override
    public ResponseEntity<UserDto> fetchUser(String quizCorrelationId, int userId) {
        return null;
    }
}
