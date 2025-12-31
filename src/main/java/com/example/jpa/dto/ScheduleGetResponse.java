package com.example.jpa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class ScheduleGetResponse {

    private final long id;
    private final String title;
    private final String content;
    private final String author;
    private final String password;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public ScheduleGetResponse(long id, String title, String content, String author, String password, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
