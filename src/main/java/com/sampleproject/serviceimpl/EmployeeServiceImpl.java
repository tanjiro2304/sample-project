package com.sampleproject.serviceimpl;

import com.sampleproject.entities.Employee;
import com.sampleproject.repo.EmployeeRepo;
import com.sampleproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee getEmployee(Long empId) {
        return employeeRepo.findById(empId).get();
    }

    public List<Employee> employeeList(){
        return employeeRepo.findAll();
    }
}
