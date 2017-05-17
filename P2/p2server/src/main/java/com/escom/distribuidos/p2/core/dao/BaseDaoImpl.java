package com.escom.distribuidos.p2.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public List<T> get() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		return criteria.list();
	}

	public T get(Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	public void save(T entity) {
		sessionFactory.getCurrentSession().persist(entity);
	}

	public void update(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
}
