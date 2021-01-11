package Dominio;

public class Perfil {
	
	
	private String nombre_usuario;
	private String idiomas;
	private String disponibilidad;
	private String formacion;
	private String ultimo_accesso;
	private String ruta_foto;
	
	/**
	 * 
	 * Descripcion: Constructor clase dominio para el perfil
	 * 
	 * @param nombre_usuario
	 * @param idiomas
	 * @param disponibilidad
	 * @param formacion
	 * @param ultimo_accesso
	 * @param ruta_foto
	 */
	public Perfil (String nombre_usuario, String idiomas, String disponibilidad, String formacion, String ultimo_accesso, String ruta_foto) {
	
		this.nombre_usuario = nombre_usuario;
		this.idiomas = idiomas;
		this.disponibilidad = disponibilidad; 
		this.formacion = formacion;
		this.ultimo_accesso = ultimo_accesso;
		this.ruta_foto = ruta_foto;
		
	}
	
	public String getRutaFoto() {
		return this.ruta_foto;
	}
	public void setRutaFoto(String rf) {
		this.ruta_foto = rf;
	}
	public String getUltimoAccesso() {
		return this.ultimo_accesso;
	}
	public void setUltimoAccesso(String ua) {
		this.ultimo_accesso = ua;
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