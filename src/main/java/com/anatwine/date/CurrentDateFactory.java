package com.anatwine.date;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CurrentDateFactory {

    public Date createDate() {
        return new Date();
    }
}
