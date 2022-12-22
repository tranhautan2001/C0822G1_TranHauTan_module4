package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> searchTitle(String title , Pageable pageable);

    boolean save(Blog blog );

    Blog findById(int id);

    Boolean update(Blog blog);

    void delete(int id);


}
