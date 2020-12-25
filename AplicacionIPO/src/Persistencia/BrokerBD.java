package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class BrokerBD {
	
	private static final String url = "jdbc:ucanaccess://IPOCamping.accdb";
	protected static BrokerBD instancia;
	
	
	/**
	 * 
	 * @return An instance of the Broker
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


