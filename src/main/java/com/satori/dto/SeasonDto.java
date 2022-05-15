package com.satori.dto;

import com.satori.model.Competition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDto {

    private Long id;

    private Integer year;

    private LocalDate startDate;

    private LocalDate finishDate;

    private Competition competition;

    private List<MemberDto> members;
}