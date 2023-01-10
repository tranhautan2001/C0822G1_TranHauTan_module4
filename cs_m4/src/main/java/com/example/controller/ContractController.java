package com.example.controller;

import com.example.dto.ContractDto;
import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;
import com.example.repository.customer.ICustomerRepository;
import com.example.repository.employee.IEmployeeRepository;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.interfaceContract.IAttachFacilityService;
import com.example.service.interfaceContract.IContractDetailService;
import com.example.service.interfaceContract.IContractService;
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
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IFacilityRepository facilityRepository;
    @Autowired
    private IEmployeeRepository employeeRepository;


    @GetMapping("")
    public String showList(Model model ,@PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("contractList", contractService.findAll(pageable));
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
        model.addAttribute("customerList", customerRepository.findAll());
        model.addAttribute("facilityList", facilityRepository.findAll());
        model.addAttribute("employeeList", employeeRepository.findAll());
        model.addAttribute("contractDetail",new ContractDetail());
        return "/contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        List<Customer> customerList = customerRepository.findAll();
        List<Facility> facilityList = facilityRepository.findAll();
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("contractDetailList", contractDetailList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("employeeList", employeeList);
        return "contract/add";
    }

    @PostMapping("save")
    public String create(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Customer> customerList = customerRepository.findAll();
            List<Facility> facilityList = facilityRepository.findAll();
            List<Employee> employeeList = employeeRepository.findAll();
            model.addAttribute("customerList", customerList);
            model.addAttribute("facilityList", facilityList);
            model.addAttribute("employeeList", employeeList);
            return "contract/add";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.add(contract);
        return "redirect:/contract";
    }

    @PostMapping("/add")
    public String showAdd(ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }
    @PostMapping("show")
    public String showId(Model model,AttachFacility attachFacility, @PathVariable("id") int id){
        attachFacility = attachFacilityService.finByID(id);
        model.addAttribute("attact",attachFacility);
        return "redirect:/contract";

    }

}