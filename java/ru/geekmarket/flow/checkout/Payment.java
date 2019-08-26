package com.geekbrains.spring2.flow.checkout;

public enum Payment {

    CASH("Cash"),
    CREDIT_CARD("Credit Card");

    private String field;

    Payment(String field) {
        this.field = field;
    }

    public String getValue(){
        return field;
    }
}
