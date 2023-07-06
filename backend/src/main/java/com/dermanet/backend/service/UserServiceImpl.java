package com.dermanet.backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dermanet.backend.dtos.LoginDto;
import com.dermanet.backend.dtos.RegisterDto;
import com.dermanet.backend.dtos.SocialDto;
import com.dermanet.backend.dtos.UpdateUserDetailsDto;
import com.dermanet.backend.dtos.UserDetailsDto;
import com.dermanet.backend.dtos.JwtDto;
import com.dermanet.backend.entity.Role;
import com.dermanet.backend.entity.User;
import com.dermanet.backend.mappers.MapStructMappers;
import com.dermanet.backend.repository.UserRepository;
import com.dermanet.backend.utilities.CurrentUserUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final MapStructMappers mapper;

    @Override
    public User register(User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getAddresses().forEach(address -> address.setUser(user));
        return repository.save(user);
    }

    @Override
    public JwtDto login(LoginDto loginDto) {
        var user = authenticateUser(loginDto.getUsername(), loginDto.getPassword());
        var jwtToken = jwtService.generateToken(user);
        return JwtDto.builder().token(jwtToken).build();
    }

    private User registerSocial(SocialDto socialDto) {
        User socialUser = User.builder().firstName(socialDto.getFirstName())
                .lastName(socialDto.getLastName())
                .email(socialDto.getEmail())
                .password(socialDto.getTokenId())
                .username(socialDto.getEmail().split("@")[0])
                .role(Role.SOCIAL)
                .build();
        return repository.save(socialUser);
    }

    @Override
    public JwtDto socialLogin(SocialDto socialDto) {
        String username = socialDto.getEmail().split("@")[0];
        String password = socialDto.getTokenId();
        User user = repository.findByUsername(username).orElseGet(() -> registerSocial(socialDto));
        authenticateUser(username, password);
        var jwtToken = jwtService.generateToken(user);
        return JwtDto.builder().token(jwtToken).build();
    }

    private User authenticateUser(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password));
        return repository.findByUsername(username).orElseThrow();
    }

    @Override
    public User getCurrentUser() {
        return repository.findByUsername(CurrentUserUtils.getCurrentUsername()).orElseThrow();
    }

    @Override
    public User updateUser(UpdateUserDetailsDto userDetailsDto) {
        User updateUser = getCurrentUser();
        mapper.updateUserFromUserDto(userDetailsDto, updateUser);
        updateUser.setId(updateUser.getId());
        updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        return repository.save(updateUser);
    }
}
