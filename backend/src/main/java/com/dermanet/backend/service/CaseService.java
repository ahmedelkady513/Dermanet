package com.dermanet.backend.service;


import org.springframework.web.multipart.MultipartFile;

import com.dermanet.backend.entity.Case;

public interface CaseService {
    Case save(Case userCase, MultipartFile caseImage);
}
