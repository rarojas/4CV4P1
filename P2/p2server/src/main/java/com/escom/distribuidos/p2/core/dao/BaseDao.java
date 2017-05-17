package com.escom.distribuidos.p2.core.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	void save(T entity);

	void update(T entity);

	T get(Serializable id);

	List<T> get();

	void delete(T entity);

}
