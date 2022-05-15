package com.satori.service;

import com.satori.dto.CategoryDto;
import com.satori.dto.CategoryPageDto;
import com.satori.dto.MemberPageDto;

public interface CategoryService {
    CategoryPageDto getCategoriesBySeasonId(Integer pageNo, Long seasonId);

    void save(Long seasonId, CategoryDto categoryDto);

    MemberPageDto getCompetitors(Integer pageNo, Long categoryId);

    void addCompetitor(Long categoryId, Long memberId);

    void removeCompetitor(Long categoryId, Long memberId);
}
