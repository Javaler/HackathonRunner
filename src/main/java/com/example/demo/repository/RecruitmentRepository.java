package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Recruitment;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {

    List<Recruitment> findAllByOrderByDeadlineAsc();
    List<Recruitment> findTop3ByDeadlineAfterOrderByDeadlineAsc(Date date);
}
