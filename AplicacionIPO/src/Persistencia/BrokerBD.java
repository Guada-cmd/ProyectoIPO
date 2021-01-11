package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BrokerBD {
	
	//Para hacer pruebas en eclipse
	
	//private static final String url = "jdbc:ucanaccess://IPOCamping.accdb"; 
	
	//Para hacer pruebas con el JAR inicializar con ruta absoluta
	
	//private static final String url = "jdbc:ucanaccess://C:\\Users\\user8000\\git\\ProyectoIPO\\AplicacionIPO\\IPOCamping.accdb"; 
	
	//Atributos para encontrar el archivo access en el sistema y poder conectarse
	
	public static String dbName = "IPOCamping.accdb";
	public static String bd = System.getProperty("user.dir") + "\\" + dbName;
	public static String url = "jdbc:ucanaccess://"+bd; 
	
	protected static BrokerBD instancia;
	
	
	/**
	 * 
	 * @return Una instancia del Broker
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static BrokerBD getBroker() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		if (instancia == null) {
			instancia = new BrokerBD();
		}
		return instancia;
	}
	
	/**
	 * 
	 * Descripcion: metodo para establecer la conexion
	 * 
	 * @return conexion
	 */
	public static Connection conectarBD() {
		
		 Connection connection = null;
		
		try {
			
			connection = DriverManager.getConnection(url);
			System.out.println("Conexion establecida");
			//connection.close();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
}


