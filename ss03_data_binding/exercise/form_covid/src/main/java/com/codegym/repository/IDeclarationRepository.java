package com.codegym.repository;

import com.codegym.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {
    List<Integer> dateOfBirthList();
    List<String> genderList();
    List<String> natronalityList();
    List<String> renderList();
    List<Integer> startDayList();
    List<Integer> startMonthList();
    List<Integer> startYearList();
    List<Integer> endDayList();
    List<Integer> endMonthList();
    List<Integer> endYearList();
    List<Declaration> findAll();

    Declaration findOne(String identity);

    void update(String identity, Declaration declaration);

    void save(Declaration declaration);

}
