package com.example.exercis.controller;

import com.example.exercis.exception.EnoughBookException;
import com.example.exercis.exception.OutOfBookException;
import com.example.exercis.model.Book;
import com.example.exercis.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/{id}-view")
    public String showFormView(@PathVariable int id, Model model){
        model.addAttribute("book",bookService.findById(id));
        return "/view";
    }

    @GetMapping("/{id}-borrow")
    public String borrowBook(@PathVariable int id,Model model) throws OutOfBookException {
        Book book = bookService.findById(id);
        if(book.getAmount()==0){
            throw new OutOfBookException();
        }else {
            book.setAmount(book.getAmount()-1);
            bookService.save(book);
            return "redirect:/";
        }
    }
    @ExceptionHandler(OutOfBookException.class)
    public String OutOfBook(){
        return "/outOfBook";
    }

    @GetMapping("/{id}-pay")
    public String payBook(@PathVariable int id,Model model) throws EnoughBookException {
        Book book = bookService.findById(id);

        if(book.getAmount()== book.getStartAmount()){
            throw  new EnoughBookException();
        }else {
            book.setAmount(book.getAmount()+1);
            bookService.save(book);
            return "redirect:/";

        }
    }

    @ExceptionHandler(EnoughBookException.class)
    public String Enough(){
        return "/enoughBook";
    }
}
