package com.escom.distribuidos.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Context {

	private static Context instance = null;
	private Map<String, Method> mappings;

	public Map<String, Method> getMappings() {
		return mappings;
	}

	public void setMappings(Map<String, Method> mappings) {
		this.mappings = mappings;
	}

	protected Context() {
		mappings = new HashMap<String, Method>();
	}

	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}
		return instance;
	}
}
