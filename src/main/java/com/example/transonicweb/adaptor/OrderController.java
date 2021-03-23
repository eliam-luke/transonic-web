package com.example.transonicweb.adaptor;

import java.util.Date;
import java.util.Optional;

import com.example.transonicweb.domain.order.Order;
import com.example.transonicweb.domain.order.OrderRepository;
import com.example.transonicweb.domain.product.Product;
import com.example.transonicweb.domain.product.ProductRepository;
import com.example.transonicweb.interactor.order.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.apachecommons.CommonsLog;

@Controller
@CommonsLog
public class OrderController {
    @Autowired
	ProductRepository productRepository;
    @Autowired
	OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ModelAndView create(@ModelAttribute Order order,
        ModelAndView mav) throws Exception {
        log.debug("creat an order");
        mav.setViewName("order");
        order.setOrderDate(new Date());
        order.setReceiptFlg(false);
        orderService.create(order);
        return new ModelAndView("redirect:/order/" + order.getIsbn());
    }

    @GetMapping(value="/order/{isbn}")
	public ModelAndView detail(@PathVariable("isbn") String isbn, 
			ModelAndView mav) throws Exception {
        log.debug("show an order");
		mav.setViewName("order");
		Optional<Product> data = productRepository.findByIsbn(isbn);
		mav.addObject("data",data.get());
        Iterable<Order> list = orderService.load();
		mav.addObject("oooolist",list);
		return mav;
	}
}
