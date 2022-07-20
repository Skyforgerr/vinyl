package com.example.website.controllers;


import com.example.website.models.PhoneNumber;
import com.example.website.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @GetMapping("/form")
    public String about(Model model){
        Iterable<PhoneNumber> numbers = phoneNumberRepository.findAll();
        model.addAttribute("numbers", numbers);
        return "form_page";
    }

    @PostMapping("/form")
    public String formPostAdd(@RequestParam String number,
                              @RequestParam String name,
                              @RequestParam String disk,
                              Model model){
        PhoneNumber phoneNumber = new PhoneNumber(number, name, disk);
        phoneNumberRepository.save(phoneNumber);
        return "redirect:/rare";
    }
}
