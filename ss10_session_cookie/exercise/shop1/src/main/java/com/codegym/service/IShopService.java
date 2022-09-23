package com.codegym.service;

import com.codegym.model.Shop;

import java.util.List;

public interface IShopService {

    List<Shop> findAll(Shop shop);

    Shop findById(int id);
}
