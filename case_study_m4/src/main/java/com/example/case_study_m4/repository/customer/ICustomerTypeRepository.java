package com.example.case_study_m4.repository.customer;

import com.example.case_study_m4.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType , Integer> {
}
