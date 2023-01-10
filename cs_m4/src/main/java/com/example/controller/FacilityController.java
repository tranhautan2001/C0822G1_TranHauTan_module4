package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.FacilityDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.interfaceFacility.IFacilityService;
import com.example.service.interfaceFacility.IFacilityTypeService;
import com.example.service.interfaceFacility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showList(Model model , @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("facilityList",facilityService.finAll(pageable));
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        return "facility/list";
    }
    @PostMapping("/delete")
    public String delete(int id){
        facilityService.delete(id);
        return "redirect:/facility";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("rentTypeList",rentTypeList);
        model.addAttribute("facilityTypeList",facilityTypeList);
        return "facility/add";
    }
    @PostMapping("/save")
    public String create(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<RentType> rentTypeList = rentTypeService.findAll();
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            model.addAttribute("rentTypeList",rentTypeList);
            model.addAttribute("facilityTypeList",facilityTypeList);
            return "facility/add";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return "redirect:/facility";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        Facility facility = facilityService.findById(id);
        model.addAttribute("facilityType",facility.getFacilityType().getId()); // tìm id để so sánh với bên Edit. html
        model.addAttribute("facilityUpdate",facilityService.findById(id));
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("renTypeUpdate",rentTypeList);
        model.addAttribute("facilityTypeUpdate",facilityTypeList);
        return "facility/edit";
    }
    @PostMapping("edit")
    public String edit( Facility facility){
        facilityService.update(facility);
        return "redirect:/facility";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name",defaultValue = "") String name ,@RequestParam(value = "name", defaultValue = "")  Integer FacilityTypeId, Model model,@PageableDefault( value = 5) Pageable pageable ){
        model.addAttribute("facilityList",facilityService.search(name,FacilityTypeId , pageable));
        model.addAttribute("facilityType",facilityTypeService.findAll());
        return "facility/list";
    }



}
