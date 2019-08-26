package com.geekbrains.spring2.service;

import com.geekbrains.spring2.flow.checkout.CartFinal;
import com.geekbrains.spring2.flow.checkout.Payment;
import com.geekbrains.spring2.persist.model.Order;
import com.geekbrains.spring2.persist.model.Product;
import com.geekbrains.spring2.persist.model.User;
import com.geekbrains.spring2.persist.repo.OrderReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderReposiory orderReposiory;

    @Autowired
    public void setOrderReposiory(OrderReposiory orderReposiory) {
        this.orderReposiory = orderReposiory;
    }

    public void saveOrder(User user, String recipientFirstName, String recipientLastName, String address,
                          Payment payment, CartFinal cartFinal){
        Order order = new Order(user, recipientFirstName, recipientLastName, address, formOrderList(cartFinal.getProducts(), cartFinal.getTotalSum()));
        orderReposiory.save(order);
    }

    private String formOrderList(Map<Product, Integer> cartFinal, BigDecimal totalSum){
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Product, Integer> o : cartFinal.entrySet()){
            stringBuilder
                    .append("product: ")
                    .append(o.getKey().getName())
                    .append(" count: ")
                    .append((o.getValue()))
                    .append("\n");
        }
        stringBuilder.append("Total price: ").append(totalSum.toPlainString());
        return stringBuilder.toString();
    }
}
