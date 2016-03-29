package com.anatwine.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockLevelServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(StockLevelServiceApplication.class);

    public static void main(String[] args) {
        logger.trace("Starting StockLevelServiceApplication");
        SpringApplication.run(StockLevelServiceApplication.class, args);
    }

}
