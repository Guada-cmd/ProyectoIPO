package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class gestorUsuario {
	
	public static BrokerBD broker = new BrokerBD();
	public static PreparedStatement prepared_statement;
	public static ResultSet resultado_consulta;
	public static String sql;
	public static int comprobacion_resultado;
	
	
	public int insertarUsuario(String nombre, String apellidos, String nombre_usuario, String contrasena, String tipo_usuario, String telefono, String correo_electronico) {
		
		int resultado = 0;
		Connection connection = null;
		
		String sentencia_insertar_usuario = "insert into Usuario (Nombre, Apellidos, NombreUsuario, Contrasena, Tipo, Telefono, Correo) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement = connection.prepareStatement(sentencia_insertar_usuario);
			
			prepared_statement.setString(1, nombre);
			prepared_statement.setString(2, apellidos);
			prepared_statement.setString(3, nombre_usuario);
			prepared_statement.setString(4, contrasena);
			prepared_statement.setString(5, tipo_usuario);
			prepared_statement.setString(6, telefono);
			prepared_statement.setString(7, correo_electronico);
			//prepared_statement.setDate(8, (java.sql.Date) fecha_nacimiento);
			
			resultado = prepared_statement.executeUpdate();
			prepared_statement.close();
			
		}catch (Exception e) {
			
			System.out.print(e);
			
		}
		
		return resultado;
	}

}
