package com.satori.service.impl;

import com.satori.dto.TrainerClubAddDto;
import com.satori.dto.TrainerDto;
import com.satori.dto.TrainerPageDto;
import com.satori.repository.TrainerRepository;
import com.satori.service.TrainerService;
import com.satori.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@AllArgsConstructor
@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;
    //todo remove one from next 2
    private final MapperUtil mapperUtil;

/*    @Override public TrainerPageDto getByUsername(Integer pageNo, Principal principal) {
        var trainerPage = trainerRepository.findTrainersByClubIdOrderByLastName(PageRequest.of(pageNo - 1, 8),
                userSecurityUtil.getClubId(principal));
        return TrainerPageDto.builder()
                .trainerDtos(trainerPage.stream()
                        .map(mapperUtil::mapTrainerToDto)
                        .collect(Collectors.toList()))
                .currentPage(trainerPage.getNumber() + 1)
                .totalPages(trainerPage.getTotalPages())
                .totalEntries(trainerPage.getTotalElements())
                .build();
    }*/

/*    @Override public void create(TrainerClubAddDto trainerClubAddDto, Principal principal) {
        var trainer = mapperUtil.mapTrainerAddDto(trainerClubAddDto);
        trainer.setClub(clubRepository
                .findById(userSecurityUtil.getClubId(principal))
                .orElseThrow(() -> new RuntimeException("No Club found!")));
        trainerRepository.save(trainer);
    }*/

    @Override
    public TrainerPageDto getByUsername(Integer pageNo, Principal principal) {
        return null;
    }

    @Override
    public void create(TrainerClubAddDto trainerClubAddDto, Principal principal) {

    }

    @Override public void deleteById(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override public TrainerDto getById(Long id) {
        return mapperUtil.mapTrainerToDto(trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No trainer found!")));
    }
}