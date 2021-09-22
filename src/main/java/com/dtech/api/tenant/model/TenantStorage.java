package com.dtech.api.tenant.model;

public class TenantStorage {

	private static ThreadLocal<String> currentTenent = new ThreadLocal<>();

	public static void setCurrentTenent(String tenentId) {
		currentTenent.set(tenentId);
	}

	public static String getCurrentTenent() {
		return currentTenent.get();
	}

	public static void clear() {
		currentTenent.remove();
	}
}
