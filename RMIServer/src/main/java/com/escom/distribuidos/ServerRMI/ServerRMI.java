package com.escom.distribuidos.ServerRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {

	public static void main(String[] args) {
		try {

			System.setProperty("java.rmi.server.hostname", "127.0.0.0");
			Registry registry = LocateRegistry.createRegistry(1099);
			Matematica matematica = new MatematicaImpl();
			registry.rebind("rmi://127.0.0.0/MyServer", matematica);
			System.out.println("Server ready");

		} catch (Exception e) {

			System.out.println("Server exception: " + e.toString());
			e.printStackTrace();

		}

	}
}
