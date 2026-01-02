package com.example.jpa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class CommentCreateResponse {

    private final long id;
    private final String content;
    private final String author;
    private final String password;
    private final String scheduleTitle;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public CommentCreateResponse(long id, String content, String author, String password, String scheduleTitle, LocalDateTime createAt, LocalDateTime modifiedAt) {

        this.id = id;
        this.content = content;
        this.author = author;
        this.password = password;
        this.scheduleTitle = scheduleTitle;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
