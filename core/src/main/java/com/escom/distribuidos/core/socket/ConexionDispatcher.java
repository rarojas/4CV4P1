package com.escom.distribuidos.core.socket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

import com.escom.distribuidos.core.Context;
import com.escom.distribuidos.core.exceptions.GenericRuntimeException;

public class ConexionDispatcher extends Thread {

	protected Socket cliente;
	protected ObjectInputStream entrada;
	protected ObjectOutputStream salida;

	public ConexionDispatcher(Socket cliente) {
		try {
			this.cliente = cliente;
			this.entrada = new ObjectInputStream(this.cliente.getInputStream());
			this.salida = new ObjectOutputStream(this.cliente.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
			try {
				this.cliente.close();
			} catch (IOException exception) {

			}
			return;
		}

		this.start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				Peticion peticion = (Peticion) this.entrada.readObject();
				String route = peticion.getMethod().concat(" ");
				route = route.concat(peticion.getRoute());
				Context context = Context.getInstance();
				System.out.println("Request -->".concat(route));
				Method method = context.getMappings().get(route);
				Class<?> parent = method.getDeclaringClass();
				Object controller;
				try {
					controller = parent.newInstance();
					Object[] args = new Object[] {};
					if (peticion.getPayload() != null) {
						args = new Object[] { peticion.getPayload() };
					}
					Object object = method.invoke(controller, args);
					Result result = new Result();
					result.setPayload(object);
					salida.writeObject(result);

				} catch (GenericRuntimeException e) {
					Result result = new Result();
					result.setCode(StatusCodeEnum.FAIL);
					result.setPayload(e.getMessage());
					salida.writeObject(result);
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
					Result result = new Result();
					if (e.getCause().getClass().equals(GenericRuntimeException.class)) {
						result.setPayload(e.getCause().getMessage());
					} else {
						result.setPayload("Error desconocido");
					}
					result.setCode(StatusCodeEnum.FAIL);
					salida.writeObject(result);
				}
			}
		} catch (EOFException e) {

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!cliente.isClosed())
					this.cliente.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
