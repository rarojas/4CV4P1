    
# Servidor SOCKET APP MOBILE
## Requisitos

 - Java SDK 7
 - Maven 3.X

## Build
	mvn clean package

# Run 

En el folder target se encuentra el archivo mobile.server-0.0.1-SNAPSHOT.jar con ese mismo se corre en consola

    java -jar mobile.server-0.0.1-SNAPSHOT.jar


## Serve Implementación 

```java 
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
``` 
