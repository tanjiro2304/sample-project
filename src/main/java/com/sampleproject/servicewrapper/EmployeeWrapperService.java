package com.sampleproject.servicewrapper;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sampleproject.entities.Employee;
import com.sampleproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Component
public class EmployeeWrapperService {

    @Autowired
    private EmployeeService employeeService;

    private LoadingCache<Long, Employee> loadingCache = CacheBuilder.newBuilder().build(new CacheLoader<Long, Employee>() {
        @Override
        public Employee load(Long empId) throws Exception {
            return employeeService.getEmployee(empId);
        }

        @Override
        public Map<Long, Employee> loadAll(Iterable<? extends Long> keys) throws Exception {
            Map<Long, Employee> employeeMap = new HashMap<>();
            List<Employee> employeeList = employeeService.employeeList();
            employeeList.stream().forEach(employee -> employeeMap.put(employee.getId(),employee));
            System.out.println(employeeMap);
            return employeeMap;
        }
    });

    public Employee getEmployee(Long empId){
        try {
            return loadingCache.get(empId);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAllEmployees(){
        Map<Long, Employee> employeeMap = loadingCache.asMap();
        return new ArrayList<>(employeeMap.values());
    }
}
