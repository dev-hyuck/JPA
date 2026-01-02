package com.example.jpa.dto;

import com.example.jpa.entity.Schedule;
import lombok.Getter;

@Getter

public class CommentCreateRequest {

    private Long id;
    private String content;
    private String author;
    private String password;
    private Schedule schedule;

}
