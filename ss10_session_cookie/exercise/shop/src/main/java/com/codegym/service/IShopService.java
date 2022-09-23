package com.codegym.service;

import com.codegym.model.Shop;

import java.util.List;
import java.util.Optional;

public interface IShopService {

    List<Shop> findAll();

    Optional<Shop> findById(int id);

    void save(Shop shop);

}
