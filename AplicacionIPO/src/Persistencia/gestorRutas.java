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
	
	/* Guarda la imagen JPG en el campo OLE de Access */
	/**
	 * 
	 * Descripcion: guarda la imagen con formato JPG en el campo de la tabla correspondiente (campo formato OLE) de Access
	 * 
	 * @param foto
	 * @return
	 */
	public boolean guardarFotoRuta(String foto) {
		
		boolean ok = false;
	    FileInputStream file_stream = null;
	    Connection connection = null;
	    
	    try {
	        
	    	connection = BrokerBD.conectarBD();
	    	File file = new File(foto);
	        file_stream = new FileInputStream(file);
	        String sentencia_guardar_imagen_rutas = "INSERT INTO Rutas (Foto) values (?)";
	        
	        prepared_statement_rutas = connection.prepareStatement(sentencia_guardar_imagen_rutas);
	        prepared_statement_rutas.setBinaryStream(1, file_stream,(int) file.length());
	        prepared_statement_rutas.execute();
	        prepared_statement_rutas.close();
	        
	        ok=true;
	        
	     } catch (FileNotFoundException ex) {
	    	 System.out.println(ex);
	     } catch (SQLException e) {
	         System.out.println(e);
	         
	    } finally {
	    	try {
	    		file_stream.close();
	    	} catch (IOException ex) {
	    		System.out.println(ex);
	        }
	    }
	    return ok;
	}
	
	/**
	 * 
	 * Descripcion: Metodo  que dado un parametro "id" realiza una consulta y devuelve como resultado una imagen
	 * 
	 * @param id
	 * @return
	 */
	 public Image buscarFotoRuta(int index ){
		 
		 Connection connection = null;
		 int i = 0;
			
	      try{
	    	  
	    	 connection = BrokerBD.conectarBD(); 
	    	 String sentencia_buscar_foto_ruta = "select Foto from Rutas WHERE IDRutas = '"+index+"'";
	    	 prepared_statement_rutas = connection.prepareStatement(sentencia_buscar_foto_ruta);
	    	 
	    	 resultado_consulta_rutas = prepared_statement_rutas.executeQuery();
	    	 
	    	 //CAMBIAR POR UN IF
	    	 
	    	 if(resultado_consulta_rutas.next()) {
	    		 
	    		 //se lee la cadena de bytes de la base de datos
	        	 
		         byte[] b = resultado_consulta_rutas.getBytes("Foto");
		            
		         // esta cadena de bytes sera convertida en una imagen
		            
		         image_ruta = ConvertirImagen(b);
	    		 
	    	 }
	    	 /**
	         while(resultado_consulta_rutas.next()){
	        	 
	            //se lee la cadena de bytes de la base de datos
	        	 
	            byte[] b = resultado_consulta_rutas.getBytes("Foto");
	            
	            // esta cadena de bytes sera convertida en una imagen
	            
	            image_ruta = ConvertirImagen(b);
	            i++;
	         }
	         **/
	         resultado_consulta_rutas.close();
	         
	     } catch (IOException ex) {
	    	 System.out.println(ex);
	     }catch(SQLException e){
	         System.out.println(e);
	    }
	    return image_ruta;
	 }


	/**
	 * 
	 * Descripcion: Metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
	 * 
	 * @param bytes
	 * @return
	 * @throws IOException
	 */
	private Image ConvertirImagen(byte[] bytes) throws IOException {
		
	    ByteArrayInputStream byte_array = new ByteArrayInputStream(bytes);
	    Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
	    
	    ImageReader reader = (ImageReader) readers.next();
	    Object source = byte_array;
	    
	    ImageInputStream image_input_stream = ImageIO.createImageInputStream(source);
	    reader.setInput(image_input_stream, true);
	    ImageReadParam image_read_param = reader.getDefaultReadParam();
	    
	    return reader.read(0, image_read_param);
	 }
}


	  






