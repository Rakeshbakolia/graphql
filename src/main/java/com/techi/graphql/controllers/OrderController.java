package com.techi.graphql.controllers;


import com.techi.graphql.entities.Order;
import com.techi.graphql.entities.User;
import com.techi.graphql.services.OrderService;
import com.techi.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    //create order
    @MutationMapping
    public Order createOrder(
            @Argument String orderDetail,
            @Argument String address,
            @Argument int price,
            @Argument int userId
    ){
        User user = userService.getSingleUser(userId);
        return orderService.createOrder(new Order(orderDetail, address, price, user));
    }

    // get all orders
    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    // get order
    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    //delete order
    @MutationMapping
    public Boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
}
