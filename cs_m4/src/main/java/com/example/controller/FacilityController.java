package com.example.controller;

import com.example.service.interfaceFacility.IFacilityService;
import com.example.service.interfaceFacility.IFacilityTypeService;
import com.example.service.interfaceFacility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
