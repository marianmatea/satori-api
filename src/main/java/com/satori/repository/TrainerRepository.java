package com.satori.repository;

import com.satori.model.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Page<Trainer> findTrainersByClubIdOrderByLastName(Pageable pageable, Long id);
}