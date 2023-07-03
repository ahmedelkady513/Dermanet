package com.dermanet.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocialDto {
    private String firstName;
    private String lastName;
    private String tokenId;
    private String email; 
}
