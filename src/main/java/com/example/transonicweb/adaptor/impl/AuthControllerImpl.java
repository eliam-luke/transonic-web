package com.example.transonicweb.adaptor.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.transonicweb.adaptor.AuthController;

@Controller
public class AuthControllerImpl implements AuthController {
    /**
     * ログイン画面に遷移する
     * @return ログイン画面へのパス
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
//    @GetMapping("/logout")
//    public String logout(){
//        return "logout";
//    }
}
