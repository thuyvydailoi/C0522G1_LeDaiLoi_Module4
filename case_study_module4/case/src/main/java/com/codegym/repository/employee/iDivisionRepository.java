package com.codegym.repository.employee;

import com.codegym.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iDivisionRepository extends JpaRepository<Division, Integer> {
}
