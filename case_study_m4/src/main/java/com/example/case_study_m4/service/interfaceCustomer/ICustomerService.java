package com.example.case_study_m4.service.interfaceCustomer;

import com.example.case_study_m4.model.Customer;
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
