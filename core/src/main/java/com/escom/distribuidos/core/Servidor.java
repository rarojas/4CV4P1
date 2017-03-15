package com.escom.distribuidos.core;

import java.net.ServerSocket;
import java.net.Socket;

import com.escom.distribuidos.core.Command;
import com.escom.distribuidos.core.LocalProperties;

public class Servidor extends Thread {

	public static final int PUERTO = 6666;

	private ServerSocket socketServidor;
	private static LocalProperties localProperties;
	private Command command;

	public Servidor(Command command) {
		try {
			localProperties = LocalProperties.getInstance();
			String port = localProperties.getProp("net.puerto");
			socketServidor = new ServerSocket(Integer.parseInt(port));
			this.command = command;
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
				command.execute(cliente);
				System.out.println("Nuevo cliente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
