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
public class UserAddDto {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String role;

    private String email;

    private String phoneNumber;

    private String status;

    private Long clubId;
}