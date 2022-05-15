package com.satori.service.impl;

import com.satori.dto.CategoryDto;
import com.satori.dto.MemberDto;
import com.satori.dto.SeasonAddDto;
import com.satori.dto.SeasonDto;
import com.satori.model.Season;
import com.satori.repository.CompetitionRepository;
import com.satori.repository.MemberRepository;
import com.satori.repository.SeasonRepository;
import com.satori.service.SeasonService;
import com.satori.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;
    private final MapperUtil mapperUtil;

    @Override public List<SeasonDto> getSeasonsByCompetitionId(Long id) {
        return seasonRepository.findByCompetitionId(id).stream()
                .map(mapperUtil::mapSeasonToDto)
                .collect(Collectors.toList());
    }

    @Override public Season create(SeasonAddDto seasonAddDto, Long competitionId) {
        var season = mapperUtil.mapSeasonAddDto(seasonAddDto);
        if (competitionId != null) {
            var competition = competitionRepository.findById(competitionId)
                    .orElseThrow(() -> new RuntimeException("No competition with id " + competitionId));
            season.setCompetition(competition);
        }
        return seasonRepository.save(season);
    }

    @Override public List<CategoryDto> getCategories(Long seasonId) {
        var season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new RuntimeException("No season found!"));
        return season.getCategories().stream()
                .map(mapperUtil::mapCategoryToDto)
                .collect(Collectors.toList());
    }

    @Override public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(mapperUtil::mapMemberToDto)
                .collect(Collectors.toList());
    }

    @Override public void deleteById(Long id) {
        seasonRepository.deleteById(id);
    }

    @Override public Long getCompetitionIdBySeason(Long id) {
        return seasonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No season found!"))
                .getCompetition().getId();
    }
}