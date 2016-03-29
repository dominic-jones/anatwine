package com.anatwine.stock.repository;

import com.anatwine.stock.entity.Brand;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BrandRepository {

    ApplicationContext context;

    EntityManager entityManager;

    public BrandRepository() {
        this.context = new AnnotationConfigWebApplicationContext();
        this.entityManager = context.getBean(EntityManagerFactory.class).createEntityManager();
    }

    public Brand getBrand(Long id){
        return (Brand)entityManager.createQuery("Select b from Brand where b.id = :id").setParameter("id", id).getSingleResult();
    }
}
