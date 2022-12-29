package com.example.ss11_web_service.service.impl;


import com.example.ss11_web_service.model.Category;
import com.example.ss11_web_service.repository.ICategoryRepository;
import com.example.ss11_web_service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
