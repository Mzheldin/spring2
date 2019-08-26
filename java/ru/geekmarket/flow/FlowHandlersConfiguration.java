package com.geekbrains.spring2.flow;

import com.geekbrains.spring2.flow.checkout.OrderHandler;
import com.geekbrains.spring2.flow.register.UserRegisterHandler;
import com.geekbrains.spring2.service.OrderService;
import com.geekbrains.spring2.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowHandlersConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler(UserService userService) {
        return new UserRegisterHandler(userService);
    }

    @Bean
    public OrderHandler orderHandler(OrderService orderService){
        return new OrderHandler(orderService);
    }
}
