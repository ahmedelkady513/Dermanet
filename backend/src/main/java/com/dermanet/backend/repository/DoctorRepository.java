package com.dermanet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dermanet.backend.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    
}
