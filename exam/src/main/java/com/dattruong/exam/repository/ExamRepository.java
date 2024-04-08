package com.dattruong.exam.repository;


import com.dattruong.exam.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
    Optional<Exam> findByUserId(int userId);
}
