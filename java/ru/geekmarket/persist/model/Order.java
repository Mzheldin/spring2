package com.geekbrains.spring2.persist.model;

import com.geekbrains.spring2.flow.checkout.CartFinal;
import com.geekbrains.spring2.flow.checkout.Payment;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "first_name")
    private String recipientFirstName;

    @Column(name = "last_name")
    private String recipientLastName;

    @Column(name = "address")
    private String address;

    @Column(name = "payment")
    private String payment;

    @Column(name = "product_list")
    private String productList;

    public Order() {
    }

    public Order(User user, String recipientFirstName, String recipientLastName, String address, String productList) {
        this.user = user;
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.address = address;
        this.productList = productList;
    }
}
