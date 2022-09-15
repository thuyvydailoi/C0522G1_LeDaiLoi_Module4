package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Lê Đại Lợi", 100000, "Đại Lợi"));
        products.put(2, new Product(2, "Cưu Ma Trí", 200000, "Mẹ Trí"));
        products.put(3, new Product(3, "Nguyễn Tất Thành", 300000, "Ba Thành"));
        products.put(4, new Product(4, "Huỳnh Luyên Thuyên", 500000, "Luyên Thuyên"));
        products.put(5, new Product(5, "Nguyễn Quyết", 400000, "Mẹ Quyết"));
        products.put(6, new Product(6, "Bảo Buồi", 6500000, "Bố Bảo"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> item : products.entrySet()) {
            if (item.getValue().getName().contains(name)) {
                productList.add(item.getValue());
            }
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
        public void update (Product product){
            products.put(product.getId(), product);
        }

        @Override
        public void remove ( int id){
            products.remove(id);
        }
    }
