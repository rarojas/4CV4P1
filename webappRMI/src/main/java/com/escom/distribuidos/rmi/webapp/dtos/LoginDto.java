package com.escom.distribuidos.rmi.webapp.dtos;

import java.io.Serializable;

public class LoginDto implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 5347178178208354066L;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
