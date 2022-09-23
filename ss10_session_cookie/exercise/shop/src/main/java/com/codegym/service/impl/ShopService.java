package com.codegym.service.impl;

import com.codegym.model.Shop;
import com.codegym.repository.IShopRepository;
import com.codegym.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements IShopService {

    @Autowired
    private IShopRepository iShopRepository;

    @Override
    public List<Shop> findAll() {
        return iShopRepository.findAll();
    }

    @Override
    public Optional<Shop> findById(int id) {
        return iShopRepository.findById(id);
    }

    @Override
    public void save(Shop shop) {
        iShopRepository.save(shop);
    }
}
