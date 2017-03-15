package mobile.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class Server {

	private static int PUERTO = 5000;

	public static void main(String[] args) {
		try {

			ServerSocket serverSocket = new ServerSocket(PUERTO);
			JOptionPane.showMessageDialog(null, "Server funcionando...");
			JOptionPane.showMessageDialog(null, "Server En espera de clientes");
			System.out.println("En espera de clientes");
			Socket socket;
			while (true) {
				socket = serverSocket.accept();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				String peticion = bufferedReader.readLine();
				System.out.println("Peticion del cliente ".concat(peticion));
				String resultado = procesarSolicitud(peticion);
				System.out.println("Resultado de peticion".concat(resultado));
				printStream.flush();
				printStream.println(resultado);
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String procesarSolicitud(String peticion) {
		String resultado = "";
		String[] frases = { "libro 1", "libro 2" };
		List<String> listaFrases = new ArrayList<String>();
		Collections.addAll(listaFrases, frases);

		String[] libros = { "libro 1", "libro 2" };
		List<String> listaLibros = new ArrayList<String>();
		Collections.addAll(listaLibros, libros);
		if (peticion != null) {
			switch (peticion) {
			case "frase":
				Collections.shuffle(listaFrases);
				resultado = listaFrases.get(0);
				break;
			case "libro":
				Collections.shuffle(listaLibros);
				resultado = listaLibros.get(0);
				break;
			case "salir":
				resultado = "bye";
				break;
			default:
				resultado = "No se pudo resolver la peticion";
				break;
			}

		}

		return resultado;
	}
}
