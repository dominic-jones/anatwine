package com.anatwine.stock.repository;

import com.anatwine.stock.config.StockLevelServiceConfiguration;
import com.anatwine.stock.entity.StockLevel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StockLevelRepository {

    ApplicationContext context;

    EntityManager entityManager;

    public StockLevelRepository() {
        this.context = new AnnotationConfigApplicationContext(StockLevelServiceConfiguration.class);
        this.entityManager = context.getBean(EntityManagerFactory.class).createEntityManager();
    }

    public List<StockLevel> getStockLevelsForBrand(Long brandId) {
        return entityManager.createQuery("select s from StockLevel s where s.brandId = :brandId", StockLevel.class)
                .setParameter("brandId", brandId)
                .getResultList();
    }

    public StockLevel getStockLevelForBrand(Long brandId,
                                            Long stockLevelId) {
        return (StockLevel) entityManager.createQuery("select s from StockLevel s where s.brandId = :brandId and s.Id = :id")
                .setParameter("brandId", brandId)
                .setParameter("id", stockLevelId)
                .getSingleResult();
    }

    public void addStockLevel(StockLevel stockLevel) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(stockLevel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
