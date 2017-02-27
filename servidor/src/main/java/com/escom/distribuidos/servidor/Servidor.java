package com.escom.distribuidos.servidor;

import java.net.ServerSocket;
import java.net.Socket;

import com.escom.distribuidos.core.ConexionDispatcher;

public class Servidor extends Thread {

	public static final int PUERTO = 6666;

	ServerSocket socketServidor;

	public Servidor() {
		try {
			this.socketServidor = new ServerSocket(PUERTO);
			System.out.println("Corriendo...");
		} catch (Exception e) {
			e.printStackTrace();
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
