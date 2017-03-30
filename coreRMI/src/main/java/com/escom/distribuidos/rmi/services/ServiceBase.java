package com.escom.distribuidos.rmi.services;

import java.util.List;

public interface ServiceBase<T> {

	void insert(T entity);

	T get(int id);

	List<T> get();
}
