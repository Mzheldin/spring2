package com.geekbrains.spring2.service;

import com.geekbrains.spring2.persist.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    Product findByProductName(String productName);

    boolean save(Product product);

    List<Product> findAll();

    boolean deleteProduct(Long id);
}
