package com.anatwine.stock.application;

import com.anatwine.stock.StockPackageMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = StockPackageMarker.class)
public class StockLevelServiceApplication {

    public static void main(String[] args) {
        System.out.println("Starting StockLevelServiceApplication");
        SpringApplication.run(StockLevelServiceApplication.class, args);
    }

}
