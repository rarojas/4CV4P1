package com.escom.distribuidos.rmi.services;

import java.io.Serializable;
import java.util.List;

public interface ServiceBase<T> extends Serializable {

	void insert(T entity);

	T get(int id);

	List<T> get();
}
