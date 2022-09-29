package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

//    @Autowired
//    private ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Blog>> blogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> searchBlog(@PathVariable String name) {
        List<Blog> blog = blogService.search(name);
        if (blog.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}

//    @GetMapping("/create")
//    public String create(Model model) {
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("categoryList", categoryList);
//        model.addAttribute("blog", new Blog());
//        return "/blog/create";
//    }
//
//    @PostMapping("/save")
//    public String save(Blog blog) {
//        blogService.save(blog);
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        return "blog/edit";
//    }
//
//    @PostMapping("/update")
//    public String update(Blog blog) {
//        blogService.update(blog);
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String showDelete(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        return "blog/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(Blog blog, RedirectAttributes redirect) {
//        blogService.remove(blog.getId());
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/view/{id}")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        return "blog/view";
//    }

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
