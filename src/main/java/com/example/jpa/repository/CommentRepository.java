package com.example.jpa.repository;

import com.example.jpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByScheduleId(Long scheduleId);

    List<Comment> findByScheduleIdAndAuthor(Long scheduleId, String author);

}
