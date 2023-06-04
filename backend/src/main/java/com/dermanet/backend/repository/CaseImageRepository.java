package com.dermanet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dermanet.backend.entity.CaseImage;

public interface CaseImageRepository extends JpaRepository<CaseImage , Integer> {
    
}
