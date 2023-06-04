package com.dermanet.backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private Integer id;
    private String streetName;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private Boolean isMain;
}
