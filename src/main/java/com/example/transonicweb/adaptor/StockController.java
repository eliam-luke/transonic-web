package com.example.transonicweb.adaptor;

import org.springframework.web.servlet.ModelAndView;

import com.example.transonicweb.domain.product.Product;

public interface StockController {
    ModelAndView stock(Product product, ModelAndView mav);
    ModelAndView detail(String isbn, ModelAndView mav);
}
