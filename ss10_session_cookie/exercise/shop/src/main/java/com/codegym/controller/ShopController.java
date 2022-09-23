package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ShopDto;
import com.codegym.model.Shop;
import com.codegym.service.IShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping("/shop")
public class ShopController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IShopService iShopService;

    @GetMapping
    public ModelAndView showList(Model model, @CookieValue(value = "id", defaultValue = "-1") int id) {
        if (id != -1) {
            model.addAttribute("shop", iShopService.findById(id).get());
        }
        return new ModelAndView("shop/index", "shopList", iShopService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response){
        Cookie cookie = new Cookie("id", id +"");
        cookie.setMaxAge(1*48*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return  new ModelAndView("shop/detail", "shops", iShopService.findById(id).get());

    }
    @GetMapping("/add/{id}")
    public String addToSession(@PathVariable int id, @SessionAttribute("cart") CartDto cartDto){
        Optional<Shop> shopDetail = iShopService.findById(id);
        if(shopDetail.isPresent()){
            ShopDto shopDto = new ShopDto();
            BeanUtils.copyProperties(shopDetail.get(), shopDto);
            cartDto.addShop(shopDto);
        }
        return "redirect:/cart";
    }
}
