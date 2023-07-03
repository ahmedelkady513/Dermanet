package com.dermanet.backend.service;

import java.util.List;

import com.dermanet.backend.entity.Address;

public interface AddressService {
    Address save(Address address);
    List<Address> getAddressesForUser();
}
