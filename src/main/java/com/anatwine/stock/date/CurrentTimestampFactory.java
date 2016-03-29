package com.anatwine.stock.date;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class CurrentTimestampFactory {

    public Timestamp createDate() {
        return new Timestamp(System.currentTimeMillis());
    }
}
