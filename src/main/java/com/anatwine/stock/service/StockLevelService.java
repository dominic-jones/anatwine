package com.anatwine.stock.service;

import com.anatwine.stock.date.CurrentDateFactory;
import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.repository.StockLevelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class StockLevelService {

    @Inject
    private StockLevelRepository stockLevelRepository;

    @Inject
    private CurrentDateFactory currentDateFactory;

    @Inject
    private ClientStatusMapper clientStatusMapper;

    public List<StockLevel> getStockLevelsForBrand(Long brandId) {
        checkArgument(brandId != null, "brandId is null");

        return stockLevelRepository.getStockLevelsForBrand(brandId);
    }

    public StockLevel getStockLevel(Long brandId,
                                    Long stockLevelId) {
        checkArgument(brandId != null, "brandId is null");
        checkArgument(stockLevelId != null, "stockLevelId is null");

        return stockLevelRepository.getStockLevelForBrand(brandId, stockLevelId);
    }

    @Transactional
    public void addStockLevel(StockLevel stockLevel) {
        checkArgument(stockLevel.getBrandId() != null, "brandId is null");
        checkArgument(stockLevel.getChannels() != null, "channels are null");

        stockLevel.setUpdatedAt(currentDateFactory.createDate());

        stockLevel.setStatus(
                clientStatusMapper.getClientStatus(stockLevel.getBrandId())
                        .getValueAsString()
        );

        stockLevelRepository.addStockLevel(stockLevel);
    }

}
