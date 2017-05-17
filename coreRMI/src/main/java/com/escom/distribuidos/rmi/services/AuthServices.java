package com.escom.distribuidos.rmi.services;

import com.escom.distribuidos.rmi.dao.entity.Alumno;
import com.escom.distribuidos.rmi.dao.entity.Usuario;

public interface AuthServices {

	boolean login(Usuario usuario);

	Alumno registro(Alumno alumno);

}
