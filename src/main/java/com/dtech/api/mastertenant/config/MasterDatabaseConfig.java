package com.dtech.api.mastertenant.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dtech.api.mastertenant.entity.MasterTenantEntity;
import com.dtech.api.mastertenant.repository.MasterTenantRepository;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.dtech.api.mastertenant.entity",
		"com.dtech.api.mastertenant.repository" }, 
		entityManagerFactoryRef = "masterEntityManagerFactory", 
		transactionManagerRef = "masterTransactionManager")
public class MasterDatabaseConfig {

	@Autowired
	private MasterDatabaseConfigurationProperties masterDbProperties;
	
	@Bean(name = "masterDataSource")
	public DataSource masterDataSource() {
		System.out.println("masterDataSource()**************");
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName(masterDbProperties.getDriverClassName());
		hikariDataSource.setJdbcUrl(masterDbProperties.getJdbcUrl());
		hikariDataSource.setUsername(masterDbProperties.getUsername());
		hikariDataSource.setPassword(masterDbProperties.getPassword());
		hikariDataSource.setConnectionTimeout(20000);
		hikariDataSource.setMaximumPoolSize(10);
		hikariDataSource.setIdleTimeout(300000);
		hikariDataSource.setMinimumIdle(5);
		return hikariDataSource;
	}
	
	@Primary
	@Bean(name = "masterEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean masterEntityManagerFactoryBean() {
		System.out.println("masterEntityManagerFactoryBean()**************");
		LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(masterDataSource());
		em.setPackagesToScan(new String[] {MasterTenantEntity.class.getPackage().getName(),MasterTenantRepository.class.getPackage().getName()});
		em.setPersistenceUnitName("master-persistence-unit");
		
		JpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		em.setJpaProperties(hibernateProperties());
		System.out.println("Setup masterEntityManagerFactory completed.");
		return em;
	}

	private Properties hibernateProperties() {
		System.out.println("hibernateProperties()******************");
		Properties properties=new Properties();
		properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
		properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
		properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "none");
		
		return properties;
	}
	
	@Primary
	@Bean(name = "masterTransactionManager")
	public JpaTransactionManager masterTransactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory emf) {
		System.out.println("masterTransactionManager()******************");
		JpaTransactionManager transactionManager=new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		System.out.println("exceptionTranslation()******************");
		PersistenceExceptionTranslationPostProcessor processor= new PersistenceExceptionTranslationPostProcessor();
		System.out.println("exceptionTranslation() processor******************: "+processor);
		return processor;
	}
	
	
}

