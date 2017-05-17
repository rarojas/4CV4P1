package com.escom.distruidos.ClienteRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.escom.distribuidos.ServerRMI.Matematica;

public class ClientRMI {

	private static Matematica matematica;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		matematica = (Matematica) Naming.lookup("rmi://127.0.0.0/MyServer");
		String txt = JOptionPane.showInputDialog("Datos ?");
		String[] data = txt.split(Pattern.quote(","));
		double[] a = new double[data.length];

		int index = 0;
		for (String string : data) {
			a[index] = Double.parseDouble(string);
		}

		Double response = matematica.promedio(a);
		JOptionPane.showMessageDialog(null, response);

	}

}