package com.codegym.repository.employee;

import com.codegym.service.employee.impl.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegree extends JpaRepository<EducationDegree, Integer> {
}
