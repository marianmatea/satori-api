package com.satori.util;

import com.satori.model.Club;
import com.satori.repository.ClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ClubRepository clubRepository;

    @Override
    public void run(String... args) throws Exception {
        clubRepository.saveAll(List.of(Club.builder().name("test1").build(),
                Club.builder().name("tes2t").build(),
                Club.builder().name("test3").build(),
                Club.builder().name("test4").build(),
                Club.builder().name("test5").build(),
                Club.builder().name("test6").build()));
    }
}
