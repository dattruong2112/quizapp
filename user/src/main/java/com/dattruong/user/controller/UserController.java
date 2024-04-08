package com.dattruong.user.controller;

import com.dattruong.user.constants.UserConstants;
import com.dattruong.user.dto.ResponseDto;
import com.dattruong.user.dto.UserDto;
import com.dattruong.user.entity.User;
import com.dattruong.user.mapper.UserMapper;
import com.dattruong.user.repository.UserRepository;
import com.dattruong.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {this.iUserService = iUserService;}

    @PostMapping
    private ResponseEntity<ResponseDto> createUser(@RequestHeader("quiz-correlation-id") String quizCorrelationId,@RequestBody UserDto userDto) {
        logger.debug("create user");
        logger.debug("correlation Id " + quizCorrelationId);
        iUserService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201));
    }

    @GetMapping("/fetchUserDetails")
    private ResponseEntity<UserDto> fetchUserDetails(@RequestHeader("quiz-correlation-id") String quizCorrelationId, @RequestHeader("id") int userId) {
        logger.debug("user id" + userId);
        UserDto userDto = iUserService.fetchUserDetails(quizCorrelationId,userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    private ResponseEntity<List<UserDto>> findAll(@RequestHeader("quiz-correlation-id") String quizCorrelationId) {
        List<UserDto> userDto = iUserService.findAll();
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/fetchUser")
    private ResponseEntity<UserDto> fetchUser(@RequestHeader("quiz-correlation-id") String quizCorrelationId, @RequestHeader("id") int userId) {
        logger.debug("Fetch User " + userId);
        UserDto userDto = iUserService.getUserById(userId);
        return  ResponseEntity.ok(userDto);
    }

    @GetMapping("/user1")
    private String testUser1(@RequestHeader("quiz-correlation-id") String quizCorrelationId) {
        return "hello user 1";
    }
}
