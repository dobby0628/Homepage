package com.example.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/index")
    public void main(){

    }

    @RequestMapping("/generic")
    public void generic(){

    }

    @RequestMapping("/elements")
    public void elements(){

    }
}
