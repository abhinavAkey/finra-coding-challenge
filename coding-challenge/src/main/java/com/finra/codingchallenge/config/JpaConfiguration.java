package com.finra.codingchallenge.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.finra.codingchallenge.utils.Constants;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Configuration
@EnableTransactionManagement
public class JpaConfiguration {

	@Bean
	public DataSource jpaDataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

		return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Bean
	public Properties jpaProperties() {
		Properties properties = new Properties();

		properties.setProperty("hibernate.hbm2ddl.auto", "create");

		return properties;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource jpaDataSource,
			Properties jpaProperties) {

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		entityManagerFactory.setPackagesToScan(Constants.REPOSITORY_PACKAGE);

		entityManagerFactory.setDataSource(jpaDataSource);

		entityManagerFactory.setJpaProperties(jpaProperties());

		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
