package com.escom.distribuidos.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Context {

	private static final Context instance = new Context();;

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
		return instance;
	}
}
