package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class gestorActividad {
	
	public static BrokerBD brokerActividad = new BrokerBD();
	public static PreparedStatement prepared_statement_actividad;
	public static ResultSet resultado_consulta_actividad;
	public static String sql_actividad;
	public static int comprobacion_resultado_actividad;
	
	
	public int insertarActividad(String nombre_actividad, String Horario, int min, int max, String destinada, 
			String precio_mes, String area, String descripcion, String material) {
		
		int resultado = 0;
		Connection connection = null;
		
		String sentencia_insertar_actividad = 
				"insert into Actividad (Nombre, Horario, MinimoActividad, MaximoActividad, Destinada, PrecioMes, Area, Descripcion, Material) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_actividad = connection.prepareStatement(sentencia_insertar_actividad);
			
			prepared_statement_actividad.setString(1, nombre_actividad);
			prepared_statement_actividad.setString(2, Horario);
			prepared_statement_actividad.setInt(3, min);
			prepared_statement_actividad.setInt(4, max);
			prepared_statement_actividad.setString(5, destinada);
			prepared_statement_actividad.setString(6, precio_mes);
			prepared_statement_actividad.setString(7, area);
			prepared_statement_actividad.setString(8, descripcion);
			prepared_statement_actividad.setString(9, material);
			
			resultado = prepared_statement_actividad.executeUpdate();
			prepared_statement_actividad.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	public int eliminarActividad(String nombre_actividad) {
		
		int resultado = -1;
		Connection connection = null;
		
		String sentencia_delete_actividad = "DELETE FROM Actividad WHERE Nombre = ?";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_actividad = connection.prepareStatement(sentencia_delete_actividad);
			
			prepared_statement_actividad.setString(1, nombre_actividad);
		
			
			resultado = prepared_statement_actividad.executeUpdate();
			prepared_statement_actividad.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	public int buscarNombreActividadRegistrado(String nombre_actividad) {
		
		int actividad_registrado = -1;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();
			String sentencia_buscar_actividad = "select Nombre from Actividad WHERE Nombre = '"+nombre_actividad+"'";
			prepared_statement_actividad = connection.prepareStatement(sentencia_buscar_actividad);
			resultado_consulta_actividad = prepared_statement_actividad.executeQuery();
			
			if(resultado_consulta_actividad.next()) {
				
				actividad_registrado = 0;
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return actividad_registrado;
	}
	
	public int updateActividad(String nombre_actividad, String precio_actividad, String area, String material) {
		
		int resultado = -1;
		Connection connection = null;
		
		String sentencia_update_actividad = "update Actividad SET PrecioMes = ?, Area = ?, Material = ? WHERE Nombre = ?";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_actividad = connection.prepareStatement(sentencia_update_actividad);
			
			prepared_statement_actividad.setString(1, precio_actividad);
			prepared_statement_actividad.setString(2, area);
			prepared_statement_actividad.setString(3, material);
			
			
			prepared_statement_actividad.setString(4, nombre_actividad);
			
			resultado = prepared_statement_actividad.executeUpdate();
			prepared_statement_actividad.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}

	public String crearTableActividad(String parametro, int index) {
		
		String buscar_dato_actividad = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_dato_actividad = "select "+parametro+" from Actividad WHERE IDActividad = '"+index+"'";
			
			prepared_statement_actividad = connection.prepareStatement(sentencia_dato_actividad );
			resultado_consulta_actividad = prepared_statement_actividad.executeQuery();
			
			if(resultado_consulta_actividad.next()) {
				
				buscar_dato_actividad = resultado_consulta_actividad.getString(parametro);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return buscar_dato_actividad;
	}
	
	public String buscarActividad(String parametro, String nombre_actividad) {
		
		String buscar_dato_actividad = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_dato_actividad = "select "+parametro+" from Actividad WHERE Nombre = '"+nombre_actividad+"'";
			
			prepared_statement_actividad = connection.prepareStatement(sentencia_dato_actividad );
			resultado_consulta_actividad = prepared_statement_actividad.executeQuery();
			
			if(resultado_consulta_actividad.next()) {
				
				buscar_dato_actividad = resultado_consulta_actividad.getString(parametro);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return buscar_dato_actividad;
	}
	
	
	public int numeroFilasTablaActividad() {
		
		Connection connection = null;
		
		int numero_filas = 0;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_buscar_datos_actividad = "select IDActividad from Actividad";
			prepared_statement_actividad = connection.prepareStatement(sentencia_buscar_datos_actividad);
			resultado_consulta_actividad = prepared_statement_actividad.executeQuery();
			
			while(resultado_consulta_actividad.next()) {
				
				numero_filas = numero_filas + 1;
				
			}
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return numero_filas;
	}
}