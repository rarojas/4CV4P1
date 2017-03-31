#Servidor Manejador BDS

##Requisitos

 - Java SDK 7
 - Maven 3.X
 - MSSQL Jdbc Driver

##Build
	mvn clean packageew

#Install JDBC MSSQL

Descagar jbdc driver de la pagina oficial de Microsoft

Extraer el contenido y obtener el driver sqljdbc4x.jar
Correr comando en terminal para instalar el driver en el repositorio local de maven

    mvn install:install-file -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion={versionjar} -Dpackaging=jar -DgeneratePom=true -Dfile={jarfile}
 
#Configuracíon 

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


#Run 

En el folder target se encuentra el archivo ServidorBDS-0.0.1-SNAPSHOT-jar-with-dependencies.jar con ese mismo se corre en consola

    java -jar ServidorBDS-0.0.1-SNAPSHOT-jar-with-dependencies.jar.jar
