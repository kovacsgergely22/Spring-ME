package org.me.bookstore.service;

import org.me.bookstore.model.Order;
import org.me.bookstore.persist.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order){
        orderRepository.save(order);
        return order;
    }

    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
