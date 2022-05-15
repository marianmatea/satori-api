package com.satori.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubDto {

    private Long id;

    private String name;

    private String country;

    private String city;

    private String address;

    private String email;

    private String phoneNumber;

    private String description;

    private String cis;

    private String cif;

    private String instructor;

    private String status;

    private List<MemberDto> members = new ArrayList<>();
}