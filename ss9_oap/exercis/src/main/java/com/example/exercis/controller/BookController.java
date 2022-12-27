package com.example.exercis.controller;

import com.example.exercis.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showBook(Model model){
        model.addAttribute("bookList",bookService.findAll());
        return "/list";
    }

}
