package com.dermanet.backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {

    private String firstName;

    private String lastName;

    private String number;

    private Double latitude;

    private Double longitude;

    private String location;

    private String image;

}
