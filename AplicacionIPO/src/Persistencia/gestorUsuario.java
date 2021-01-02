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
	

	public String buscarUsuarioRegistradoID(String nombre_usuario) {
		
		String usuario_nombre = null;
		Connection connection = null;
		
		try {
			
			connection = BrokerBD.conectarBD();
			String sentencia_buscar_usuario = "select NombreUsuario from Usuario WHERE NombreUsuario = '"+nombre_usuario+"'";
			prepared_statement = connection.prepareStatement(sentencia_buscar_usuario);
			resultado_consulta = prepared_statement.executeQuery();
			
			if(resultado_consulta.next()) {
				
				usuario_nombre = resultado_consulta.getString("NombreUsuario");
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return usuario_nombre;
	}
	
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

}
