package com.dermanet.backend.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.dermanet.backend.dtos.AddressDto;
import com.dermanet.backend.dtos.CaseDto;
import com.dermanet.backend.dtos.DiagnoseDto;
import com.dermanet.backend.dtos.DoctorDto;
import com.dermanet.backend.dtos.RegisterDto;
import com.dermanet.backend.dtos.UpdateUserDetailsDto;
import com.dermanet.backend.dtos.UserDetailsDto;
import com.dermanet.backend.entity.Address;
import com.dermanet.backend.entity.Case;
import com.dermanet.backend.entity.Diagnose;
import com.dermanet.backend.entity.Doctor;
import com.dermanet.backend.entity.User;
import java.util.List;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface MapStructMappers {
    UserDetailsDto userToUserDetailsDto(User user);

    User userDtoToUserDetails(UserDetailsDto user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(UpdateUserDetailsDto dto, @MappingTarget User entity);

    @Mapping(target = "password", ignore = true)
    UpdateUserDetailsDto updateUserDetailsDtoFromUser(User user);

    AddressDto addressToAddressDto(Address address);

    Address addressDtoToAddress(AddressDto address);

    User registerDtoToUser(RegisterDto registerDto);

    Case caseDtoToCase(CaseDto caseDto);

    Diagnose diagnoseDtoToDiagnose(DiagnoseDto diagnoseDto);

    CaseDto caseToCaseDto(Case caseDto);

    DiagnoseDto diagnoseToDiagnoseDto(Diagnose diagnoseDto);

    List<Doctor> listDoctorDtoToListDoctor(List<DoctorDto> doctor);

    List<DoctorDto> listDoctorToListDoctorDto(List<Doctor> doctor);

    List<CaseDto> listCaseToListCaseDto(List<Case> caseDto);

    List<AddressDto> listAddressToListAddressDto(List<Address> doctor);

}
