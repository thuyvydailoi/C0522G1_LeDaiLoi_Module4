package com.codegym.controller;

import com.codegym.repository.IDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeclarationController {
    @Autowired
    IDeclarationRepository iDeclarationRepository;

    @RequestMapping("/")
    public String display() {
        return "home";
    }

}
