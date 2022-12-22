package com.example.demo.service.impl;


import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;


@Service
public class BlogService implements IBlogService {


    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> searchTitle(String title, Pageable pageable) {
        return iBlogRepository.searchTitle(title,pageable);
    }

    @Override
    public boolean save(Blog blog) {
        try {
            if (iBlogRepository.findByTitle(blog.getTitle() != null )) {
                throw new SQLDataException();
            }
            iBlogRepository.save(blog);
        } catch (IllegalArgumentException | OptimisticLockingFailureException | SQLDataException e) {
            return false;
        }
        return true;
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).get();
    }


    @Override
    public Boolean update(Blog blog) {
        if (!iBlogRepository.existsById(blog.getId())) {
            return false;
        }
        try {
            iBlogRepository.save(blog);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }


}
