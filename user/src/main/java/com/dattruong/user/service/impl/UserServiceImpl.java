package com.dattruong.user.service.impl;

import com.dattruong.user.dto.ExamDto;
import com.dattruong.user.dto.UserDto;
import com.dattruong.user.entity.User;
import com.dattruong.user.mapper.UserMapper;
import com.dattruong.user.repository.UserRepository;
import com.dattruong.user.service.IUserService;
import com.dattruong.user.service.client.ExamFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    @Qualifier("com.dattruong.user.service.client.ExamFeignClient")
    private ExamFeignClient examFeignClient;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapUserDtoToUser(userDto);
        User createdUser = userRepository.save(user);
        return UserMapper.mapUserToUserDto(createdUser);
    }

    @Override
    public UserDto fetchUserDetails(String quizCorrelationId,int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserDto userDto = UserMapper.mapUserToUserDto(user.get());
            ResponseEntity<List<ExamDto>> examDto = examFeignClient.fetchExamDetails(quizCorrelationId,id);
            if(examDto != null) {
                userDto.setExams(examDto.getBody());
            }
            return userDto;
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserMapper::mapUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepository.findById(userId).get();
        return UserMapper.mapUserToUserDto(user);
    }

}
