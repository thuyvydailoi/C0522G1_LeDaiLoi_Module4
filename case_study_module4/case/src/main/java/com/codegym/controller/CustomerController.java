package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

//    @Autowired
//    private ICustomerRepository iCustomerRepository;

        @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customers", customerList);
        return "customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
//        model.addAttribute("categoryList", categoryList);
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        iCustomerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        iCustomerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/view";
    }

//    @GetMapping("")
//    public String showList(@PageableDefault(value = 5, sort = "dateCreate", direction = Sort.Direction.DESC)
//                                   Pageable pageable, @RequestParam(value = "search", defaultValue = "")
//                                   String search, Model model) {
//
//        model.addAttribute("blogs", blogService.findAllByBlogNameContaining(search, pageable));
//        model.addAttribute("categorys", categoryService.findAll());
//        model.addAttribute("search", search);
//
//        return "/blog/index";
//    }
}
