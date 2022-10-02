package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping
    public String showList (@PageableDefault (value = 5) Pageable pageable,
                            @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                            @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                            @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                            Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        for (Customer customer : customerList){
            if(customer.getDateOfBirth().contains("-")) {
                String[] arr = customer.getDateOfBirth().split("-");
                customer.setDateOfBirth(arr[2] +"/" + arr[1] + "/" + arr[0]);
            }
        }
        model.addAttribute("customerList", iCustomerService.search(nameSearch, addressSearch, phoneSearch, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);

        return "customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeList);
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
        iCustomerService.remove(customer.getCustomerId());
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
