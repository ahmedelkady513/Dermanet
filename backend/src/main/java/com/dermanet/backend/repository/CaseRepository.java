package com.dermanet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dermanet.backend.entity.Case;

public interface CaseRepository extends JpaRepository<Case , Integer> {
    
}
