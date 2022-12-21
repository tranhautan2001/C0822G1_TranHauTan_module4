package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> searchTitle(String title);

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void delete(int id);


}
