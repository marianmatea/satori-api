package com.satori.service.impl;

import com.satori.dto.CompetitionDto;
import com.satori.dto.CompetitionPageDto;
import com.satori.model.Competition;
import com.satori.repository.CompetitionRepository;
import com.satori.service.CompetitionService;
import com.satori.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final MapperUtil mapperUtil;

    @Override public List<CompetitionDto> getAll() {
        return competitionRepository.findAll().stream()
                .map(mapperUtil::mapCompetitionToDto)
                .collect(Collectors.toList());
    }

    @Override public CompetitionPageDto getAllPagination(Integer pageNo) {
        var page = competitionRepository.findByOrderByName(PageRequest.of(pageNo - 1, 8));
        return CompetitionPageDto.builder()
                .competitionDtos(page.stream()
                        .map(mapperUtil::mapCompetitionToDto)
                        .collect(Collectors.toList()))
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalEntries(page.getTotalElements())
                .build();
    }

    @Override public Competition create(CompetitionDto competitionDto) {
        return competitionRepository.save(mapperUtil.mapCompetitionDto(competitionDto));
    }

    @Override public void deleteById(Long id) {
        competitionRepository.deleteById(id);
    }
}