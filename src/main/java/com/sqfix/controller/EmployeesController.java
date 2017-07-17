package com.sqfix.controller;

import com.sqfix.model.Employee;
import com.sqfix.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = {"/", ""})
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable int id) {
        return employeeService.getEmpById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable int id) {
        return employeeService.removeEmployeeById(id);
    }

    @RequestMapping(value = "sub/{empId}")
    public List<Employee> getSubordinatesByEmployeeId(@PathVariable int empId) {
        return employeeService.getEmpById(empId).getSubordinates();
    }

}
