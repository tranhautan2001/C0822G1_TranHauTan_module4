package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.impl.CustomerService;
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
    private  final ICustomerService iCustomerService = new CustomerService();


    @GetMapping("")
    public String index(Model model){
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        return "/list";
    }

    @GetMapping ("/create")
    public String showCreate(Model model){
        model.addAttribute("customers",new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute(name = "customers") Customer customer){
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

}
