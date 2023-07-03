package com.dermanet.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dermanet.backend.dtos.DoctorDto;

import com.dermanet.backend.mappers.MapStructMappers;
import com.dermanet.backend.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final MapStructMappers mapper;
    @GetMapping("doctors/get")
    public ResponseEntity<List<DoctorDto>> getDoctors() {
        return ResponseEntity.ok(mapper.doctorToDoctorDto(doctorService.getAllDoctors()));
    }
}
