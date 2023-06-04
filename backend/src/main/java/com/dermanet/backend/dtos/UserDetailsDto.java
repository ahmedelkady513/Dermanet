package com.dermanet.backend.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDto {
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private List<AddressDto> addresses = new ArrayList<>();
}
