package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IEmloyeeRepository extends JpaRepository<Employee, Integer> {
}
