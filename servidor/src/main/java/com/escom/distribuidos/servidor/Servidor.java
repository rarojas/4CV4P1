package com.escom.distribuidos.servidor;

import java.net.ServerSocket;
import java.net.Socket;

import com.escom.distribuidos.core.LocalProperties;
import com.escom.distribuidos.core.socket.ConexionDispatcher;

public class Servidor extends Thread {

	public static final int PUERTO = 6666;

	private ServerSocket socketServidor;
	private static LocalProperties localProperties;


	public Servidor() {
		try {
			localProperties = LocalProperties.getInstance();
			String port = localProperties.getProp("net.puerto");
			socketServidor = new ServerSocket(Integer.parseInt(port));
			System.out.println("Corriendo...");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		this.start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				Socket cliente = this.socketServidor.accept();
				new ConexionDispatcher(cliente);
				System.out.println("Nuevo cliente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
