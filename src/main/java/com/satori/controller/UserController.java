package com.satori.controller;

import com.satori.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/admin/users")
public class UserController {

    private final UserService userService;

}