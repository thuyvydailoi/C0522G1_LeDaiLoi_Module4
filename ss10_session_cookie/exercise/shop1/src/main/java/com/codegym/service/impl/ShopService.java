    package com.codegym.service.impl;

import com.codegym.model.Shop;
import com.codegym.repository.IShopRepository;
import com.codegym.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements IShopService {

    @Autowired
    private IShopRepository iShopRepository;
    @Override
    public List<Shop> findAll(Shop shop) {
        return iShopRepository.findAll();
    }

    @Override
    public Shop findById(int id) {
        return null;
    }
}
