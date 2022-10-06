package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                           Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        for (Customer customer : customerList) {
            if (customer.getCustomerBirthday().contains("-")) {
                String[] arr = customer.getCustomerBirthday().split("-");
                customer.setCustomerBirthday(arr[2] + "/" + arr[1] + "/" + arr[0]);
            }
        }

        model.addAttribute("customerList", iCustomerService.searchCustomer(nameSearch, addressSearch,
                phoneSearch, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);

        return "/customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
         if (bindingResult.hasFieldErrors()) {
            //Kiểm tra lỗi trả về create và ngược lại
            List<CustomerType> customerTypes = iCustomerTypeService.findAll();
            model.addAttribute("customerTypes",customerTypes);
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("mess","Add " + customer.getCustomerName() + "successfully");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable int id, Model model) {
        List<CustomerType> customerTypes = iCustomerTypeService.findAll();
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerTypeList",customerTypes);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes
                          ) {
     iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Update customer successfully!");
        return "redirect:/customer/list";
    }


    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/index";
    }

    @GetMapping ("/delete")
    public String delete(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirect) {
        iCustomerService.delete(id);
        redirect.addFlashAttribute("mess", "Removed customer successfully!");
        return "redirect:/customer/list";
    }
//
//    @GetMapping("/view/{id}")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("customer", iCustomerService.findById(id));
//        return "customer/view";
//    }

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