package com.dtech.api.mastertenant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_tenant_tab")
public class MasterTenantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "database_name")
	private String tenantId;
	@Column(name = "driver_class_name")
	private String driverClassName;
	@Column(name = "jdbc_url")
	private String jdbcUrl;
	private String username;
	private String password;
	private String status;

	public MasterTenantEntity() {
		super();
	}

	public MasterTenantEntity(Integer id, String tenantId, String driverClassName, String jdbcUrl, String username,
			String password, String status) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.driverClassName = driverClassName;
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}