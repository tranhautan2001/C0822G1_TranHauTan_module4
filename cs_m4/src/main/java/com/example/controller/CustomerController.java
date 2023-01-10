package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.interfaceCustomer.ICustomerService;
import com.example.service.interfaceCustomer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String showList(Model model,@PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerList",customerService.finAll(pageable));
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name", defaultValue = "")  String name ,@RequestParam(value = "email",defaultValue = "") String email,@RequestParam(value = "type",defaultValue = "") String type, Model model, @PageableDefault(value = 5)Pageable pageable) {
        model.addAttribute("customerList",customerService.search(name,email,type,pageable));
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("customerDto",new CustomerDto());
        return "customer/add";
    }
    @PostMapping("/save")
        public String create(@Validated @ModelAttribute CustomerDto customerDto,
                BindingResult bindingResult,Model model){
            if (bindingResult.hasErrors()){
                List<CustomerType> customerTypes = customerTypeService.findAll();
                model.addAttribute("customerTypes",customerTypes);
                return "customer/add";
            }
                Customer customer = new Customer();
                BeanUtils.copyProperties(customerDto,customer);
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
