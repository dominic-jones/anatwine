package com.anatwine.stock.service;

import org.springframework.stereotype.Component;

import static com.anatwine.stock.service.StockStatus.ACTIVE_STATUS;
import static com.anatwine.stock.service.StockStatus.PENDING_STATUS;

@Component
public class ClientStatusMapper {

    public StockStatus getClientStatus(long brandId) {
        if (brandId == 1L) {
            return ACTIVE_STATUS;
        }

        return PENDING_STATUS;
    }
}
