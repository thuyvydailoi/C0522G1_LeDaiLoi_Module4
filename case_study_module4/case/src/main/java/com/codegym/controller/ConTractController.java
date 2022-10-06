package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ConTractController {
//
//    @Autowired
//    private IC
//    @GetMapping("/list")
//    public String showList(@PageableDefault(value = 5) Pageable pageable,
//                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
//                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
//                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
//                           Model model) {
//        List<Customer> customerList = iCustomerService.findAll();
//        for (Customer customer : customerList) {
//            if (customer.getCustomerBirthday().contains("-")) {
//                String[] arr = customer.getCustomerBirthday().split("-");
//                customer.setCustomerBirthday(arr[2] + "/" + arr[1] + "/" + arr[0]);
//            }
//        }
}
