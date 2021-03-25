package com.example.transonicweb.service.order.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.transonicweb.domain.order.Order;
import com.example.transonicweb.domain.order.OrderRepository;
import com.example.transonicweb.service.order.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;

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
