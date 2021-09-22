package com.dtech.api.tenant.config;

import javax.sql.DataSource;

import com.dtech.api.mastertenant.entity.MasterTenantEntity;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceUtil {

	public static DataSource createAndConfigureDataSource(MasterTenantEntity source) {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName(source.getDriverClassName());
		hikariDataSource.setJdbcUrl(source.getJdbcUrl());
		hikariDataSource.setUsername(source.getUsername());
		hikariDataSource.setPassword(source.getPassword());
		hikariDataSource.setConnectionTimeout(20000);
		hikariDataSource.setMaximumPoolSize(10);
		hikariDataSource.setIdleTimeout(300000);
		hikariDataSource.setMinimumIdle(5);
		return hikariDataSource;
	}

}