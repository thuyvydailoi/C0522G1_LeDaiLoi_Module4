package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String dictionary() {
        return "/dictionary";
    }

    @GetMapping("dictionary1")
    public String dictionary(@RequestParam String english, Model model) {
        String translate = iDictionaryService.Distionary(english);
        if(translate != null){
            model.addAttribute("translate", translate);
        } else {
            model.addAttribute("translate", "Not found");
        }

        return "/dictionary";
    }
}
