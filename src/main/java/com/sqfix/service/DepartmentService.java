package com.sqfix.service;

import com.sqfix.model.Department;
import com.sqfix.repository.DepartmentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentsRepository departmentsRepository;

    public List<Department> getAllDepartments() {
        LOGGER.info("Get All Departments");
        return departmentsRepository.findAll();
    }

    private Department getDepByName(String name) {
        return departmentsRepository.findByName(name);
    }

    public String saveDepartment(Department department) {
        LOGGER.info("Saving department " + department);
        if (getDepByName(department.getName()) != null)
            return "Department already exists!";
        departmentsRepository.save(department);
        return "Department saved successfully";
    }

    public Department getDepartmentById(int id) {
        LOGGER.info("Get department by id " + id);
        return departmentsRepository.findById(id);
    }

    public String updateDepartment(int id, Department department) {
        LOGGER.info("Update department " + id);
        Department tempDep = getDepartmentById(id);
        if (tempDep == null)
            return "Department is not exists!";
        tempDep.setName(department.getName());
        tempDep.setOrg(department.getOrg());
        return "edit OK!";
    }

    public String removeDepartmentById(int id) {
        LOGGER.info("Remove department " + id);
        if (getDepartmentById(id) == null)
            return "Department is not exists!";
        departmentsRepository.delete(id);
        return "Remove OK!";
    }
}
