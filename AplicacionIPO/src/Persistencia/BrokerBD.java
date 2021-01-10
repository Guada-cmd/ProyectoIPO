package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BrokerBD {
	
	private static final String url = "jdbc:ucanaccess://IPOCamping.accdb"; // Pruebas remoto
	//private static final String url = "jdbc:ucanaccess://C:\\Users\\user8000\\git\\ProyectoIPO\\AplicacionIPO\\IPOCamping.accdb"; //Para el JAR
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


