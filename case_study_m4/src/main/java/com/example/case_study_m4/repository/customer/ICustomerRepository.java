package com.example.case_study_m4.repository.customer;

import com.example.case_study_m4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.* from `customer` c join `customer_type` ct on c.customer_type = ct.id where c.name like concat('%' :name '%') and c.email like concat('%' :email '%') and ct.name like concat('%' :type '%') " ,nativeQuery = true)
    Page<Customer> searchCustomer(@Param("name")String name, @Param("email")String email, @Param("type") String Type , Pageable pageable);

}
