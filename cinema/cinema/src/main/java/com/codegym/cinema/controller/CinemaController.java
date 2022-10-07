package com.codegym.cinema.controller;

import com.codegym.cinema.dto.CinemaDto;
import com.codegym.cinema.model.Cinema;
import com.codegym.cinema.service.ICinemaService;
import com.codegym.cinema.service.IFilmService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private ICinemaService iCinemaService;

    @Autowired
    private IFilmService iFilmService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("filmList", iFilmService.findAll());
        model.addAttribute("cinemaList", iCinemaService.findAll());
        return "/index";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteCinema(@PathVariable  Integer id, Model model){
        model.addAttribute("cinema", iCinemaService.findById(id));
        return "/delete";
    }

    @GetMapping("/delete")
    public String deleteCinema(@RequestParam(value = "cinemaId") Integer id, Model model){
        iCinemaService.delete(id);
        model.addAttribute("cinemaList", iCinemaService.findAll());
        return "redirect:/cinema";
    }

    @GetMapping("/create")
    public String showCreateCinema(Model model){
        model.addAttribute("filmList", iFilmService.findAll());
        model.addAttribute("cinemaDto", new CinemaDto());
        LocalDate minAge = LocalDate.now();
        model.addAttribute("minAge", minAge);
        return "/create";
    }

    @PostMapping("/save")
    public String saveCinema(@ModelAttribute  CinemaDto cinemaDto,
                             RedirectAttributes redirectAttributes,
                             BindingResult bindingResult,
                             Model model) {
        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("filmList", iFilmService.findAll());
            return "/create";
        }
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaDto,cinema);
        iCinemaService.save(cinema);
        redirectAttributes.addFlashAttribute("success" , "Add new cinema successfully!");
        return "redirect:/cinema";
    }
}
