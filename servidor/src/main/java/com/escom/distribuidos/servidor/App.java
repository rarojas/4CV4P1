package com.escom.distribuidos.servidor;

import java.io.IOException;

import com.escom.distribuidos.core.ReflectionUtils;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, IOException {

		Class[] classes = ReflectionUtils.getClasses("com.escom.distribuidos.servidor");
		new Servidor();
	}

}
