package com.anatwine.stock.service;

import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.repository.StockLevelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockLevelServiceTests {

    @Mock
    StockLevelRepository stockLevelRepository;

    @Mock
    List<StockLevel> stockLevels = new ArrayList<>();

    @InjectMocks
    StockLevelService service;

    long brandId = 1L;
    long stockLevelId = 1L;

    @Before
    public void setUp() throws Exception {
        stockLevels.add(new StockLevel());

        when(stockLevelRepository.getStockLevelsForBrand(brandId))
                .thenReturn(stockLevels);
    }

    @Test
    public void testAddNewStockLevel() {
        assertNotNull(service.AddStockLevel(new StockLevel()));
    }

    @Test
    public void testStockLevelForBrand() {
        assertNotNull(service.getStockLevelsForBrand(brandId));
    }

    @Test
    public void testCurrentStockLevel() {
        when(stockLevelRepository.getStockLevelForBrand(brandId, stockLevelId))
                .thenReturn(new StockLevel());

        assertNotNull(service.getStockLevel(brandId, stockLevelId));
    }
}
