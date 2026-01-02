package com.example.jpa.repository;

import com.example.jpa.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findAllByOrderByModifiedAtDesc(); // 전체 일정 조회, 수정일 내림차순
    List<Schedule> findAllByAuthorOrderByModifiedAtDesc(String author); // 작성자명 일정 조회, modifiedAt 기준 내림차순 정렬

}
