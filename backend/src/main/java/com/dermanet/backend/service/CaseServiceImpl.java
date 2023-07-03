package com.dermanet.backend.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dermanet.backend.entity.Case;
import com.dermanet.backend.repository.CaseRepository;
import com.dermanet.backend.repository.UserRepository;
import com.dermanet.backend.utilities.CurrentUserUtils;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final UserRepository userRepository;
    private final CaseRepository caseRepository;
    @Autowired
    private final Cloudinary cloudinary;

    @Override
    public Case save(Case userCase, MultipartFile caseImage) {
        userCase.getDiagnoses().forEach(diagnose -> diagnose.setDiagnoseCase(userCase));
        userCase.setUser(userRepository.findByUsername(CurrentUserUtils.getCurrentUsername()).get());
        userCase.setCaseImage(saveImage(caseImage));
        return caseRepository.save(userCase);
    }
    private String saveImage(MultipartFile caseImage) {
        Map<String, String> imageResponse = ObjectUtils.emptyMap();
        try {
            imageResponse = cloudinary.uploader().upload(caseImage.getBytes(), ObjectUtils.emptyMap());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return imageResponse.get("secure_url");
    }

}
