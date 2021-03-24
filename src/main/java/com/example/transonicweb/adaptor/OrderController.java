package com.example.transonicweb.adaptor;

import org.springframework.web.servlet.ModelAndView;

import com.example.transonicweb.domain.order.Order;

public interface OrderController {
    ModelAndView create(Order order, ModelAndView mav) throws Exception;
    ModelAndView detail(String isbn, ModelAndView mav) throws Exception;
}
