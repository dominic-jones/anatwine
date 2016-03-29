package com.anatwine.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static com.anatwine.stock.service.StockStatus.ACTIVE_STATUS;
import static com.anatwine.stock.service.StockStatus.PENDING_STATUS;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BrandStatusStrategyTests {

    @InjectMocks
    ClientStatusMapper clientStatusMapper;

    long premierBrandId = 1L;
    long someOtherBrandId = 20L;

    @Test
    public void givenPremierClientWhenAddingStockThenSetStatusActive() {

        StockStatus result = clientStatusMapper.getClientStatus(premierBrandId);

        assertEquals(ACTIVE_STATUS, result);
    }

    @Test
    public void givenAnotherClientWhenAddingStockThenSetStatusActive() {

        StockStatus result = clientStatusMapper.getClientStatus(someOtherBrandId);

        assertEquals(PENDING_STATUS, result);
    }

}
