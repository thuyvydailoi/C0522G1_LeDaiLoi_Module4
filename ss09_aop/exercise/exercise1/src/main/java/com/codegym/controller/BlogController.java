package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/blog";
    }

        @GetMapping("/view/{id}")
        public String view(@PathVariable int id, Model model) {
            model.addAttribute("blog", blogService.findById(id));
            return "blog/view";
        }

//    @GetMapping("")
//    public String showList(@PageableDefault(value = 5, sort = "dateCreate", direction = Sort.Direction.DESC)
//               Pageable pageable, @RequestParam(value = "search", defaultValue = "")
//                                       String search, Model model) {
//
//        model.addAttribute("blogs", blogService.findAllByBlogNameContaining(search, pageable));
//        model.addAttribute("categorys", categoryService.findAll());
//        model.addAttribute("search", search);
//
//        return "/blog/index";
//    }

    @GetMapping("")
    public String showList(@PageableDefault(value = 5, sort = "date_create", direction = Sort.Direction.DESC)
                                   Pageable pageable, @RequestParam(value = "search", defaultValue = "")
                                   String search, Model model) {

        model.addAttribute("blogs", blogService.showList());
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("search", search);

        return "/blog/list";
    }
}