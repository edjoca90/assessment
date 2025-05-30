package com.johanCardenas.TPS.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanCardenas.TPS.models.Order;
import com.johanCardenas.TPS.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public ArrayList<Order> getAllOrders() {
        return (ArrayList<Order>)orderRepository.findAll();
    }
    @Transactional
    public Order createOrder(Order order) {        
        return orderRepository.save(order);
    }
    @Transactional
    public boolean deleteOrder(Integer orderId) {
        try {
            orderRepository.deleteById(orderId);
            return true;
        }catch(Exception err){
            return false;
        }
    } 
}
