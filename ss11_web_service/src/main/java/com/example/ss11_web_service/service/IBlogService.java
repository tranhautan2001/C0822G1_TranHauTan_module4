package com.example.ss11_web_service.service;


import com.example.ss11_web_service.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> searchTitle(String title , Pageable pageable);

    boolean save(Blog blog );

    Blog findById(int id);

    Boolean update(Blog blog);

    void delete(int id);

    List<Blog >  findAll();
    List<Blog> findByBlog(int id);

    List<Blog> viewBlogById(int id);
}
