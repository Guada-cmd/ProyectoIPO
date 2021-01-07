package Persistencia;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;


public class gestorRutas {
	
	public static BrokerBD brokerRutas = new BrokerBD();
	public static PreparedStatement prepared_statement_rutas;
	public static ResultSet resultado_consulta_rutas;
	public static String sql_rutas;
	public static int comprobacion_resultado_rutas;
	public Image image_ruta;
	
	
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


	  






