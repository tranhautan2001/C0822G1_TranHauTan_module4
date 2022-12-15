package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.service.ICaculatorService;

@RequestMapping("")
@Controller
public class CaculatorController {
   @Autowired
    private ICaculatorService caculatorService;

    @GetMapping("")
    private String caculator(){
        return "/index";
    }
    @GetMapping("/caculator")
    private String caculator(@RequestParam(value = "numberOne") Double fristNumber, char calculations, @RequestParam (value = "second-number") Double secondNumber, Model model){

        double result = caculatorService.caculator(fristNumber, calculations, secondNumber);
        model.addAttribute("result", result);
        return "index";
    }

}
