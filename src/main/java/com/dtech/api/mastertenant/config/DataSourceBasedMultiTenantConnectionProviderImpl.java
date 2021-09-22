package com.dtech.api.mastertenant.config;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dtech.api.mastertenant.entity.MasterTenantEntity;
import com.dtech.api.mastertenant.repository.MasterTenantRepository;
import com.dtech.api.tenant.config.DataSourceUtil;
import com.dtech.api.tenant.model.TenantStorage;

@Configuration
public class DataSourceBasedMultiTenantConnectionProviderImpl
		extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2414477223698663738L;

	@Autowired
	private MasterTenantRepository masterTenantRepository;

	private Map<String, DataSource> dataSourcesMtApp = new TreeMap<>();

	@Override
	protected DataSource selectAnyDataSource() {
		if (dataSourcesMtApp.isEmpty()) {
			List<MasterTenantEntity> masterTenants = masterTenantRepository.findAll();
			for (MasterTenantEntity masterTenant : masterTenants) {
				dataSourcesMtApp.put(masterTenant.getTenantId(),
						DataSourceUtil.createAndConfigureDataSource(masterTenant));
			}
		}
		return this.dataSourcesMtApp.values().iterator().next();
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier){

		tenantIdentifier = initializeTenantIfLost(tenantIdentifier);
		
		if (!this.dataSourcesMtApp.containsKey(tenantIdentifier)) {
            List<MasterTenantEntity> masterTenants = masterTenantRepository.findAll();
            for (MasterTenantEntity masterTenant : masterTenants) {
				if (this.dataSourcesMtApp.containsKey(masterTenant.getTenantId())) {
					continue;
				}
                dataSourcesMtApp.put(masterTenant.getTenantId(),
                        DataSourceUtil.createAndConfigureDataSource(masterTenant));
            }
        }
            //check again if tenant exist in map after rescan master_db, if not, throw UsernameNotFoundException
       if (!this.dataSourcesMtApp.containsKey(tenantIdentifier)) {
           System.out.println("Tenant not found after rescan,  tenant=%s"+tenantIdentifier);
        }
        return this.dataSourcesMtApp.get(tenantIdentifier);
	}

	private String initializeTenantIfLost(String tenantIdentifier) {
		if (tenantIdentifier != TenantStorage.getCurrentTenent()) {
			tenantIdentifier = TenantStorage.getCurrentTenent();
		}
		return tenantIdentifier;
	}

}