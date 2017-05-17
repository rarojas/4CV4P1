package com.escom.distribuidos.rmi.dao.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected Class<?> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	public T get(int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> get() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		return criteria.list();
	}

}
