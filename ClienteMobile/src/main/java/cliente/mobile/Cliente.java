package cliente.mobile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {

	private static int PUERTO = 5000;
	private static String SERVER = "localhost";

	public static void main(String[] args) {
		boolean banderaSalida = false;
		Socket socket;
		try {

			JOptionPane.showMessageDialog(null, "Cliente funcionando");
			while (!banderaSalida) {

				socket = new Socket(SERVER, PUERTO);
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("$> Escriba comando");
				String peticion = console.readLine();
				printStream.println(peticion);
				String st = input.readLine();
				if (st != null) {
					JOptionPane.showMessageDialog(null, "".concat(st));
					System.out.println(" $> ".concat(st));
				}
				if (peticion.equals("salir")) {
					banderaSalida = true;
					JOptionPane.showMessageDialog(null, "Fin del programa");
					System.out.println("FIn del programa");
				}
				socket.close();
			}
		} catch (Exception e) {
			System.err.println("Cliente ".concat(e.getMessage()));
		}
	}
}
