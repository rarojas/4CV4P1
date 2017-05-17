package com.escom.distribuidos.rmi.dao.db;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.escom.distribuidos.rmi.dao.entity.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean login(Usuario usuario) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select count(*) from Usuario login where login.usuario=:usuario and login.password=:password");
		query.setString("usuario", usuario.getUsuario());
		query.setString("password", usuario.getPassword());
		Long count = (Long) query.uniqueResult();
		return count == 1;
	}

}
