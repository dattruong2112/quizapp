package com.dattruong.user.service;

import com.dattruong.user.dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto userDto);
    UserDto fetchUserDetails(String quizCorrelationId, int id);

    List<UserDto> findAll();

    UserDto getUserById(int userId);
}
