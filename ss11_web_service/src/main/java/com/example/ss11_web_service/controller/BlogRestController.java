package com.example.ss11_web_service.controller;

import com.example.ss11_web_service.model.Blog;
import com.example.ss11_web_service.model.Category;
import com.example.ss11_web_service.service.IBlogService;
import com.example.ss11_web_service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getList(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<List<Blog>> getBlogList(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<List<Blog>> view(@PathVariable ("id") int id){
        List<Blog> blogList = blogService.findByBlog(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }
    @GetMapping("/display/{id}")
    public ResponseEntity<List<Blog>> views(@PathVariable ("id") int id){
        List<Blog> blogList = blogService.viewBlogById(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }

}
