package com.example.demo.service.impl;


import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {


    @Autowired
    IBlogRepository iBlogRepository;


    @Override
    public List<Blog> searchTitle(String title) {
        return iBlogRepository.searchTitle(title);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).get();
    }


    @Override
    public void update(Blog blog) {
         iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

}
