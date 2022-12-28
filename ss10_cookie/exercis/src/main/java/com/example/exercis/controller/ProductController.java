package com.example.exercis.controller;

import com.example.exercis.model.Cart;
import com.example.exercis.model.Product;
import com.example.exercis.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @RequestMapping
    public String getHome(Model model){
        model.addAttribute("list",productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Cart cart, Model model) {
        Product product = productService.findById(id);
        if (product == null){
            return "/error";
        }
      cart.addProduct(product);
        model.addAttribute("list",cart.getProducts());
      model.addAttribute("cart",cart);
        return "/card";
    }



}
