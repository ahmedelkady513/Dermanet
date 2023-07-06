package com.dermanet.backend.dtos;

import java.util.ArrayList;

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
    private ArrayList<AddressDto> addresses = new ArrayList<>();
    private ArrayList<CaseDto> Cases = new ArrayList<>();
}
