package com.codegym.controller;

import com.codegym.dto.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/facility")
@Controller
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch, Model model) {
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        Page<Facility> facilityList = facilityService.searchFacility(nameSearch, pageable);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "facility/index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("mess", "Add " + facility.getFacilityName() +
                    " successfully");
            return "redirect:/facility/list";

        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        facilityService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("mess", "delete success " +
                facilityService.findById(id).get().getFacilityName() + " success");
        return "redirect:/facility/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model ) {
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facilityService.findById(id).get(), facilityDto);
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("facilityDto", facilityDto);
        return "facility/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "facility/edit";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.update(facility);
            redirectAttributes.addFlashAttribute("mess", "Update successfully!");
            return "redirect:/facility/list";
        }
    }
}
