package com.jasoncodes.springsandbox.Repositories;

import com.jasoncodes.springsandbox.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}