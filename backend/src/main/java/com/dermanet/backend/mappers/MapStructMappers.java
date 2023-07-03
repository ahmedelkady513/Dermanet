package com.dermanet.backend.mappers;


import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

import com.dermanet.backend.dtos.AddressDto;
import com.dermanet.backend.dtos.CaseDto;
import com.dermanet.backend.dtos.DiagnoseDto;
import com.dermanet.backend.dtos.DoctorDto;
import com.dermanet.backend.dtos.RegisterDto;
import com.dermanet.backend.dtos.UserDetailsDto;
import com.dermanet.backend.entity.Address;
import com.dermanet.backend.entity.Case;
import com.dermanet.backend.entity.Diagnose;
import com.dermanet.backend.entity.Doctor;
import com.dermanet.backend.entity.User;
import java.util.List;
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface MapStructMappers {
    UserDetailsDto userToUserDetailsDto(User user);
    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto address);
    User registerDtoToUser(RegisterDto registerDto);
    Case caseDtoToCase(CaseDto caseDto);
    Diagnose diagnoseDtoToDiagnose(DiagnoseDto diagnoseDto);
    CaseDto caseToCaseDto(Case caseDto);
    DiagnoseDto diagnoseToDiagnoseDto(Diagnose diagnoseDto);
    List<Doctor> doctorDtoToDoctor(List<DoctorDto> doctor);
    List<DoctorDto> doctorToDoctorDto(List<Doctor> doctor);

}
