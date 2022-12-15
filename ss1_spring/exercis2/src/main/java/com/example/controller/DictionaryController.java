package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class DictionaryController {
    @RequestMapping("")
    public String loadIndex() {
        return "index";
    }

     @RequestMapping(value = "/result",method = RequestMethod.GET)
     public String getWithMap(@RequestParam("key") String key, Model model){
         Map<String , String> maps = new HashMap<>();
         maps.put("hello","xin chào");
         maps.put("love","yêu");
         maps.put("name","tên");
         maps.put("address","xin chào");

         if (maps.containsKey(key)){
             model.addAttribute("result",maps.get(key));
         }else {
             model.addAttribute("mess","not found");
         }
         return "view";
     }


}
