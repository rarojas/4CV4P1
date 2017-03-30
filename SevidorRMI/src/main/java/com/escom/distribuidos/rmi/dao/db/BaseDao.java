package com.escom.distribuidos.rmi.dao.db;

import java.util.List;

public interface BaseDao<T> {

	void insert(T entity);

	T get(int id);

	List<T> get();

}
