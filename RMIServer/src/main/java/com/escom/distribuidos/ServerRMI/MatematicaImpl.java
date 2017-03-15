package com.escom.distribuidos.ServerRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatematicaImpl extends UnicastRemoteObject implements Matematica {

	protected MatematicaImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1742383704467783910L;

	public double sumarDatos(double[] a) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public double promedio(double[] a) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public String mostrarDatos(double[] a) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public double de(double[] a) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
