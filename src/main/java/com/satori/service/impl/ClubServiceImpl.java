package com.satori.service.impl;

import com.satori.dto.ClubAdd;
import com.satori.dto.ClubDto;
import com.satori.dto.ClubPageDto;
import com.satori.model.Club;
import com.satori.repository.ClubRepository;
import com.satori.repository.MemberRepository;
import com.satori.service.ClubService;
import com.satori.util.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;
    private final MemberRepository memberRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<ClubDto> getAll() {
        return clubRepository.findAll().stream()
                .map(mapperUtil::mapClubToDto)
                .toList();
    }

    @Override
    public ClubPageDto getPage(Integer page, Integer size, Sort.Direction sort, String column) {
        log.info("Get clubs page");
        PageRequest pageable =  sort == null || column == null ?
                PageRequest.of(page, size):
                PageRequest.of(page, size, Sort.by(sort, column));
        var clubPage = clubRepository.findByOrderByName(pageable);
        return ClubPageDto.builder()
                .clubs(clubPage.stream().map(mapperUtil::mapClubToDto).toList())
                .currentPage(clubPage.getNumber())
                .totalPages(clubPage.getTotalPages() + 1)
                .totalEntries(clubPage.getTotalElements())
                .pageSize(clubPage.getSize())
                .build();
    }

    @Override
    public void save(ClubAdd clubAdd) {
        clubRepository.save(Club.builder()
                .name(clubAdd.getName())
                .cif(clubAdd.getCif())
                .cis(clubAdd.getCis())
                .build());
    }

    @Override
    public void deleteById(Long id) {
        clubRepository.deleteById(id);
    }
}