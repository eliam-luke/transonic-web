package com.example.transonicweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.transonicweb.domain.order.OrderRepository;
import com.example.transonicweb.domain.product.ProductRepository;
import com.example.transonicweb.interactor.order.OrderService;
import com.example.transonicweb.interactor.order.OrderServiceImpl;

@Configuration
public class BaseStartupConfig {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Bean
    public OrderService creatOrderServiceImpl() {
        return new OrderServiceImpl(orderRepository);
    }

}
