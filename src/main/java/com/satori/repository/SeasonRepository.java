package com.satori.repository;

import com.satori.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    List<Season> findByCompetitionId(Long id);
}