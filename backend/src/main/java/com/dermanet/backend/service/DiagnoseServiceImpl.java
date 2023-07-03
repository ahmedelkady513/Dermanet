package com.dermanet.backend.service;

import org.springframework.stereotype.Service;

import com.dermanet.backend.entity.Diagnose;
import com.dermanet.backend.repository.DiagnoseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiagnoseServiceImpl implements DiagnoseService {

    private final DiagnoseRepository diagnoseRepository;

    @Override
    public Diagnose save(Diagnose diagnose) {
        return diagnoseRepository.save(diagnose);
    }
    
}
