package com.alwo.dto;

import lombok.*;

@Setter
@Getter
public class AuthenticationResponse {

    private String authenticationToken;
    private String username;

    public AuthenticationResponse(String authenticationToken, String username) {
        this.authenticationToken = authenticationToken;
        this.username = username;
    }

    public AuthenticationResponse() {
    }
}
