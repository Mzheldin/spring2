package com.geekbrains.spring2.flow.checkout;

import com.geekbrains.spring2.persist.model.Product;
import com.geekbrains.spring2.service.CartService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

@Data
public class CartFinal implements Serializable {

    private CartService cartService;
    private Map<Product, Integer> products;
    private BigDecimal totalSum;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public void init(){
        products = cartService.getAllProducts();
        totalSum = cartService.getSubTotal();
    }
}
