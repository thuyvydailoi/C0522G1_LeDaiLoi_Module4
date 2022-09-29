package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;


    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return iCategoryRepository.findById(id);
    }



//    @Override
//    public List<Category> showList() {
//        return iCategoryRepository.showList();
//    }

//    @Override
//    public void save(Category category) {
//        iCategoryRepository.save(category);
//    }
//
//    @Override
//    public Category findByCategoryId(int id) {
//        return iCategoryRepository.findByCategoryId(id);
//    }
//
//    @Override
//    public void update(Category category) {
//        iCategoryRepository.save(category);
//    }
//
//    @Override
//    public void remove(int id) {
//        iCategoryRepository.deleteById(id);
//    }
}
