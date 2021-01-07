package com.alwo.service;

import com.alwo.dto.AuthenticationResponse;
import com.alwo.dto.LoginRequest;
import com.alwo.dto.RefreshTokenRequest;
import com.alwo.dto.RegisterRequest;
import com.alwo.model.User;

public interface AuthService {

    void signup(RegisterRequest registerRequest);

    AuthenticationResponse login(LoginRequest loginRequest);

    User getCurrentUser();

    AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
