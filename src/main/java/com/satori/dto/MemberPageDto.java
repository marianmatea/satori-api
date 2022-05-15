package com.satori.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPageDto {

    private List<MemberDto> memberDtos;

    private Integer totalPages;

    private Integer currentPage;

    private Long totalEntries;
}