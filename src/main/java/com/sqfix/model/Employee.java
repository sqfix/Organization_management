package com.sqfix.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "dep_id", nullable = false, updatable = false)
    private Department dep;

    public Employee() {
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.dep = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }
}
