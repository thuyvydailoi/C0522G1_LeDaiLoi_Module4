package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @RequestMapping("/")
    public String display() {
        return "/display";
    }


    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "/display";

    }
}
