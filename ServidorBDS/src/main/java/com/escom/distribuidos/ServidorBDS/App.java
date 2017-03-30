package com.escom.distribuidos.ServidorBDS;

import java.io.IOException;
import java.net.Socket;

import com.escom.distribuidos.core.Command;
import com.escom.distribuidos.core.Context;
import com.escom.distribuidos.core.Servidor;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.core.socket.ConexionDispatcher;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		System.out.println("Levantando Server");
		Context.getInstance().setMappings(ReflectionUtils.getClasses("com.escom.distribuidos.ServidorBDS"));

		new Servidor(new Command() {
			public void execute(Object param) {
				new ConexionDispatcher((Socket) param);
			}
		});
	}
}
