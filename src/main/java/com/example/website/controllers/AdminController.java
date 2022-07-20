package com.example.website.controllers;

import com.example.website.models.PhoneNumber;
import com.example.website.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @GetMapping("/enter")
    public String enter(Model model){
        return "admin_enter";
    }
    @PostMapping("/enter")
    public String enterAdd(@RequestParam String username,
                           @RequestParam String password,
                           Model model){
        return "redirect:/admin";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        Iterable<PhoneNumber> numbers = phoneNumberRepository.findAll();
        model.addAttribute("numbers", numbers);
        return "admin_page";
    }
}
