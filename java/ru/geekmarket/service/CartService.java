package com.geekbrains.spring2.service;

import com.geekbrains.spring2.persist.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addAmount(Product product, int amount);

    void removeAmount(Product product, int amount);

    void removeProduct(Product product);

    Map<Product, Integer> getAllProducts();

    Integer getProductsCount();

    BigDecimal getSubTotal();
}
