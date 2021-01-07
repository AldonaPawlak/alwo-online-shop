package com.alwo.dto;

import lombok.*;

@Setter
@Getter
public class LoginRequest {

    private String username;
    private String password;


    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }
}
