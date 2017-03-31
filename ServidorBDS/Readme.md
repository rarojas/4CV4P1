    
# Servidor Manejador BDS

## Requisitos

 - Java SDK 7
 - Maven 3.X
 - MSSQL Jdbc Driver

## Build
	mvn clean packageew

# Install JDBC MSSQL

Descagar jbdc driver de la pagina oficial de Microsoft

Extraer el contenido y obtener el driver sqljdbc4x.jar
Correr comando en terminal para instalar el driver en el repositorio local de maven

    mvn install:install-file -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion={versionjar} -Dpackaging=jar -DgeneratePom=true -Dfile={jarfile}
 
# Configuracíon 

>file app.properties
	
    #Puerto Socket Servidor
    net.puerto=6666
    #Constantes de conexion MySQL
    bd.username=root
    bd.password=forge
    bd.url=jdbc:mysql://localhost:3306
    #Constantes de conexion Postgresll
    postgress.bd.username=rora
    postgress.bd.password=
    postgress.bd.url=jdbc:postgresql://localhost:5432


# Run 

En el folder target se encuentra el archivo ServidorBDS-0.0.1-SNAPSHOT-jar-with-dependencies.jar con ese mismo se corre en consola

    java -jar ServidorBDS-0.0.1-SNAPSHOT-jar-with-dependencies.jar.jar

# Características

	Soporte Postgress
	Soporte MySQl
	Soporte MSSQL


## Agregar nueva BD

Implementar en clase para conexión 

```java 
public class BDConexionMIDB extends BDConexion {

	static final String JDBC_DRIVER = "MiDBDriver";
	protected BDConexionMIDB() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		LocalProperties localProperties = LocalProperties.getInstance();
		this.dbURL = localProperties.getProp("midb.bd.url");
		this.username = localProperties.getProp("midb.bd.username");
		this.password = localProperties.getProp("midb.bd.password");
	}

	private static final BDConexionMIDB instance = new BDConexionMIDB();

	public static BDConexion getInstance() {
		return instance;
	}

	@Override
	public BDEnum getTipo() {
		return BDEnum.MIDB;
	}
}
``` 


Implementar DAO con metodos soportados 

```java 
public class MIDBDao extends GenericHelperDB {

	public MIDBDao() throws SQLException {
		super(BDConexionMIDB.getInstance());
	}

	public List<String> showDatabases() {
		//Implementacion...
	}

	public List<String> showTables(String db) {
		//Implementacion...
	}

	public Map<String, String> showTableMeta(String db) {
		//Implementacion...
	}

	public Object showExecuteQuery(String query) {
		//Implementacion...
	}
} 
``` 
