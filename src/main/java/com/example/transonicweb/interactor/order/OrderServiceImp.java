package com.example.transonicweb.interactor.order;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transonicweb.domain.order.Order;
import com.example.transonicweb.domain.order.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    
    @Override
    public void create(Order order) throws Exception {
        order.setOrderDate(new Date());
        order.setReceiptFlg(false);
        orderRepository.save(order);
    }

    @Override
    public Iterable<Order> load() throws Exception {
        Iterable<Order> orderList = orderRepository.findAll();
        return orderList;
    }
}
