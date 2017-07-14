package com.sqfix.repository;


import com.sqfix.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);

    Employee findById(int id);
}
