package com.escom.distribuidos.servidor;

import java.io.IOException;

import com.escom.distribuidos.core.reflection.ReflectionUtils;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ReflectionUtils.getClasses("com.escom.distribuidos.servidor");
		new Servidor();
	}

}
