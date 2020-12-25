package Dominio;

import java.util.Date;

public class Usuario {
	
	private String nombre;
	private String apellidos;
	
	private String nombre_usuario;
	private String contrasena;
	private String tipo_usuario;
	
	private String telefono;
	private String correo_electronico;
	private Date fecha_nacimiento;
	
	public Usuario (String nombre, String apellidos, String nombre_usuario, String contrasena, String tipo_usuario, String telefono, String correo_electronico, Date fecha_nacimiento) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.tipo_usuario = tipo_usuario; 
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;
		this.fecha_nacimiento = fecha_nacimiento;
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setApellidos(String a) {
		this.apellidos = a;
	}
	
	public String getNombreUsuario() {
		return this.nombre_usuario;
	}
	public void setNombreUsuario(String nu) {
		this.nombre_usuario = nu;
	}
	
	public String getContrasena() {
		return this.contrasena;
	}
	public void setContrasena(String c) {
		this.contrasena = c;
	}
	
	public String getTipoUsuario() {
		return this.tipo_usuario;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	public void setTelefono(String t) {
		this.telefono = t;
	}
	
	public String getCorreoElectronico() {
		return this.correo_electronico;
	}
	public void setCorreoElectronico(String ce) {
		this.correo_electronico = ce;
	}
	
	public Date getFechaNacimiento() {
		return this.fecha_nacimiento;
	}
	public void setFechaNacimiento(Date fn) {
		this.fecha_nacimiento = fn;
	}
	
}
