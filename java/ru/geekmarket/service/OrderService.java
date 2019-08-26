package com.geekbrains.spring2.service;

import com.geekbrains.spring2.flow.checkout.CartFinal;
import com.geekbrains.spring2.flow.checkout.Payment;
import com.geekbrains.spring2.persist.model.User;

import java.math.BigDecimal;

public interface OrderService {

    void saveOrder(User user, String recipientName, String recipientLastName,
                   String address, Payment payment, CartFinal cartFinal);
}
