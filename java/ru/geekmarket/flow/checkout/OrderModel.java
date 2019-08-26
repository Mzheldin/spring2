package com.geekbrains.spring2.flow.checkout;

import lombok.Data;

@Data
public class OrderModel {

    private RecipientInfo recipientInfo;
    private CartFinal cartFinal;
}
