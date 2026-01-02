package com.example.jpa.service;

import com.example.jpa.dto.CommentCreateRequest;
import com.example.jpa.dto.CommentCreateResponse;
import com.example.jpa.entity.Comment;
import com.example.jpa.entity.Schedule;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentCreateResponse save (Long scheduleId, CommentCreateRequest request) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));

        Comment comment = new Comment (
                request.getContent(),
                request.getAuthor(),
                request.getPassword(),
                schedule
        );

        Comment savecomment = commentRepository.save(comment);
        return new CommentCreateResponse(

                savecomment.getId(),
                savecomment.getContent(),
                savecomment.getAuthor(),
                savecomment.getPassword(),
                savecomment.getSchedule().getTitle(),
                savecomment.getCreatedAt(),
                savecomment.getModifiedAt()
        );

    };
}
