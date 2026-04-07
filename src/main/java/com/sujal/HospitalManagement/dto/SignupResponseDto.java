package com.sujal.HospitalManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class SignupResponseDto {

    private String id;

    private String username;


    public SignupResponseDto(Long id, String username) {
    }
}
