package com.sqfix.service;

import com.sqfix.model.Employee;
import com.sqfix.repository.EmployeesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeesRepository employeesRepository;

    public List<Employee> getAllEmployees() {
        LOGGER.info("Get All Employees");
        return employeesRepository.findAll();
    }

    private Employee getEmpByName(String name) {
        return employeesRepository.findByName(name);
    }

    public String saveEmployee(Employee employee) {
        LOGGER.info("Saving employee " + employee);
        if (getEmpByName(employee.getName()) != null)
            return "Employee already exists!";
        employeesRepository.save(employee);
        return "Employee saved successfully";
    }

    public Employee getEmpById(int id) {
        LOGGER.info("Get employee by id " + id);
        return employeesRepository.findOne(id);
    }

    public String updateEmployee(int id, Employee employee) {
        LOGGER.info("Update employee " + id);
        Employee tempEmp = getEmpById(id);
        if (tempEmp == null)
            return "Employee is not exists!";
        tempEmp.setDep(employee.getDep());
        tempEmp.setName(employee.getName());
        return "edit OK!";
    }

    public String removeEmployeeById(int id) {
        LOGGER.info("Remove employee " + id);
        if (getEmpById(id) == null)
            return "Employee is not exists!";
        employeesRepository.delete(id);
        return "Remove OK!";
    }
}
