package com.escom.distribuidos.servidor;

import java.io.IOException;
import java.net.Socket;

import com.escom.distribuidos.core.Command;
import com.escom.distribuidos.core.Context;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.core.socket.ConexionDispatcher;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Context.getInstance().setMappings(ReflectionUtils.getClasses("com.escom.distribuidos.servidor"));
		new Servidor(new Command() {
			public void execute(Object param) {
				new ConexionDispatcher((Socket) param);
			}
		});
	}

}
