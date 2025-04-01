package com.ecom.CustomerOrder.service;

import com.ecom.CustomerOrder.exception.ResourceNotFoundException;
import com.ecom.CustomerOrder.model.Order;
import com.ecom.CustomerOrder.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {




    @Autowired
    private OrderRepository repository;


    public List<Order> getAllOrders()
    {
        return repository.findAll();


    }
    public Order getOrderById(long id)
    {
        return repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Order not found"));

    }
    @Transactional
    public Order addOrder(Order order) {
        Order savedOrder = repository.save(order);
        System.out.println("Saved order with ID: " + savedOrder.getId());
        return savedOrder;
    }

    @Transactional
    public List<Order> addOrders(List<Order> orders) {
        List<Order> savedOrders = repository.saveAll(orders);
        savedOrders.forEach(order -> System.out.println("Saved order ID: " + order.getId()));
        return savedOrders;
    }
    public void deleteOrder(Long id)
    {
        repository.deleteById(id);
    }

}
