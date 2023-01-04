package com.example.case_study_m4.service.impl.customer;

import com.example.case_study_m4.model.CustomerType;
import com.example.case_study_m4.repository.customer.ICustomerTypeRepository;
import com.example.case_study_m4.service.interfaceCustomer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
