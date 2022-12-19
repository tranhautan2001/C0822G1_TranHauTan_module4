package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "John", "100","hot", "Hanoi"));
        productList.put(2, new Product(2, "Bill", "200","hot", "Danang"));
        productList.put(3, new Product(3, "Alex", "300","hot", "Saigon"));
        productList.put(4, new Product(4, "Adam", "400","hot", "Beijin"));
        productList.put(5, new Product(5, "Sophia","500","hot", "Miami"));
        productList.put(6, new Product(6, "Rose", "600","hot", "Newyork"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
         productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
       productList.put(id,product);
    }

    @Override
    public void remove(int id) {
       productList.remove(id);
    }
}
