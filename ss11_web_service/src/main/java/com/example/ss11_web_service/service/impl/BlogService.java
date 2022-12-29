package com.example.ss11_web_service.service.impl;



import com.example.ss11_web_service.model.Blog;
import com.example.ss11_web_service.repository.IBlogRepository;
import com.example.ss11_web_service.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;


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

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public List<Blog> findByBlog(int id) {
        return iBlogRepository.findByBlog(id);
    }

    @Override
    public List<Blog> viewBlogById(int id) {
        return iBlogRepository.viewBlog(id);
    }


}
