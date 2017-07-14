package com.sqfix.repository;


import com.sqfix.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Integer>{

    Department findByName(String name);

    Department findById(int id);
}
