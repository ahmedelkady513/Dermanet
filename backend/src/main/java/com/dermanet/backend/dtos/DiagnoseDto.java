package com.dermanet.backend.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiagnoseDto {
    private Integer id;
    private String diagnose;
    private double precentage;
}
