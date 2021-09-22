package com.dtech.api.mastertenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtech.api.mastertenant.entity.MasterTenantEntity;

@Repository
public interface MasterTenantRepository extends JpaRepository<MasterTenantEntity, Integer>{

	public MasterTenantEntity findByTenantId(String tenantId);
}