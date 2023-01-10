package com.example.controller;

import com.example.dto.IAttachFacilityDto;
import com.example.service.interfaceContract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/attach-facility/{id}")
    private ResponseEntity<List<IAttachFacilityDto>> show(@PathVariable("id") Integer id){
        List<IAttachFacilityDto> attachFacilityDtoList = attachFacilityService.showList(id);
        if (attachFacilityDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attachFacilityDtoList, HttpStatus.OK);
    }
}
