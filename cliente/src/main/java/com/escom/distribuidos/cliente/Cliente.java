package com.escom.distribuidos.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.escom.distribuidos.core.Peticion;

public class Cliente {

	private final int PUERTO = 6666;
	private String host = "localhost";
	private Socket socket;
	protected ObjectInputStream entrada;
	protected ObjectOutputStream salida;

	public Cliente() {
		try {
			System.out.println("Send requets");
			this.socket = new Socket(this.host, this.PUERTO);
			this.salida = new ObjectOutputStream(this.socket.getOutputStream());
			this.entrada = new ObjectInputStream(this.socket.getInputStream());

			Peticion peticion = new Peticion();
			peticion.setMethod("POST");
			peticion.setRoute("alumno/obtenerAlumnos");
			salida.writeObject(peticion);
			Object resultado;
			try {
				resultado = this.entrada.readObject();
				if (resultado != null)
					System.out.println(resultado);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.entrada.close();
			this.salida.close();
			this.socket.close();
		} catch (UnknownHostException e) {
			System.out.println("Host desconocido");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
	}
}
