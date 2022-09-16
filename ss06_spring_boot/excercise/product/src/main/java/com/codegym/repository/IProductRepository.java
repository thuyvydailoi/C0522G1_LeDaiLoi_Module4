package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);

    List<Product> findByName(String name);
}
