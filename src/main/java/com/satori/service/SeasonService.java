package com.satori.service;

import com.satori.dto.CategoryDto;
import com.satori.dto.MemberDto;
import com.satori.dto.SeasonAddDto;
import com.satori.dto.SeasonDto;
import com.satori.model.Season;

import java.util.List;

public interface SeasonService {
    List<SeasonDto> getSeasonsByCompetitionId(Long id);

    Season create(SeasonAddDto seasonAddDto, Long competitionId);

    List<CategoryDto> getCategories(Long seasonId);

    List<MemberDto> getAllMembers();

    void deleteById(Long id);

    Long getCompetitionIdBySeason(Long id);
}
