package com.learn.springboot.cruddemo.rest;

import com.learn.springboot.cruddemo.dao.EmployeeDAO;
import com.learn.springboot.cruddemo.entity.Employee;
import com.learn.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee postEmployeeById(@RequestBody Employee theEmployee){
//        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee editEmployeeById(@RequestBody Employee theEmployee){
//        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee id number "+employeeId+" has been succcessfully deleted";
    }
}
