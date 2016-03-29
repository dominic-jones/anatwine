package com.anatwine.stock.service;

import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.repository.StockLevelRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class StockLevelService {

    @Inject
    private StockLevelRepository stockLevelRepository;

    public List<StockLevel> getStockLevelsForBrand(Long brandId) {
        return stockLevelRepository.getStockLevelsForBrand(brandId);
    }

    public StockLevel getStockLevel(Long brandId,
                                    Long stockLevelId) {
        return stockLevelRepository.getStockLevelForBrand(brandId, stockLevelId);
    }

    public boolean AddStockLevel(StockLevel stockLevel) {
        if (stockLevel.getBrandId() == null || stockLevel.getChannels() == null) {
            return false;
        }

        stockLevel.setUpdatedAt(new Date());

        /*
          if this is our premier client then set active as they auto activate everything
         */
        if (stockLevel.getBrandId() == 1L) {
            stockLevel.setStatus("active");
        } else {
            stockLevel.setStatus("pending");
        }

        stockLevelRepository.addStockLevel(stockLevel);

        return true;
    }

}
