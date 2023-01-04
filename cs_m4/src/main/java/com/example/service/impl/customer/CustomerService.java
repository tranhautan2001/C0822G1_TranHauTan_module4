package com.example.service.impl.customer;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.interfaceCustomer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<Customer> finAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public boolean save(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;


    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean update(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;

    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }


    @Override
    public Page<Customer> search(String name, String email, String type, Pageable pageable) {
        return customerRepository.searchCustomer(name,email,type,pageable);
    }
}
