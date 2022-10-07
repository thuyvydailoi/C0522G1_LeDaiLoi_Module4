package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    void save(Employee employee);

    Page<Employee> searchEmployee(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

    void delete(Integer id);

    void update(Employee employee);

}









