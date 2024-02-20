package com.learn.springboot.cruddemo.service;

import com.learn.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);
    void deleteById(int id);
}
