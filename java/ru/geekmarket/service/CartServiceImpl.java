package com.geekbrains.spring2.service;

import com.geekbrains.spring2.persist.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    private Map<Product, Integer> cartProducts;

    public CartServiceImpl() {
        cartProducts = new ConcurrentHashMap<>();
    }

    @Override
    public void addAmount(Product product, int amount) {
        cartProducts.put(product, cartProducts.getOrDefault(product, 0) + amount);
    }

    @Override
    public void removeAmount(Product product, int amount) {
        int currentAmount = cartProducts.getOrDefault(product, 0);
        if (currentAmount - amount > 0) {
            cartProducts.put(product, currentAmount - amount);
        } else {
            cartProducts.remove(product);
        }
    }

    @Override
    public void removeProduct(Product product) {
        cartProducts.remove(product);
    }

    @Override
    public Map<Product, Integer> getAllProducts() {
        return Collections.unmodifiableMap(cartProducts);
    }

    @Override
    public Integer getProductsCount() {
        return cartProducts.size();
    }

    @Override
    public BigDecimal getSubTotal() {
        return cartProducts.entrySet().stream()
                .map(e -> e.getKey().getPrice().multiply(new BigDecimal(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
