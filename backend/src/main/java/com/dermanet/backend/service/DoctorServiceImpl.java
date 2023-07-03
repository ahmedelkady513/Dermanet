package com.dermanet.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dermanet.backend.entity.Doctor;
import com.dermanet.backend.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository repository;
    @Override
    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }   
    
}
