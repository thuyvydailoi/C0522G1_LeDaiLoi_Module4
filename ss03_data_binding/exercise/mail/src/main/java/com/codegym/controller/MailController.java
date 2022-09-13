package com.codegym.controller;

import com.codegym.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {

    @RequestMapping("/")
    public String display() {
        return "setting";
    }

    @GetMapping("/save")
    public String edit(Model model) {
        model.addAttribute("mail", new Mail());
        return "setting";
    }

    @PostMapping("/save")
    public String update(@ModelAttribute Mail mail, Model model) {
        model.addAttribute("languages", mail.getLanguages());
        model.addAttribute("pageSize", mail.getPageSize());
        model.addAttribute("spamFilter", mail.getSpamFilter());
        model.addAttribute("signature", mail.getSignature());

        if (!mail.getSpamFilter()) {
            mail.setSpamFilter(false);
        }
        if (mail.getSignature().equals("")) {
            mail.setSignature("user not character name");
        }
        model.addAttribute("mail", mail);
        return "info";
    }
}
