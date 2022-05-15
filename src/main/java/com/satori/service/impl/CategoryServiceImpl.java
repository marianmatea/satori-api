package com.satori.service.impl;

import com.satori.dto.CategoryDto;
import com.satori.dto.CategoryPageDto;
import com.satori.dto.MemberPageDto;
import com.satori.repository.CategoryRepository;
import com.satori.repository.MemberRepository;
import com.satori.repository.SeasonRepository;
import com.satori.service.CategoryService;
import com.satori.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final SeasonRepository seasonRepository;
    private final MemberRepository memberRepository;
    private final MapperUtil mapperUtil;

    @Override
    public CategoryPageDto getCategoriesBySeasonId(Integer pageNo, Long seasonId) {
        var page = categoryRepository.findBySeasonId(PageRequest.of(pageNo - 1, 8), seasonId);
        return CategoryPageDto.builder()
                .categories(
                        page.stream()
                                .map(mapperUtil::mapCategoryToDto)
                                .collect(Collectors.toList())
                )
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalEntries(page.getTotalElements())
                .build();
    }

    @Override
    public void save(Long seasonId, CategoryDto categoryDto) {
        var category = mapperUtil.mapCategoryFromDto(categoryDto);
        category.setSeason(seasonRepository.findById(seasonId).orElseThrow(() -> new RuntimeException("No season found!")));
        categoryRepository.save(category);
    }

    @Override
    public MemberPageDto getCompetitors(Integer pageNo, Long categoryId) {
        var category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("No category foun!"));
        var page = memberRepository.findByCategoriesOrderByLastName(PageRequest.of(pageNo - 1, 8), category);
        return MemberPageDto.builder()
                .memberDtos(page.stream()
                        .map(mapperUtil::mapMemberToDto)
                        .collect(Collectors.toList()))
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalEntries(page.getTotalElements())
                .build();
    }

    @Override
    public void addCompetitor(Long categoryId, Long memberId) {
        var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("No category found!"));
        var member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("No member found!"));
        category.getMembers().add(member);
        categoryRepository.save(category);
    }

    @Override
    public void removeCompetitor(Long categoryId, Long memberId) {
        var category =categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("No category found!"));
        var member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("No member found!"));
        category.getMembers().remove(member);
        categoryRepository.save(category);
    }
}