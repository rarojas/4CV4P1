package com.escom.distribuidos.rmi.dao.db;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.escom.distribuidos.rmi.dao.entity.Alumno;

@Repository
@Transactional
public class AlumnoDaoImpl implements AlumnoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void registro(Alumno alumno) {
		sessionFactory.getCurrentSession().save(alumno);
	}

}
