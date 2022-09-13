package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DeclarationController {
    @Autowired
    IDeclarationService iDeclarationService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("declationList", iDeclarationService.findAll());
        return "home";
    }

    @GetMapping("/show_create")
    public String showCreate(Model model) {
        model.addAttribute("createDeclaration", new Declaration());
        model.addAttribute("dateOfBirthList", iDeclarationService.dateOfBirthList());
        model.addAttribute("genderList", iDeclarationService.genderList());
        model.addAttribute("natronalityList", iDeclarationService.natronalityList());
        model.addAttribute("renderList", iDeclarationService.renderList());
        model.addAttribute("starDayList", iDeclarationService.startDayList());
        model.addAttribute("starMonthList", iDeclarationService.startMonthList());
        model.addAttribute("starYearList", iDeclarationService.startYearList());
        model.addAttribute("endDayList", iDeclarationService.endDayList());
        model.addAttribute("endMonthList", iDeclarationService.endMonthList());
        model.addAttribute("endYearList", iDeclarationService.endYearList());
        return "create";
    }

    @PostMapping("/create")
    public String create(Declaration declaration) {
        iDeclarationService.save(declaration);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam String identity, Model model) {
        model.addAttribute("dateOfBirthList", iDeclarationService.dateOfBirthList());
        model.addAttribute("genderList", iDeclarationService.genderList());
        model.addAttribute("natronalityList", iDeclarationService.natronalityList());
        model.addAttribute("renderList", iDeclarationService.renderList());
        model.addAttribute("starDayList", iDeclarationService.startDayList());
        model.addAttribute("starMonthList", iDeclarationService.startMonthList());
        model.addAttribute("starYearList", iDeclarationService.startYearList());
        model.addAttribute("endDayList", iDeclarationService.endDayList());
        model.addAttribute("endMonthList", iDeclarationService.endMonthList());
        model.addAttribute("endYearList", iDeclarationService.endYearList());
        model.addAttribute("declarationList", iDeclarationService.findOne(identity));
        return "update";
    }

    @PostMapping("/update")
    public String update(Declaration declaration) {
        iDeclarationService.update(declaration.getIdentity(), declaration);
        return "redirect:/";
    }
}
