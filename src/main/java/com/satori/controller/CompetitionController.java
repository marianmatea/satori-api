package com.satori.controller;

import com.satori.service.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class CompetitionController {

    private final CompetitionService competitionService;
}