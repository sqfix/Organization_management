package com.sqfix.controller;

import com.sqfix.model.Department;
import com.sqfix.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = {"/", ""})
    public List<Department> getAll() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Department getById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateDepartment(@PathVariable int id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable int id) {
        return departmentService.removeDepartmentById(id);
    }

}
