package com.dermanet.backend.mappers;


import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

import com.dermanet.backend.dtos.AddressDto;
import com.dermanet.backend.dtos.RegisterDto;
import com.dermanet.backend.dtos.UserDetailsDto;
import com.dermanet.backend.entity.Address;
import com.dermanet.backend.entity.User;

@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface MapStructMappers {
    UserDetailsDto userToUserDetailsDto(User user);
    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto address);
    User registerDtoToUser(RegisterDto registerDto);
}
