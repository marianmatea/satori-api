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
public class ClubPageDto {

    private List<ClubDto> clubs;

    private Integer totalPages;

    private Integer currentPage;

    private Integer pageSize;

    private Long totalEntries;
}
