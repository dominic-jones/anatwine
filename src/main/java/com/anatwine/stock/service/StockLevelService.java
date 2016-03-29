package com.anatwine.stock.service;

import com.anatwine.date.CurrentDateFactory;
import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.repository.StockLevelRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class StockLevelService {

    @Inject
    private StockLevelRepository stockLevelRepository;

    @Inject
    private CurrentDateFactory currentDateFactory;

    public List<StockLevel> getStockLevelsForBrand(Long brandId) {
        return stockLevelRepository.getStockLevelsForBrand(brandId);
    }

    public StockLevel getStockLevel(Long brandId,
                                    Long stockLevelId) {
        return stockLevelRepository.getStockLevelForBrand(brandId, stockLevelId);
    }

    public void addStockLevel(StockLevel stockLevel) {
        checkArgument(stockLevel.getBrandId() != null, "BrandId is null");
        checkArgument(stockLevel.getChannels() != null, "Channels are null");

        stockLevel.setUpdatedAt(currentDateFactory.createDate());

        /*
          if this is our premier client then set active as they auto activate everything
         */
        if (stockLevel.getBrandId() == 1L) {
            stockLevel.setStatus("active");
        } else {
            stockLevel.setStatus("pending");
        }

        stockLevelRepository.addStockLevel(stockLevel);
    }

}
