package com.sqfix;

import com.sqfix.model.Department;
import com.sqfix.model.Employee;
import com.sqfix.model.Organization;
import com.sqfix.repository.DepartmentsRepository;
import com.sqfix.repository.EmployeesRepository;
import com.sqfix.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Fill test data into tables
     *
     * @param organizationRepository
     * @param departmentsRepository
     * @param employeesRepository
     */
    @Autowired
    public void initManager(OrganizationRepository organizationRepository,
                            DepartmentsRepository departmentsRepository,
                            EmployeesRepository employeesRepository) {
        Organization coreValueOrg = new Organization("CoreValue");
        Department coreValueHR = new Department("HR", coreValueOrg);
        Department coreValueDev = new Department("Dev", coreValueOrg);
        Employee employeeHRFirst = new Employee("John", coreValueHR);
        Employee employeeDevFirst = new Employee("Richard", coreValueDev);
        Employee employeeDevSecond = new Employee("Dave", coreValueDev);

        organizationRepository.save(coreValueOrg);
        departmentsRepository.save(coreValueHR);
        departmentsRepository.save(coreValueDev);

        employeesRepository.save(employeeHRFirst);
        employeesRepository.save(employeeDevFirst);
        employeesRepository.save(employeeDevSecond);
    }
}
