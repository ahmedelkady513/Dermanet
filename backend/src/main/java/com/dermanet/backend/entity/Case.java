package com.dermanet.backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_user_id")
    private User user;

    @OneToMany(mappedBy = "imageCase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CaseImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "diagnoseCase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diagnose> diagnoses = new ArrayList<>();
}
