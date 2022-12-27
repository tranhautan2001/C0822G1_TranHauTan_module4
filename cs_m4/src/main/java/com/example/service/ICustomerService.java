package com.example.service;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> finAll(Pageable pageable);
    boolean save(Customer customer );
    void delete(int id);
    boolean update(Customer customer);
    Customer findById(int id);
    Page<Customer> search(String name, String email, String type, Pageable pageable);

}
