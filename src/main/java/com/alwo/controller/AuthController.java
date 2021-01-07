package com.alwo.controller;

import com.alwo.dto.AuthenticationResponse;
import com.alwo.dto.LoginRequest;
import com.alwo.dto.RegisterRequest;
import com.alwo.service.impl.AuthServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/alwo/auth")
public class AuthController {

    private final AuthServiceImpl authServiceImpl;

    public AuthController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
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

}
