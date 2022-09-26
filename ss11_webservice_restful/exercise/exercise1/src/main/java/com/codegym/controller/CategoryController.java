package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> categoryList() {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> showBlogCategory(@PathVariable int id) {
        Category category = iCategoryService.findById(id).get();
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}

//    @GetMapping("")
//    public String index(Model model) {
//        List<Category> categoryList = iCategoryService.findAll();
//        model.addAttribute("categorys", categoryList);
//        return "/category/index";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("category", new Category());
//        return "/category/create";
//    }
//
//    @PostMapping("/save")
//    public String save(Category category) {
//        iCategoryService.save(category);
//        return "redirect:/category";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("category", iCategoryService.findByCategoryId(id));
//        return "category/edit";
//    }
//
//    @PostMapping("/update")
//    public String update(Category category) {
//        iCategoryService.update(category);
//        return "redirect:/category";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String showDelete(@PathVariable int id, Model model) {
//        model.addAttribute("category", iCategoryService.findByCategoryId(id));
//        return "category/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(Category category, RedirectAttributes redirect) {
//        iCategoryService.remove(category.getCategoryId());
//        redirect.addFlashAttribute("success", "Removed category successfully!");
//        return "redirect:/category";
//    }
//
//    @GetMapping("/view/{id}")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("category", iCategoryService.findByCategoryId(id));
//        return "category/view";
//    }



