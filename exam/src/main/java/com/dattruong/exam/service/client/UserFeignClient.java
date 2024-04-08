package com.dattruong.exam.service.client;

import com.dattruong.exam.dto.UserDto;
import com.dattruong.exam.service.fallback.UserFeignFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user", fallback = UserFeignFallback.class)
public interface UserFeignClient {
    @GetMapping(value = "/fetchUser", consumes = "application/json")
    ResponseEntity<UserDto> fetchUser(@RequestHeader("quiz-correlation-id")String quizCorrelationId, @RequestHeader("id") int userId);
}
