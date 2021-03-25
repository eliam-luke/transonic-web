package com.example.transonicweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.transonicweb.domain.order.OrderRepository;
import com.example.transonicweb.domain.product.ProductRepository;
import com.example.transonicweb.service.order.OrderService;
import com.example.transonicweb.service.order.impl.OrderServiceImpl;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class BaseStartupConfig {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Bean
    public OrderService creatOrderServiceImpl() {
        return new OrderServiceImpl(orderRepository);
    }
    
    @Bean("auditorProvider")
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
