package com.geekbrains.spring2.controller.obj;

import lombok.Data;

@Data
public class CartItem {

    private Long productId;

    private Integer amount;

    private String pageUrl;

    public CartItem(){}
}
