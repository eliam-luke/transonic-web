package com.example.transonicweb.interactor.order;

import com.example.transonicweb.domain.order.Order;

public interface OrderService {
    void create(Order order) throws Exception;
    Iterable<Order> load()  throws Exception;
}
