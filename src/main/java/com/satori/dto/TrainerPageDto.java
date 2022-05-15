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
public class TrainerPageDto {

    private List<TrainerDto> trainerDtos = new ArrayList<>();

    private Integer totalPages;

    private Integer currentPage;

    private Long totalEntries;
}