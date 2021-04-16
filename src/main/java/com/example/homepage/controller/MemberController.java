package com.example.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/login")
    public void login(){

    }

    @RequestMapping("/signup")
    public void signup(){

    }
}
