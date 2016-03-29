package com.anatwine.stock.config;

import com.anatwine.stock.logger.Loggable;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class StockLevelServiceConfiguration implements Loggable {

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    @Bean()
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(onlineDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.anatwine.stock.entity");
        entityManagerFactoryBean.setPersistenceUnitName("stock-pu");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.getJpaPropertyMap().put("hibernate.show_sql", "false");
        entityManagerFactoryBean.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        entityManagerFactoryBean.getJpaPropertyMap().put("hibernate.jdbc.batch_size", "50");
        entityManagerFactoryBean.getJpaPropertyMap().put("hbm2ddl.auto", "verify");
        return entityManagerFactoryBean;
    }

    @Bean(destroyMethod = "close")
    public DataSource onlineDataSource() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/stock";
        logger().info("Online JDBC URL::`{}`", jdbcUrl);

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl(jdbcUrl);
        basicDataSource.setUsername("stock");
        basicDataSource.setPassword("stockpassword");
        basicDataSource.setValidationQuery("select 1");
        basicDataSource.setTimeBetweenEvictionRunsMillis(1000);
        basicDataSource.setTestWhileIdle(true);
        basicDataSource.setDefaultAutoCommit(false);

        return basicDataSource;
    }
}
