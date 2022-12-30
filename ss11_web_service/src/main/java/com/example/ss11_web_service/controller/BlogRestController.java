package com.example.ss11_web_service.controller;

import com.example.ss11_web_service.model.Blog;
import com.example.ss11_web_service.model.Category;
import com.example.ss11_web_service.service.IBlogService;
import com.example.ss11_web_service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getList(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @GetMapping("/getList")
    public ResponseEntity<List<Blog>> getBlogList(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(blogList,HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<List<Blog>> view(@PathVariable ("id") int id){
        List<Blog> blogList = blogService.findByBlog(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }
    @GetMapping("/display/{id}")
    public ResponseEntity<List<Blog>> views(@PathVariable ("id") int id){
        List<Blog> blogList = blogService.viewBlogById(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }



}
