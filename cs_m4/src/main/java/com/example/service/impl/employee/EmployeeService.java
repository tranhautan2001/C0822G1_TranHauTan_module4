package com.example.service.impl.employee;

import com.example.model.employee.Employee;
import com.example.repository.employee.IEmployeeRepository;
import com.example.service.interfaceEmployee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
