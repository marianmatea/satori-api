package com.satori.service;

import com.satori.dto.ClubAdd;
import com.satori.dto.ClubDto;
import com.satori.dto.ClubPageDto;
import com.satori.model.Club;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ClubService {

    List<ClubDto> getAll();

    ClubPageDto getPage(Integer page, Integer size, Sort.Direction sort, String column);

    void save(ClubAdd clubAdd);

    void deleteById(Long id);
}
