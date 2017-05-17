package com.escom.distribuidos.rmi.services;

import java.util.List;

import com.escom.distribuidos.rmi.dao.db.BaseDao;

public abstract class ServiceBaseImpl<T> implements ServiceBase<T> {

	/**
	 *
	 */
	private static final long serialVersionUID = 2070067986783850676L;

	protected BaseDao<T> dao;

	public void insert(T Escuela) {
		dao.insert(Escuela);
	}

	public T get(int id) {
		return dao.get(id);

	}

	public List<T> get() {
		return dao.get();
	}
}
