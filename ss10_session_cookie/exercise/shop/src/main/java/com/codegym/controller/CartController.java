package com.codegym.controller;

import com.codegym.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(name = "cart", required = false)CartDto cartDto){
//        cartDto = new CartDto();
        return new ModelAndView("/cart/index", "cart", cartDto);
    }
}
