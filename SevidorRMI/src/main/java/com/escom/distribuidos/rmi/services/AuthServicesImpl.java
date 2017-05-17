package com.escom.distribuidos.rmi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escom.distribuidos.rmi.dao.db.AlumnoDao;
import com.escom.distribuidos.rmi.dao.db.UsuarioDao;
import com.escom.distribuidos.rmi.dao.entity.Alumno;
import com.escom.distribuidos.rmi.dao.entity.Usuario;

@Service
@Transactional
public class AuthServicesImpl implements AuthServices {

	@Autowired
	UsuarioDao usuarioDao;

	@Autowired
	AlumnoDao alumnoDao;

	public boolean login(Usuario usuario) {
		return usuarioDao.login(usuario);
	}

	public Alumno registro(Alumno alumno) {
		alumnoDao.registro(alumno);
		return alumno;
	}

}
