package com.anatwine.stock.service;

import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.repository.StockLevelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockLevelServiceTests {

    @Mock
    StockLevelRepository stockLevelRepository;

    @InjectMocks
    StockLevelService service;

    long brandId = 1L;
    long stockLevelId = 1L;

    @Test
    public void testAddNewStockLevel() {

        assertNotNull(service.AddStockLevel(new StockLevel()));
    }

    @Test
    public void shouldReturnStockLevelForBrandId() {
        StockLevel expected = new StockLevel();
        when(stockLevelRepository.getStockLevelsForBrand(brandId))
                .thenReturn(newArrayList(expected));

        List<StockLevel> result = service.getStockLevelsForBrand(brandId);

        assertEquals(expected, result.iterator().next());
    }

    @Test
    public void testCurrentStockLevel() {
        when(stockLevelRepository.getStockLevelForBrand(brandId, stockLevelId))
                .thenReturn(new StockLevel());

        assertNotNull(service.getStockLevel(brandId, stockLevelId));
    }
}
