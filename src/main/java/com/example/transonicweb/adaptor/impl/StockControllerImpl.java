package com.example.transonicweb.adaptor.impl;

import java.util.Optional;

import com.example.transonicweb.adaptor.StockController;
import com.example.transonicweb.domain.product.Product;
import com.example.transonicweb.domain.product.ProductRepository;
import com.example.transonicweb.domain.user.LoginUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@CommonsLog
public class StockControllerImpl implements StockController {
    @Autowired
    private final ProductRepository productRepository;

    @GetMapping("/stock")
    public ModelAndView stock(@ModelAttribute("formModel") Product product,
        ModelAndView mav) {
        // 認証情報を取得
        LoginUser loginUser = (LoginUser)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();;
        mav.addObject("username", loginUser.getUsername());
        mav.setViewName("stock");
        Iterable<Product> list = productRepository.findAll();
        mav.addObject("booklist",list);
        return mav;
    }

    @GetMapping(value = "/detail/{isbn}")
    public ModelAndView detail(@PathVariable("isbn") String isbn, ModelAndView mav) {
        mav.setViewName("detail");
        Optional<Product> data = productRepository.findByIsbn(isbn);
        mav.addObject("data", data.get());
        return mav;
    }
}
