package com.codegym.service.employee.impl;

import com.codegym.repository.employee.IEducationDegreeRepository;
import com.codegym.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegree implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;
    @Override
    public List<com.codegym.model.employee.EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
