package com.example.exercis.service;

import com.example.exercis.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);

}
