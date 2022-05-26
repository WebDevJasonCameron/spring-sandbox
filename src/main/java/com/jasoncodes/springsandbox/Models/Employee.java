package com.jasoncodes.springsandbox.Models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String role;


    // CON
    public Employee() {

    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }



    // GET
    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getRole() {
        return this.role;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }


    // SET
    public void setRole(String role) {
        this.role = role;
    }


    // OVER
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }


    // CHECK
    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }
}