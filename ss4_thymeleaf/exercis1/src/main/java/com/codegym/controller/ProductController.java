package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService iProductService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("products",productList);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate (Model model){
        model.addAttribute("productList",new Product());
        return "/create";
    }

    @PostMapping("save")
    public String create(@ModelAttribute(name = "productList") Product product){
        iProductService.save(product);
        return "redirect:/product";
    }



    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/delete";
    }
    @PostMapping("delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success","removed product successfully?");
        return "redirect:/product";

    }

/*
    display view
*/
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id , Model model){
        model.addAttribute("productView",iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id,Model model){
      model.addAttribute("productUpdate",iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Product product){
        iProductService.update(product.getId(),product);
        return "redirect:/product";
    }

}
