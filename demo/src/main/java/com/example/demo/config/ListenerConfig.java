package com.example.demo.config;

import com.example.demo.DemoApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
    @Bean
    public DemoApplicationListener getApplicationListener() {
        return new DemoApplicationListener();
    }
}
