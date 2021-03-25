package com.example.transonicweb.adaptor.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.transonicweb.adaptor.HealthController;

@Controller
public class HealthControllerImpl implements HealthController {
    @GetMapping("/health")
    public String health(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "health";
    }
    
    @GetMapping("/error")
    public String error(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "error";
    }
}
