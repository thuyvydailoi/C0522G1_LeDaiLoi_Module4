package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;
import java.util.Locale;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

     Category findByCategoryId(int id);

    void update(Category category);

    void remove(int id);
}
