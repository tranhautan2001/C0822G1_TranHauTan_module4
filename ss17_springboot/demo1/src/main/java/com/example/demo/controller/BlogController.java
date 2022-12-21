package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping("")
    public String index(Model model, @RequestParam(name ="title",defaultValue = "")String title){
        List<Blog> blogList = iBlogService.searchTitle(title);
        model.addAttribute("blogList",blogList);
        model.addAttribute("title",title);
        return "views/list";

    }
    @GetMapping("/create")
    public String showCreate (Model model){
        model.addAttribute("blogList",new Blog());
        return "views/create";
    }

    @PostMapping("save")
    public String create(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("blogUpdate",iBlogService.findById(id));
        return "views/edit";
    }

    @PostMapping("/edit")
    public String update(Blog blog){
        iBlogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blogDelete",iBlogService.findById(id));
        return "views/delete";
    }
    @PostMapping("delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.delete(blog.getId());
        redirectAttributes.addFlashAttribute("success","removed blog successfully?");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/display")
    public String view(@PathVariable int id , Model model){
        model.addAttribute("blogView",iBlogService.findById(id));
        return "views/display";
    }

}
