package com.example.service;

import com.example.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> finAll();
    Customer save(Customer customer );

}
