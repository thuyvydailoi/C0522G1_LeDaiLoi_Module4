package com.codegym.service.employee.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmloyeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmloyeeRepository iEmloyeeRepository;

    @Override
    public List<Employee> findAll() {
        return iEmloyeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return iEmloyeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmloyeeRepository.save(employee);
    }

    @Override
    public Page<Employee> searchEmployee(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return iEmloyeeRepository.searchEmployee(nameSearch, phoneSearch, addressSearch, pageable);
    }

    @Override
    public void delete(Integer id) {
        iEmloyeeRepository.deleteLogical(id);
    }

    @Override
    public void update(Employee employee) {
        iEmloyeeRepository.save(employee);
    }
}
