package com.example.jpa.dto;

import lombok.Getter;

@Getter

public class UserCreateRequest {

    private String name;
    private String email;
    private String password;
}
