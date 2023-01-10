package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer , Integer> {
   @Query(value = "select c.* from `customer` c join `customer_type` ct on c.customer_type_id = ct.id" +
           " where c.name like concat('%' :name '%') and c.email like concat('%' :email '%') " +
           "and ct.name like concat('%' :type '%') and c.flag_delete = false " ,nativeQuery = true)
    Page<Customer> searchCustomer(@Param("name")String name,@Param("email")String email,@Param("type") String Type ,Pageable pageable);

   @Query(value = "select * from `customer` where flag_delete = false",nativeQuery = true)
    Page<Customer> showList(Pageable pageable);
}
