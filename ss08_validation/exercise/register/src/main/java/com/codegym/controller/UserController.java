package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.model.UserDto;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

       @GetMapping("")
       public String index(Model model) {
           List<User> userList = iUserService.findAll();
           model.addAttribute("userList", userList);
           return "/index";
       }

    @GetMapping("/create")
    public String showCreate(Model model) {
           model.addAttribute("userDto", new UserDto());
        return "/create";
    }
    @PostMapping("/save")
    public String createUser(@ModelAttribute @Validated UserDto userDto,
                             BindingResult bindingResult, Model model,
                             RedirectAttributes redirectAttributes){
           new UserDto().validate(userDto, bindingResult);

           if(bindingResult.hasFieldErrors()) {
               model.addAttribute("userList", iUserService.findAll());
               return "create";
           } else {
               User user = new User();

               BeanUtils.copyProperties(userDto, user);

               iUserService.save(user);
               redirectAttributes.addFlashAttribute("message",
                       "Create user: " + user.getFirstName() +
                               user.getLastName() +"Success!");
               return  "redirect:/";
           }
    }
}
