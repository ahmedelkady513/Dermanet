package com.dermanet.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dermanet.backend.entity.Address;
import com.dermanet.backend.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserService userService;

    @Override
    public Address save(Address address) {
        address.setUser(userService.getCurrentUser());
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAddressesForUser() {
        var currentUser = userService.getCurrentUser();
       return addressRepository.findByUserId(currentUser.getId());
    }
}
