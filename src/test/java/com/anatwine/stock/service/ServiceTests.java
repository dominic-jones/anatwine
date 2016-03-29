package com.anatwine.stock.service;

import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.repository.StockLevelRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class ServiceTests {

    @Mock StockLevelRepository repo = new StockLevelRepository();
    @Mock List<StockLevel> list = new ArrayList<>();
    @InjectMocks StockLevelService service = new StockLevelService();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        list.add(new StockLevel());
        when(repo.getStockLevelsForBrand(1l)).thenReturn(list);
    }

    @Test
    public void testStockService() throws Exception {
        try {
            assertNotNull(service.AddStockLevel(new StockLevel()));
            assertNotNull(service.getStockLevelsForBrand(1l));
            assertNotNull(service.getStockLevel(1l, 1l));
        } catch(Exception e) {
          System.out.println("Test failure");
        }
    }
}
