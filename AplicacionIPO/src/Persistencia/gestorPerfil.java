package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class gestorPerfil {
	
	public static BrokerBD brokerPerfil = new BrokerBD();
	public static PreparedStatement prepared_statement_perfil;
	public static ResultSet resultado_consulta_perfil;
	public static String sql_perfil;
	public static int comprobacion_resultado_perfil;
	
	public int updateFoto(String nombre_usuario, String foto_ruta) {
		
		int resultado = -1;
		Connection connection = null;
		
		String sentencia_update_foto = "update Perfil SET Foto = ? WHERE UserName = ?";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_perfil = connection.prepareStatement(sentencia_update_foto);
			
			prepared_statement_perfil.setString(1, foto_ruta);
			prepared_statement_perfil.setString(2, nombre_usuario);
			
			resultado = prepared_statement_perfil.executeUpdate();
			prepared_statement_perfil.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	/**
	 * 
	 * Descripcion: metodo que inserta por defecto esos datos a un usuario que se registra 
	 * 
	 * @param nombre_usuario
	 * @param idiomas
	 * @param disponibilidad
	 * @param formacion
	 * @return un entero para saber si la operacion ha salido correctamente
	 */
	public int insertarPerfilUsuario(String nombre_usuario, String idiomas, String disponibilidad, String formacion, String ruta_foto) {
		
		int resultado = 0;
		Connection connection = null;
		
		String sentencia_insertar_perfil = "insert into Perfil (UserName, Idiomas, Disponibilidad, Formacion, Foto) values(?, ?, ?, ?, ?)";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_perfil = connection.prepareStatement(sentencia_insertar_perfil);
					
			prepared_statement_perfil.setString(1, nombre_usuario);
			prepared_statement_perfil.setString(2, idiomas);
			prepared_statement_perfil.setString(3, disponibilidad);
			prepared_statement_perfil.setString(4, formacion);
			prepared_statement_perfil.setString(5, ruta_foto);
			
			resultado = prepared_statement_perfil.executeUpdate();
			prepared_statement_perfil.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		return resultado;
	}
	
	public int updatePerfil(String nombre_usuario, String idiomas, String disponibilidad, String formacion) {
		
		int resultado = -1;
		Connection connection = null;
		
		String sentencia_update_perfil = "update Perfil SET Idiomas = ?, Disponibilidad = ?, Formacion = ? WHERE UserName = ?";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_perfil = connection.prepareStatement(sentencia_update_perfil);
			
			prepared_statement_perfil.setString(1, idiomas);
			prepared_statement_perfil.setString(2, disponibilidad);
			prepared_statement_perfil.setString(3, formacion);
			prepared_statement_perfil.setString(4, nombre_usuario);
			
			resultado = prepared_statement_perfil.executeUpdate();
			prepared_statement_perfil.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	public String buscarDatoPerfilUsuario(String parametro, String nombre_usuario) {
		
		String buscar_dato_perfil = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_usuario_busaqueda = "select "+parametro+" from Perfil WHERE UserName = '"+nombre_usuario+"'";
			prepared_statement_perfil = connection.prepareStatement(sentencia_usuario_busaqueda);
			resultado_consulta_perfil = prepared_statement_perfil.executeQuery();
			
			if(resultado_consulta_perfil.next()) {
				
				buscar_dato_perfil = resultado_consulta_perfil.getString(parametro);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return buscar_dato_perfil;
	}
}	
