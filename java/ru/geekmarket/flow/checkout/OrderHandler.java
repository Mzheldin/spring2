package com.geekbrains.spring2.flow.checkout;

import com.geekbrains.spring2.persist.model.User;
import com.geekbrains.spring2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;

public class OrderHandler {

    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";

    private OrderService orderService;

    @Autowired
    public OrderHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderModel initOrderModel(){
        return new OrderModel();
    }

    public CartFinal initCartFinal(){
        CartFinal cartFinal = new CartFinal();
        cartFinal.init();
        return cartFinal;
    }

    public void addRecipientInfo(OrderModel orderModel, RecipientInfo recipientInfo){
        orderModel.setRecipientInfo(recipientInfo);
    }

    public void addCartFinal(OrderModel orderModel, CartFinal cartFinal){
        orderModel.setCartFinal(cartFinal);
    }

    public String validateRecipientInfo(RecipientInfo recipientInfo, MessageContext error) {
        return SUCCESS;
    }

    public String saveOrder(OrderModel orderModel, MessageContext messageContext){
        try {
            orderService.saveOrder(new User(),
                    orderModel.getRecipientInfo().getFirstName(),
                    orderModel.getRecipientInfo().getLastName(),
                    orderModel.getRecipientInfo().getAddress(),
                    orderModel.getRecipientInfo().getPayment(),
                    orderModel.getCartFinal());
        } catch (Exception ex) {
            messageContext.addMessage(new MessageBuilder()
                    .error()
                    .defaultText("Internal error. Can't complete form order.")
                    .build());
            return FAILURE;
        }
        return SUCCESS;
    }


}
