package com.dermanet.backend.service;

import com.dermanet.backend.dtos.LoginDto;
import com.dermanet.backend.dtos.SocialDto;
import com.dermanet.backend.dtos.JwtDto;
import com.dermanet.backend.entity.User;

public interface UserService {

    User register(User user);

    JwtDto login(LoginDto request);

    User getCurrentUser();

    JwtDto socialLogin(SocialDto socialDto);


}