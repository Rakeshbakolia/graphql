package com.techi.graphql.services;

import com.techi.graphql.entities.Order;
import com.techi.graphql.helper.ExceptionHelper;
import com.techi.graphql.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // create a new order
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    // get all orders
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    // get single order
    public Order getOrder(int id) {
        return orderRepo.findById(id).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    // delete order
    public boolean deleteOrder(int id) {
        Order order = orderRepo.findById(id).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

}
