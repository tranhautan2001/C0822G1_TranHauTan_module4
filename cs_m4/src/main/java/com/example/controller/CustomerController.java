package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("customerList",customerService.finAll());
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("customerList",new Customer());
        return "customer/add";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }

}
