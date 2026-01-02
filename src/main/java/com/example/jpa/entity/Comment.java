package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String author;
    private String password;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule; // 다대일로 연결


    public Comment(String content, String author, String password, Schedule schedule) {
        this.content = content;
        this.author = author;
        this.password = password;
        this.schedule = schedule;
    }

    public void update(String content, String author, String password, Schedule schedule) {
        this.content = content;
        this.author = author;
        this.password = password;
        this.schedule = schedule;
    }

}
