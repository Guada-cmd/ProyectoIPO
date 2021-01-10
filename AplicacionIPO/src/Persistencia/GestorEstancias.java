package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GestorEstancias {
	public static BrokerBD broker = new BrokerBD();
	
	public Vector<Vector<Object>> leerParcelas(String size){
		Vector<Vector<Object>> vector = new Vector<Vector<Object>>();
		
		try {
			Connection connection = BrokerBD.conectarBD();
			
			PreparedStatement query = connection.prepareStatement("select * from Estancias where Tamaño = '"+ size +"' and Reservado='no'");
			
			ResultSet res = query.executeQuery();		
			
			while(res.next()) {
				Vector<Object> aux = new Vector<Object>();
				
				for(int i = 1; i<=(res.getMetaData().getColumnCount());i++) aux.addElement(res.getObject(i));
				
				vector.add(aux);
			}
			
			query.close();
			connection.close();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return vector;
	}
	
	public Vector<Vector<Object>> leerCabañas(){
		Vector<Vector<Object>> vector = new Vector<Vector<Object>>();
		
		try {
			Connection connection = BrokerBD.conectarBD();
			
			PreparedStatement query = connection.prepareStatement("select * from Estancias where Tipo='cabaña' and Reservado='no'");
			
			ResultSet res = query.executeQuery();

			
			
			while(res.next()) {
				Vector<Object> aux = new Vector<Object>();
				
				for(int i = 1; i<=(res.getMetaData().getColumnCount());i++) aux.addElement(res.getObject(i));
				
				vector.add(aux);
			}
			query.close();
			connection.close();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return vector;
	}
	
	public int setReservado(int id) {
		int resultado = 0;
		
		try {
			Connection connection = BrokerBD.conectarBD();
			
			PreparedStatement query = connection.prepareStatement("update Estancias set Reservado='si' where IDEstancias = "+ id);

			resultado = query.executeUpdate();
			query.close();
			connection.close();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		return resultado;
	}
	
	public int setNoReservado(int id) {
		int resultado = 0;
		
		try {
			Connection connection = BrokerBD.conectarBD();
			
			PreparedStatement query = connection.prepareStatement("update Estancias set Reservado='no' where IDEstancias = "+ id);

			resultado = query.executeUpdate();
			query.close();
			connection.close();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		return resultado;
	}
}
