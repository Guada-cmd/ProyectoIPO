package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class gestorRutas {
	
	public static BrokerBD brokerRutas = new BrokerBD();
	public static PreparedStatement prepared_statement_rutas;
	public static ResultSet resultado_consulta_rutas;
	public static String sql_rutas;
	public static int comprobacion_resultado_rutas;
	
	
	public int insertarRuta(String nombre_ruta, String fecha_ruta, String hora_inicio, String hora_fin, String ofertada, 
			String punto_encuentro, int minimo, int maximo, String dificultad, String equipamiento, String descripcion) {
		
		int resultado = 0;
		Connection connection = null;
		
		String sentencia_insertar_ruta = 
				"insert into Rutas (Nombre, Fecha, HoraInicio, HoraFin, Ofertada, PuntoEncuentro, Minimo, Maximo, Dificultad, Equipamiento, Descripcion) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_rutas = connection.prepareStatement(sentencia_insertar_ruta);
			
			prepared_statement_rutas.setString(1, nombre_ruta);
			prepared_statement_rutas.setString(2, fecha_ruta);
			prepared_statement_rutas.setString(3, hora_inicio);
			prepared_statement_rutas.setString(4, hora_fin);
			prepared_statement_rutas.setString(5, ofertada);
			prepared_statement_rutas.setString(6, punto_encuentro);
			prepared_statement_rutas.setInt(7, minimo);
			prepared_statement_rutas.setInt(8, maximo);
			prepared_statement_rutas.setString(9, dificultad);
			prepared_statement_rutas.setString(10, equipamiento);
			prepared_statement_rutas.setString(11, descripcion);
			
			resultado = prepared_statement_rutas.executeUpdate();
			prepared_statement_rutas.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	public int buscarNombreRutaRegistrado(String nombre_ruta) {
		
		int ruta_registrado = -1;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();
			String sentencia_buscar_ruta = "select Nombre from Rutas WHERE Nombre = '"+nombre_ruta+"'";
			prepared_statement_rutas = connection.prepareStatement(sentencia_buscar_ruta);
			resultado_consulta_rutas = prepared_statement_rutas.executeQuery();
			
			if(resultado_consulta_rutas.next()) {
				
				ruta_registrado = 0;
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return ruta_registrado;
	}
	
	public String crearTableRuta(String parametro, int index) {
		
		String buscar_dato_ruta = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_dato_ruta = "select "+parametro+" from Rutas WHERE IDRutas = '"+index+"'";
			
			prepared_statement_rutas = connection.prepareStatement(sentencia_dato_ruta);
			resultado_consulta_rutas = prepared_statement_rutas .executeQuery();
			
			if(resultado_consulta_rutas.next()) {
				
				buscar_dato_ruta = resultado_consulta_rutas.getString(parametro);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return buscar_dato_ruta;
	}
	
	
	public int numeroFilasTablaRutas() {
		
		Connection connection = null;
		
		int numero_filas = 0;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_buscar_datos_rutas = "select IDRutas from Rutas";
			prepared_statement_rutas = connection.prepareStatement(sentencia_buscar_datos_rutas);
			resultado_consulta_rutas = prepared_statement_rutas.executeQuery();
			
			while(resultado_consulta_rutas.next()) {
				
				numero_filas = numero_filas + 1;
				
			}
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return numero_filas;
	}
	
	public String buscarRuta(String parametro, String nombre_ruta) {
		
		String buscar_dato_ruta = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_dato_ruta = "select "+parametro+" from Rutas WHERE Nombre = '"+nombre_ruta+"'";
			
			prepared_statement_rutas = connection.prepareStatement(sentencia_dato_ruta);
			resultado_consulta_rutas = prepared_statement_rutas.executeQuery();
			
			if(resultado_consulta_rutas.next()) {
				
				buscar_dato_ruta = resultado_consulta_rutas.getString(parametro);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return buscar_dato_ruta;
	}
	
}


	  






