package com.codegym.service.impl;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public List<BlogDto> showList() {
        return iBlogRepository.showList();
    }

    @Override
    public List<Blog> search(String name) {
        return iBlogRepository.findByBlogNameContaining(name);
    }


//    @Override
//    public void save(Blog blog) {
//        iBlogRepository.save(blog);
//    }
//
//
//    @Override
//    public Blog findById(int id) {
//        return iBlogRepository.findById(id);
//    }
//
//    @Override
//    public void update(Blog blog) {
//        iBlogRepository.save(blog);
//    }
//
//    @Override
//    public void remove(int id) {
//        iBlogRepository.deleteById(id);
//    }

//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return iBlogRepository.findAll(pageable);
//    }
//
//    @Override
//    public Page<Blog> findAllByBlogNameContaining(String title, Pageable pageable) {
//        return iBlogRepository.findAllByBlogNameContaining(title, pageable);
//    }


}
