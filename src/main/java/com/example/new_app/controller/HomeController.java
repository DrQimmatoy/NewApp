package com.example.new_app.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
