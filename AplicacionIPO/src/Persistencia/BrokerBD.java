package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BrokerBD {
	
	public static void main (String [] args) {
		
		String url = "jdbc:ucanaccess://IPOCamping.accdb";
		
		try {
			
			Connection connection = DriverManager.getConnection(url);
			
			System.out.println("OK");
			
			connection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}

