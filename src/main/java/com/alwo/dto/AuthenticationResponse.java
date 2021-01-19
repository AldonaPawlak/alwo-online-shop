package com.alwo.dto;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@Builder
public class AuthenticationResponse {

    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;

    public AuthenticationResponse(String authenticationToken, String refreshToken, Instant expiresAt, String username) {
        this.authenticationToken = authenticationToken;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
        this.username = username;
    }

    public AuthenticationResponse() {
    }
}
