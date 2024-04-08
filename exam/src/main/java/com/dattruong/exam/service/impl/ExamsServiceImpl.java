package com.dattruong.exam.service.impl;

import com.dattruong.exam.dto.ExamDto;
import com.dattruong.exam.dto.UserDto;
import com.dattruong.exam.entity.Exam;
import com.dattruong.exam.mapper.ExamMapper;
import com.dattruong.exam.repository.ExamRepository;
import com.dattruong.exam.service.IExamService;
import com.dattruong.exam.service.client.UserFeignClient;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExamsServiceImpl implements IExamService {
    private static final Logger log = LoggerFactory.getLogger(ExamsServiceImpl.class);
    private ExamRepository examRepository;

    private final StreamBridge streamBridge;

    private UserFeignClient userFeignClient;


    @Override
    public void createExam(String quizCorrelationId,ExamDto examsDto) {
        Exam exam = ExamMapper.mapToExam(examsDto);
        examRepository.save(exam);
        //send broadcast
        sendCommunication(quizCorrelationId,examsDto.getCreatedBy());
    }

    private void sendCommunication(String quizCorrelationId,int userId) {
        //fetch user by user Id;
        ResponseEntity<UserDto> userDto = userFeignClient.fetchUser(quizCorrelationId,userId);
        log.debug("Send Communication To" + userDto);
        if (userDto != null) {
            var result = streamBridge.send("sendCommunication-out-0", userDto.getBody());
            log.info("Is the Communication request successfully triggered ? : {}", result);
        } else {
            log.debug("User is null");
        }
    }

    @Override
    public List<ExamDto> fetchExamByCreatedUser(int userId) {
        return examRepository.findByUserId(userId).stream().map(ExamMapper::mapToExamDto).collect(Collectors.toList());
    }

    @Override
    public List<ExamDto> findAll() {
        return examRepository.findAll().stream().map(ExamMapper::mapToExamDto).collect(Collectors.toList());
    }
}
