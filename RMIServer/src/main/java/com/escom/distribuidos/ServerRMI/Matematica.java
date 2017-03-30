package com.escom.distribuidos.ServerRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Matematica extends Remote {

	public double sumarDatos(double a[]) throws RemoteException;

	public double promedio(double a[]) throws RemoteException;

	public String mostrarDatos(double a[]) throws RemoteException;

	public double de(double a[]) throws RemoteException;

}
