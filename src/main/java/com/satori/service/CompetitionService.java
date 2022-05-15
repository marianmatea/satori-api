package com.satori.service;

import com.satori.dto.CompetitionDto;
import com.satori.dto.CompetitionPageDto;
import com.satori.model.Competition;

import java.util.List;

public interface CompetitionService {
    List<CompetitionDto> getAll();

    CompetitionPageDto getAllPagination(Integer pageNo);

    Competition create(CompetitionDto competitionDto);

    void deleteById(Long id);
}
