package Dominio;

public class Perfil {

	private String nombre_usuario;
	private String idiomas;
	private String disponibilidad;
	private String formacion;
	
	public Perfil (String nombre_usuario, String idiomas, String disponibilidad, String formacion) {
	
		this.nombre_usuario = nombre_usuario;
		this.idiomas = idiomas;
		this.disponibilidad = disponibilidad; 
		this.formacion = formacion;
		
	}
	
	public String getNombreUsuarioPerfil() {
		return this.nombre_usuario;
	}
	public void setNombreUsuarioPerfil(String nu) {
		this.nombre_usuario = nu;
	}
	
	public String getIdiomas() {
		return this.idiomas;
	}
	
	public void setIdiomas(String i) {
		this.idiomas = i;
	}
	
	public String getDisponibilidad() {
		return this.disponibilidad;
	}
	
	public void setDisponibilidad(String d) {
		this.disponibilidad = d;
	}
		
	public String getFormacion() {
		return this.formacion;
	}
	public void setFormacion(String f) {
		this.formacion = f;
	}

}