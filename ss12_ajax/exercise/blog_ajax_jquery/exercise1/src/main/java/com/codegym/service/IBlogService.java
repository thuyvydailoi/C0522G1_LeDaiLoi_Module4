package com.codegym.service;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    List<BlogDto> showList();

    List<Blog> search(String name);

    //    void save(Blog blog);
//
//
//    void update(Blog blog);
//
//    void remove(int id);


}
