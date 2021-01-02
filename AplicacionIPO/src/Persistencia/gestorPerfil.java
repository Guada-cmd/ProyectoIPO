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
	
	public int insertarPerfilUsuario(String nombre_usuario, String idiomas, String disponibilidad, String formacion) {
		
		int resultado = 0;
		Connection connection = null;
		
		String sentencia_insertar_perfil = "insert into Perfil (IDUsuario, Idiomas, Disponibilidad, Formacion) values(?, ?, ?, ?)";
		
		try {
			
			connection = BrokerBD.conectarBD();
			prepared_statement_perfil = connection.prepareStatement(sentencia_insertar_perfil);
			
			//id_usuario = buscarUsuarioRegistradoID(nombre_usuario);
			
			//System.out.println(id_usuario);
			
			//prepared_statement_perfil.setInt(0, id_usuario);
			prepared_statement_perfil.setString(1, nombre_usuario);
			prepared_statement_perfil.setString(2, idiomas);
			prepared_statement_perfil.setString(3, disponibilidad);
			prepared_statement_perfil.setString(4, formacion);
			
			resultado = prepared_statement_perfil.executeUpdate();
			prepared_statement_perfil.close();
			connection.close();
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		System.out.println(resultado);
		return resultado;
	}
}	
