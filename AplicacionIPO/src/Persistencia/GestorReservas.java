package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GestorReservas {
	public static BrokerBD broker = new BrokerBD();

	public int crearReserva(int estancia, String nombre, String apellidos, int nPersonas, String info) {
		int resultado = 0;
		
		try {
			Connection connection = BrokerBD.conectarBD();
			
			PreparedStatement query = connection.prepareStatement("insert into Reservas (Estancia, Nombre, Apellidos, NumeroPersonas, Estado, InformacionAdicional) values(?, ?, ?, ?, ?, ?)");
			query.setInt(1, estancia);
			query.setString(2, nombre);
			query.setString(3, apellidos);
			query.setInt(4, nPersonas);
			query.setString(5, "en proceso");
			query.setString(6, info);
			
			resultado = query.executeUpdate();
			query.close();
			connection.close();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		return resultado;
	}
	public Vector<Vector<Object>> leerReservas(){
		Vector<Vector<Object>> vector = new Vector<Vector<Object>>();
		
		try {
			Connection connection = BrokerBD.conectarBD();
			
			PreparedStatement query = connection.prepareStatement("select * from Reservas where Estado = 'en proceso'");
			
			ResultSet res = query.executeQuery();
			query.close();
			connection.close();
			
			
			while(res.next()) {
				Vector<Object> aux = new Vector<Object>();
				
				for(int i = 1; i<=(res.getMetaData().getColumnCount());i++) aux.addElement(res.getObject(i));
				
				vector.add(aux);
			}
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return vector;
	}
	
	public int cambiarEstadoReserva(int id) {
		int resultado = 0;
		
		try {
			Connection connection = BrokerBD.conectarBD();
			
			PreparedStatement query = connection.prepareStatement("update Reservas set Estado='finalizada' where IDReserva = "+ id);

			resultado = query.executeUpdate();
			query.close();
			connection.close();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		return resultado;
	}
}
