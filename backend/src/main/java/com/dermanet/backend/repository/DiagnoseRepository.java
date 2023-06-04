package com.dermanet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dermanet.backend.entity.Diagnose;

public interface DiagnoseRepository extends JpaRepository<Diagnose , Integer> {
    
}
