package com.dtech.api.tenant.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import com.dtech.api.tenant.model.TenantStorage;

public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	private static final String DEFAULT_TENANT_ID = "test1";

	@Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantStorage.getCurrentTenent();
        return tenant!=null ? tenant : DEFAULT_TENANT_ID;
    }

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}