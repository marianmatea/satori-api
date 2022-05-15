package com.satori.controller;

import com.satori.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

}