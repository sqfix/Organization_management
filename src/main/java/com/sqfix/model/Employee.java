package com.sqfix.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dep_id", nullable = false, updatable = false)
    private Department dep;

    @OneToMany(cascade = ALL, fetch = FetchType.LAZY)
    private List<Employee> subordinate = Collections.emptyList();

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

    @JsonIgnore
    public List<Employee> getSubordinates() {
        return subordinate;
    }

    public void setSubordinate(List<Employee> subordinate) {
        this.subordinate = subordinate;
    }
}
