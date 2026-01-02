package com.example.jpa.controller;

import com.example.jpa.dto.CommentCreateRequest;
import com.example.jpa.dto.CommentCreateResponse;
import com.example.jpa.dto.CommentGetResponse;
import com.example.jpa.service.CommentService;
import com.example.jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;
    private final ScheduleService scheduleService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentCreateResponse> create (
            @PathVariable Long scheduleId,
            @RequestBody CommentCreateRequest request
    ) {
        CommentCreateResponse comment = commentService.save(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @GetMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<List<CommentGetResponse>> getAll (
            @RequestParam(required = false) String author,
            @PathVariable Long scheduleId
    ) {
        List<CommentGetResponse > comments = commentService.findAll(scheduleId, author);
        return ResponseEntity.status(HttpStatus.OK).body(comments);

    }
}
