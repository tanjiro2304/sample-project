package com.sampleproject.service;

import com.sampleproject.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(Long empId);
    List<Employee> employeeList();


}
