package com.caculator.controller;

import com.caculator.service.CaculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class CaculateController {
    @Autowired
    private CaculateService caculateService;

    @GetMapping("")
    private String caculate(){
        return "caculator/index";
    }
    @GetMapping("/caculate")
    private String caculator(@RequestParam("first-number") double fristNumber , char calculations, @RequestParam("second-number") double secondNumber , Model model){
        double result = caculateService.caculate(fristNumber, calculations, secondNumber);
        model.addAttribute("result",result);
        return "caculator/index";
    }

}
