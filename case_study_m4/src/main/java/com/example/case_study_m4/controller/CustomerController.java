package com.example.case_study_m4.controller;

import com.example.case_study_m4.model.Customer;
import com.example.case_study_m4.model.CustomerType;
import com.example.case_study_m4.service.interfaceCustomer.ICustomerService;
import com.example.case_study_m4.service.interfaceCustomer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerList",customerService.finAll(pageable));
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        return "customer/list";
    }
    @GetMapping("/search")
    public String search(String name, String email, String type, Model model, @PageableDefault(value = 5)Pageable pageable) {
        model.addAttribute("customerList",customerService.search(name,email,type,pageable));
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
    @PostMapping ("/delete")
    public String delete(int id){
        customerService.delete(id);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable int id, Model model){
        model.addAttribute("customerUpdate",customerService.findById(id));
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeUpdate",customerTypeList);
        return "customer/edit";
    }
    @PostMapping("edit")
    public String update(Customer customer){
        customerService.update(customer);
        return "redirect:/customer";
    }
}
