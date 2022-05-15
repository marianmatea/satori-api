package com.satori.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberAdminAddDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Double weight;

    private String belt;

    private String status;

    private String memberId;

    private String memberIdExpiry;

    private Long clubId;
}
