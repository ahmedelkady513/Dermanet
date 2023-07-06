package com.dermanet.backend.dtos;

import java.util.ArrayList;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserDetailsDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private Integer age;
}