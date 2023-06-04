package com.dermanet.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dermanet.backend.dtos.LoginDto;
import com.dermanet.backend.dtos.AuthenticationResponse;
import com.dermanet.backend.dtos.RegisterDto;
import com.dermanet.backend.entity.User;
import com.dermanet.backend.mappers.MapStructMappers;
import com.dermanet.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService service;
    private final MapStructMappers mapper;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterDto registerDto) {
        User user = mapper.registerDtoToUser(registerDto);
        return ResponseEntity.ok(service.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(service.login(loginDto));
    }
}
