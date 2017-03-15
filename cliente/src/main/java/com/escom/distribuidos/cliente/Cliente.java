package com.escom.distribuidos.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.escom.distribuidos.core.exceptions.GenericRuntimeException;
import com.escom.distribuidos.core.socket.Peticion;
import com.escom.distribuidos.core.socket.Result;
import com.escom.distribuidos.core.socket.StatusCodeEnum;

public class Cliente implements SocketInterface {

	private final int PUERTO = 6666;
	private String HOST = "localhost";
	private Socket socket;
	protected ObjectInputStream entrada;
	protected ObjectOutputStream salida;
	private static Cliente INSTANCE;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T sendRequest(Peticion peticion) {
		try {
			salida.writeObject(peticion);
			Result resultado = (Result) entrada.readObject();
			if (resultado.getCode().equals(StatusCodeEnum.FAIL)) {
				throw new GenericRuntimeException((String) resultado.getPayload());
			}
			T payload = (T) resultado.getPayload();
			return payload;

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() throws IOException {
		this.entrada.close();
		this.salida.close();
		this.socket.close();
	}

	private Cliente() throws UnknownHostException, IOException {
		socket = new Socket(this.HOST, this.PUERTO);
		salida = new ObjectOutputStream(this.socket.getOutputStream());
		entrada = new ObjectInputStream(this.socket.getInputStream());
	}

	public static Cliente getInstance() {
		if (INSTANCE == null) {
			try {
				INSTANCE = new Cliente();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return INSTANCE;
	}

}
