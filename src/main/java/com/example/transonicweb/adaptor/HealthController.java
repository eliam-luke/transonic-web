package com.example.transonicweb.adaptor;

import org.springframework.ui.Model;

public interface HealthController {
    String health(String name, Model model);
    String error(String name, Model model);
}
