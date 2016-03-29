package com.anatwine.stock.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.anatwine.stock")
public class StockLevelServiceApplication {

    public static void main(String[] args) {
        System.out.println("Starting StockLevelServiceApplication");
        SpringApplication.run(StockLevelServiceApplication.class, args);
    }

}
