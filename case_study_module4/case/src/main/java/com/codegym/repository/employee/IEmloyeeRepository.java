package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmloyeeRepository extends JpaRepository<Employee, Integer> {
}
