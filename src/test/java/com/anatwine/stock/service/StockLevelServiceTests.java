package com.anatwine.stock.service;

import com.anatwine.date.CurrentDateFactory;
import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.repository.StockLevelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static com.anatwine.stock.service.StockStatus.ACTIVE_STATUS;
import static com.anatwine.stock.service.StockStatus.PENDING_STATUS;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockLevelServiceTests {

    @Mock
    StockLevelRepository stockLevelRepository;

    @Mock
    ClientStatusMapper clientStatusMapper;

    @Mock
    CurrentDateFactory currentDateFactory;

    @Captor
    ArgumentCaptor<StockLevel> stockLevelCaptor;

    @InjectMocks
    StockLevelService service;

    long brandId = 1L;
    long stockLevelId = 1L;
    long irrelevantId = 7L;

    @Before
    public void setUp() {
        when(clientStatusMapper.getClientStatus(anyLong()))
                .thenReturn(PENDING_STATUS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNoBrandIdWhenAddingStockLevelThenFail() {

        StockLevel stockLevel = new StockLevel();

        service.addStockLevel(stockLevel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNoChannelsWhenAddingStockLevelThenFail() {

        StockLevel stockLevel = new StockLevel();
        stockLevel.setBrandId(irrelevantId);
        stockLevel.setChannels(null);

        service.addStockLevel(stockLevel);
    }

    @Test
    public void givenValidInputsWhenAddingStockLevelThenSucceed() {

        StockLevel stockLevel = new StockLevel();
        stockLevel.setBrandId(irrelevantId);

        service.addStockLevel(stockLevel);

        verify(stockLevelRepository).addStockLevel(stockLevel);
    }

    @Test
    public void shouldSetDateOnAddingStockLevel() {

        Date expectedDate = new Date();
        when(currentDateFactory.createDate())
                .thenReturn(expectedDate);
        StockLevel stockLevel = new StockLevel();
        stockLevel.setBrandId(irrelevantId);

        service.addStockLevel(stockLevel);

        verify(stockLevelRepository).addStockLevel(stockLevelCaptor.capture());
        assertEquals(expectedDate, stockLevelCaptor.getValue().getUpdatedAt());
    }

    @Test
    public void shouldSetBrandStatusOnAddingStockLevel() {

        StockStatus expectedStatus = ACTIVE_STATUS;
        when(clientStatusMapper.getClientStatus(anyLong()))
                .thenReturn(expectedStatus);
        StockLevel stockLevel = new StockLevel();
        stockLevel.setBrandId(irrelevantId);

        service.addStockLevel(stockLevel);

        verify(stockLevelRepository).addStockLevel(stockLevelCaptor.capture());
        assertEquals(expectedStatus.getValueAsString(), stockLevelCaptor.getValue().getStatus());
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
