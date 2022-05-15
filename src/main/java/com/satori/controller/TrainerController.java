package com.satori.controller;

import com.satori.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class TrainerController {

    private final TrainerService trainerService;
}