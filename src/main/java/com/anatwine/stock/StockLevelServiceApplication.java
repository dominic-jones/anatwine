package com.anatwine.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockLevelServiceApplication {

    public static void main(String[] args) {
        System.out.println("Starting StockLevelServiceApplication");
        SpringApplication.run(StockLevelServiceApplication.class, args);
    }

}
