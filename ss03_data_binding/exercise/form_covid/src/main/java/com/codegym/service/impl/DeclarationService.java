package com.codegym.service.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    IDeclarationRepository iDeclarationRepository;

    @Override
    public List<Integer> dateOfBirthList() {
        return iDeclarationRepository.dateOfBirthList();
    }

    @Override
    public List<String> genderList() {
        return iDeclarationRepository.genderList();
    }

    @Override
    public List<String> natronalityList() {
        return iDeclarationRepository.natronalityList();
    }

    @Override
    public List<String> renderList() {
        return iDeclarationRepository.renderList();
    }

    @Override
    public List<Integer> startDayList() {
        return iDeclarationRepository.startDayList();
    }

    @Override
    public List<Integer> startMonthList() {
        return iDeclarationRepository.startMonthList();
    }

    @Override
    public List<Integer> startYearList() {
        return iDeclarationRepository.startYearList();
    }

    @Override
    public List<Integer> endDayList() {
        return iDeclarationRepository.endDayList();
    }

    @Override
    public List<Integer> endMonthList() {
        return iDeclarationRepository.endMonthList();
    }

    @Override
    public List<Integer> endYearList() {
        return iDeclarationRepository.endYearList();
    }

    @Override
    public List<Declaration> findAll() {
        return iDeclarationRepository.findAll();
    }

    @Override
    public Declaration findOne(String identity) {
        return iDeclarationRepository.findOne(identity);
    }

    @Override
    public void update(String identity, Declaration declaration) {
        iDeclarationRepository.update(identity, declaration);
    }

    @Override
    public void save(Declaration declaration) {
        iDeclarationRepository.save(declaration);
    }
}
