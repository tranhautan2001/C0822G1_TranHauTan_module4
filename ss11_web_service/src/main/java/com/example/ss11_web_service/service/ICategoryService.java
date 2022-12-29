package com.example.ss11_web_service.service;


import com.example.ss11_web_service.model.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();
}
