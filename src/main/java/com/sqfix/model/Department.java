package com.sqfix.model;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "org_id", nullable = false, updatable = false)
    private Organization org;

    public Department() {
    }

    public Department(String name, Organization organization) {
        this.name = name;
        this.org = organization;

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

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }
}
