package com.dermanet.backend.service;


import com.dermanet.backend.dtos.LoginDto;
import com.dermanet.backend.dtos.AuthenticationResponse;
import com.dermanet.backend.entity.User;

public interface UserService {

    AuthenticationResponse register(User user);

    AuthenticationResponse login(LoginDto request);

    User getCurrentUser(); 
    

}