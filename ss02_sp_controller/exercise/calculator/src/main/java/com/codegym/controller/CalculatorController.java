package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @RequestMapping("/")
    public String display() {
        return "calculator";
    }


    @RequestMapping("/calculate")
    public String save(@RequestParam String string,
                       @RequestParam String firstNumber,
                       @RequestParam String secondNumber,
                       Model model
    ) {
        String result = iCalculatorService.result(firstNumber, secondNumber, string);
        model.addAttribute("result", result);
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        return "calculator";

    }
}
