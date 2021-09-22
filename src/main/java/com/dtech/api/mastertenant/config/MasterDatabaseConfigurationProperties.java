package com.dtech.api.mastertenant.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("multitenancy.master.datasource")
public class MasterDatabaseConfigurationProperties {

	private String driverClassName;
	private String jdbcUrl;
	private String password;
	private String username;

	public MasterDatabaseConfigurationProperties() {
		super();
	}

	public MasterDatabaseConfigurationProperties(String driverClassName, String jdbcUrl, String password,
			String username) {
		super();
		this.driverClassName = driverClassName;
		this.jdbcUrl = jdbcUrl;
		this.password = password;
		this.username = username;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}