package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(int id);

//    List<Category> showList();

//    void save(Category category);
//
//     Category findByCategoryId(int id);
//
//    void update(Category category);
//
//    void remove(int id);
}
