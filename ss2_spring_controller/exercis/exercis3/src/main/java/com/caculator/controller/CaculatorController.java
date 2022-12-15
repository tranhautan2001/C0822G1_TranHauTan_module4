package com.caculator.controller;

import com.caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class CaculatorController {
    @Autowired
    private ICaculatorService iCaculatorService;

    @GetMapping("")
    private String caculator(){
        return "caculator/index";
    }
    @GetMapping("/caculator")
    private String caculator(@RequestParam("first-number") double fristNumber , char calculations, @RequestParam("second-number") double secondNumber , Model model){
        double result = iCaculatorService.caculator(fristNumber, calculations, secondNumber);
        model.addAttribute("result",result);
        return "caculator/index";
    }

}
