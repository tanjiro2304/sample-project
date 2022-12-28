package com.sampleproject.modules.employeeinfo;

import com.sampleproject.entities.Employee;
import com.sampleproject.mvputils.BasePresenter;
import com.sampleproject.service.EmployeeService;
import com.sampleproject.servicewrapper.EmployeeWrapperService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@UIScope
@SpringComponent
public class EmployeeInfoPresenter extends BasePresenter<EmployeeInfoView> {

    @Autowired
    EmployeeWrapperService employeeWrapperService;

    public List<Employee> employees(){
        List<Employee> employeeList = employeeWrapperService.getAllEmployees();
        return employeeWrapperService.getAllEmployees();
    }
}
