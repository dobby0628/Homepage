package com.example.homepage.controller;

import com.example.homepage.dto.MemberDTO;
import com.example.homepage.dto.SignupDTO;
import com.example.homepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/login")
    public void login() {

    }

    @GetMapping("/signup")
    public void signup(){

    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute SignupDTO signupDTO){
        memberService.signup(signupDTO);

        return "redirect:login";
    }

    @RequestMapping("/logout")
    public void logout() {

    }
}
