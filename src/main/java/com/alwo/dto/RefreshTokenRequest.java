package com.alwo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RefreshTokenRequest {
    @NotBlank
    private String refreshToken;
    private String username;

    public RefreshTokenRequest(@NotBlank String refreshToken, String username) {
        this.refreshToken = refreshToken;
        this.username = username;
    }

    public RefreshTokenRequest() {
    }
}
