package com.satori.service;

import com.satori.dto.TrainerClubAddDto;
import com.satori.dto.TrainerDto;
import com.satori.dto.TrainerPageDto;

import java.security.Principal;

public interface TrainerService {
    TrainerPageDto getByUsername(Integer pageNo, Principal principal);

    void create(TrainerClubAddDto trainerClubAddDto, Principal principal);

    void deleteById(Long id);

    TrainerDto getById(Long id);
}
