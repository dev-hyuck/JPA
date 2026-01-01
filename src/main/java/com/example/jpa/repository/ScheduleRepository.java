package com.example.jpa.repository;

import com.example.jpa.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> findAllByOrderByModifiedAtDesc(String title);

}
