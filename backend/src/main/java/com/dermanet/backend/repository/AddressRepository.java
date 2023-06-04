package com.dermanet.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dermanet.backend.entity.Address;

public interface AddressRepository extends JpaRepository<Address , Integer> {
    List<Address> findByUserId(Integer id);
}
