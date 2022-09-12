package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService iConvertService;

    @GetMapping("/")
    public String dictionary(){
        return "/list";
    }

    @GetMapping("convert")
    public String convert(@RequestParam double usd, Model model){
        Double convertMoney = iConvertService.money(usd);
        model.addAttribute("convertMoney", convertMoney);
        return "/list";
    }
}
