package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    List<Product> findByName(String name);

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
