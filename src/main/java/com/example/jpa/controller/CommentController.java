package com.example.jpa.controller;

import com.example.jpa.dto.CommentCreateRequest;
import com.example.jpa.dto.CommentCreateResponse;
import com.example.jpa.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<CommentCreateResponse> create (
            @PathVariable Long scheduleId,
            @RequestBody CommentCreateRequest request
    ) {
        CommentCreateResponse comment = commentService.save(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
