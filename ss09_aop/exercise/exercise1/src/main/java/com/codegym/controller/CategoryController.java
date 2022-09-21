package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String index(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categorys", categoryList);
        return "/category/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/save")
    public String save(Category category) {
        iCategoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findByCategoryId(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String update(Category category) {
        iCategoryService.update(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findByCategoryId(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        iCategoryService.remove(category.getCategoryId());
        redirect.addFlashAttribute("success", "Removed category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findByCategoryId(id));
        return "category/view";
    }

}
