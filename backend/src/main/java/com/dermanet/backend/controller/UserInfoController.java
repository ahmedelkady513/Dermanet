package com.dermanet.backend.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dermanet.backend.dtos.AddressDto;
import com.dermanet.backend.dtos.UpdateUserDetailsDto;
import com.dermanet.backend.dtos.UserDetailsDto;
import com.dermanet.backend.mappers.MapStructMappers;
import com.dermanet.backend.service.AddressService;
import com.dermanet.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("userinfo")
public class UserInfoController {

    private final UserService userService;
    private final AddressService addressService;
    private final MapStructMappers mapper;

    @GetMapping("/get")
    public ResponseEntity<UserDetailsDto> currentUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        var userDto = mapper.userToUserDetailsDto(userService.getCurrentUser());
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUserDetailsDto> updateUser(@RequestBody UpdateUserDetailsDto updatedUser) {
        return ResponseEntity.ok(mapper.updateUserDetailsDtoFromUser(userService.updateUser(updatedUser)));
    }

    @PostMapping("/address/add")
    public ResponseEntity<AddressDto> addAddress(
            @RequestBody AddressDto addressDto) {
        var address = mapper.addressDtoToAddress(addressDto);
        addressService.save(address);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/address/get")
    public ResponseEntity<List<AddressDto>> getCases() {
        return ResponseEntity.ok(mapper.listAddressToListAddressDto(userService.getCurrentUser().getAddresses()));
    }

}
