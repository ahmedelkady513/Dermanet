package com.dermanet.backend.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaseDto {
    private int id;
    private LocalDate date;
    private String caseImage;
    private List<DiagnoseDto> diagnoses;
}
