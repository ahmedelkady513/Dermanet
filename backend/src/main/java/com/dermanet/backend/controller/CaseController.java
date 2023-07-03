package com.dermanet.backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dermanet.backend.dtos.CaseDto;
import com.dermanet.backend.entity.Case;
import com.dermanet.backend.mappers.MapStructMappers;
import com.dermanet.backend.service.CaseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CaseController {
    
    private final CaseService service;
    private final MapStructMappers mapper ;

    @PostMapping("/case/add")
    public ResponseEntity<CaseDto> addCase(@RequestParam("image") MultipartFile caseImage,@RequestPart("caseDto") CaseDto caseDto) {
        Case userCase = mapper.caseDtoToCase(caseDto);
        return ResponseEntity.ok(mapper.caseToCaseDto(service.save(userCase,caseImage)));
    }
}
