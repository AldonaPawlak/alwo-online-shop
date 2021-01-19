package com.alwo.controller;

import com.alwo.dto.AuthenticationResponse;
import com.alwo.dto.LoginRequest;
import com.alwo.dto.RefreshTokenRequest;
import com.alwo.dto.RegisterRequest;
import com.alwo.service.impl.AuthServiceImpl;
import com.alwo.service.impl.RefreshTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
//@RequestMapping("/alwo/auth")
public class AuthController {

    private final AuthServiceImpl authServiceImpl;
    private final RefreshTokenService refreshTokenService;

    public AuthController(AuthServiceImpl authServiceImpl,
                          RefreshTokenService refreshTokenService) {
        this.authServiceImpl = authServiceImpl;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/alwo/auth/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authServiceImpl.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }


    @PostMapping("/alwo/auth/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authServiceImpl.login(loginRequest);
    }

    @PostMapping("/alwo/auth/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authServiceImpl.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/alwo/auth/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }

}
