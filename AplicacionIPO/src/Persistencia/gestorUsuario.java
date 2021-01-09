package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class gestorUsuario {
	
	public static BrokerBD broker = new BrokerBD();
	public static PreparedStatement prepared_statement;
	public static ResultSet resultado_consulta;
	public static String sql;
	public static int comprobacion_resultado;
	
	/**
	 * 
	 * Descripcion: mediante los parametros de entrada que el usuario introduce en la parte de presentacion de la aplicacion, se insertan esos parametros en la base de datos
	 * 
	 * @param nombre_usuario
	 * @param nombre
	 * @param apellidos
	 * @param contrasena
	 * @param tipo_usuario
	 * @param telefono
	 * @param correo_electronico
	 * @param fecha_nacimiento
	 * @return un entero para saber si la operacion realizada ha salido correctamente
	 */
	public int insertarUsuario(String nombre_usuario, String nombre, String apellidos, String contrasena, String tipo_usuario, String telefono, String correo_electronico, String fecha_nacimiento) {
		
		int resultado = 0;
		Connection connection = null;
		
		String sentencia_insertar_usuario = "insert into Usuario (NombreUsuario, Nombre, Apellidos, Contrasena, Tipo, Telefono, Correo, FechaNacimiento) values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement = connection.prepareStatement(sentencia_insertar_usuario);
			
			prepared_statement.setString(1, nombre_usuario);
			prepared_statement.setString(2, nombre);
			prepared_statement.setString(3, apellidos);
			prepared_statement.setString(4, contrasena);
			prepared_statement.setString(5, tipo_usuario);
			prepared_statement.setString(6, telefono);
			prepared_statement.setString(7, correo_electronico);
			prepared_statement.setString(8, fecha_nacimiento);
			
			resultado = prepared_statement.executeUpdate();
			prepared_statement.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}

	public int eliminarUsuario(String nombre_usuario) {
		
		int resultado = -1;
		Connection connection = null;
		
		String sentencia_delete_usuario = "DELETE FROM Usuario WHERE NombreUsuario = ?";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement = connection.prepareStatement(sentencia_delete_usuario);
			
			prepared_statement.setString(1, nombre_usuario);
		
			
			resultado = prepared_statement.executeUpdate();
			prepared_statement.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	public int updateUsuarioPass(String nombre_usuario, String nueva_pass) {
		
		int resultado = -1;
		Connection connection = null;
		
		String sentencia_update_pass = "update Usuario SET Contrasena = ? WHERE NombreUsuario = ?";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement = connection.prepareStatement(sentencia_update_pass);
			
			prepared_statement.setString(1, nueva_pass);
			prepared_statement.setString(2, nombre_usuario);
			
			resultado = prepared_statement.executeUpdate();
			prepared_statement.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	public int updateUsuarioParametro(String nombre_usuario, String nombre_parametro, String nuevo_parametro) {
		
		int resultado = -1;
		Connection connection = null;
		
		String sentencia_update_parametro = "update Usuario SET "+nombre_parametro+" = ? WHERE NombreUsuario = ?";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement = connection.prepareStatement(sentencia_update_parametro);
			
			prepared_statement.setString(1, nuevo_parametro);
			prepared_statement.setString(2, nombre_usuario);
			
			resultado = prepared_statement.executeUpdate();
			prepared_statement.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	/**
	 * 
	 * Descripcion: un usuario no se puede registrar en el sistema con un nombre que ya esta en la base de datos, este metodo permite hacer dicha comprobacion
	 * 
	 * @param nombre_usuario
	 * @return un entero para saber si ya hay un usuario con ese nombre en el sistema
	 */
	public int buscarUsuarioRegistrado(String nombre_usuario) {
		
		int usuario_registrado = -1;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();
			String sentencia_buscar_usuario = "select NombreUsuario from Usuario WHERE NombreUsuario = '"+nombre_usuario+"'";
			prepared_statement = connection.prepareStatement(sentencia_buscar_usuario);
			resultado_consulta = prepared_statement.executeQuery();
			
			if(resultado_consulta.next()) {
				
				usuario_registrado = 0;
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return usuario_registrado;
	}
	
	/**
	 * 
	 * Descripcion: dado un nombre de usuario se obtiene su contrasena 
	 * 
	 * @param nombre_usuario
	 * @return la contrasena del usuario registrado en el sistema
	 */
	public String iniciarSesionSistema(String nombre_usuario) {
		
		String contrasena = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_usuario_registrado = "select Contrasena from Usuario WHERE NombreUsuario = '"+nombre_usuario+"'";
			prepared_statement = connection.prepareStatement(sentencia_usuario_registrado);
			resultado_consulta = prepared_statement.executeQuery();
			
			if(resultado_consulta.next()) {
				
				contrasena = resultado_consulta.getString("Contrasena");
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return contrasena;
	}
	public String buscarDatoUsuario(String parametro, String nombre_usuario) {
		
		String buscar_dato = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();  
			String sentencia_usuario_busaqueda = "select "+parametro+" from Usuario WHERE NombreUsuario = '"+nombre_usuario+"'";
			prepared_statement = connection.prepareStatement(sentencia_usuario_busaqueda);
			resultado_consulta = prepared_statement.executeQuery();
			
			if(resultado_consulta.next()) {
				
				buscar_dato = resultado_consulta.getString(parametro);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return buscar_dato;
	}
}
