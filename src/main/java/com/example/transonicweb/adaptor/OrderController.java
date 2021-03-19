package com.example.transonicweb.adaptor;

import java.util.Date;
import java.util.Optional;

import com.example.transonicweb.domain.order.Order;
import com.example.transonicweb.domain.order.OrderRepository;
import com.example.transonicweb.domain.product.Product;
import com.example.transonicweb.domain.product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    @Autowired
	ProductRepository productRepository;
    @Autowired
	OrderRepository orderRepository;

    @PostMapping("/order")
    public ModelAndView create(@ModelAttribute Order order,
        ModelAndView mav) {
        mav.setViewName("order");
        order.setOrderDate(new Date());
        order.setReceiptFlg(false);
        orderRepository.save(order);
        return new ModelAndView("redirect:/order/" + order.getIsbn());
    }

    @GetMapping(value="/order/{isbn}")
	public ModelAndView detail(@PathVariable("isbn") String isbn, 
			ModelAndView mav) {
		mav.setViewName("order");
		Optional<Product> data = productRepository.findByIsbn(isbn);
		mav.addObject("data",data.get());
        Iterable<Order> list = orderRepository.findAll();
		mav.addObject("oooolist",list);
		return mav;
	}
}
