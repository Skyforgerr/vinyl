package com.example.website.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RareController {
    @GetMapping("/rare")
    public String rare(Model model){
        //model.addAttribute("title", "Rare page");
        return "rare_page";
    }
}
