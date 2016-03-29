package com.anatwine.stock.repository;

import com.anatwine.stock.entity.StockLevel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StockLevelRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StockLevel> getStockLevelsForBrand(Long brandId) {
        return entityManager.createQuery("select s from StockLevel s where s.brandId = :brandId", StockLevel.class)
                .setParameter("brandId", brandId)
                .getResultList();
    }

    public StockLevel getStockLevelForBrand(Long brandId,
                                            Long stockLevelId) {
        return entityManager.createQuery("select s from StockLevel s where s.brandId = :brandId and s.Id = :id", StockLevel.class)
                .setParameter("brandId", brandId)
                .setParameter("id", stockLevelId)
                .getSingleResult();
    }

    public void addStockLevel(StockLevel stockLevel) {
        entityManager.persist(stockLevel);
    }
}
