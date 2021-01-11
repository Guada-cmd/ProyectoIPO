package Presentacion.Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Dominio.Perfil;
import Dominio.Usuario;
import Presentacion.InicioSesion.VentanaInicio;
import Presentacion.rutas.MiPanelRutasOfertadas;

@SuppressWarnings("serial")
public class MiPanelUsuario extends JPanel {
	
	private JScrollPane scrollPane;
	private JLabel lblInformacionUsuarioAvatarDB;
	private JLabel lblInformacionUsuarioNombre;
	private JLabel lblInformacionUsuarioTelefono;
	private JLabel lblInformacionUsuarioCorreoElectronico;
	private JLabel lblEdicionDatosInformacionUsuario;
	private JLabel lblHoraUltimoAcceso;
	private JLabel lblNombreUsuario;
	private JLabel lblTipoDeEmpleado;
	private JLabel lblNivelDeEstudios_1;
	private JLabel lblInformacionUsuarioTelefono_2;
	private JLabel lblInformacionUsuarioTelefono_1;
	private JLabel lblltimoAccesso;
	
	private JLabel lblUserBD;
	private JLabel lblNombreApellidosDB;
	private JLabel lblCorreoDB;
	private JLabel lblTelefonoDB;
	
	private JLabel lblIdiomasDB;
	private JLabel lblDisponibilidadDB;
	private JLabel lblNivelEstudiosDB;
	
	//Objeto que permite inicializar los datos de los usuarios
	
	private Usuario usuario_datos_configuracion;
	private Perfil datos_perfil;
	private JLabel lblUltimoAccesoDB;


	
	/**
	 * Create the panel.
	 */
	public MiPanelUsuario(Usuario usuario_datos_configuracion, Perfil datos_perfil) {
		setBackground(new Color(255, 255, 255));
		
		this.usuario_datos_configuracion = usuario_datos_configuracion;
		this.datos_perfil = datos_perfil;
		
		inicializarDatosPanelInformacionUsuario();
		
		//Inicializacion de los datos respecto a la parte de la imagen del usuario
		inicializarDatosImagenUsuario();
		
		//Inicializacion de los datos respecto a la parte de edicion de datos de la configuracion
		inicializarCamposInformacionUsuario();
		
		//Informacion Usuario
		inicializarDatosUsuario();
		
		//Datos perfil
		inicializarDatosPerfilUsuario();
					
		//Oyentes del panel configuracion
		asociacionOyentesInformacionUsuario();
		
	}
	/**
	 * 
	 * Descripcion: muestra los datos del perfil usuario iniciados por defectos en la configuracion
	 * 
	 */
	private void inicializarDatosPerfilUsuario() {
		
		if(VentanaInicio.usuario_sistema != null) {
		
			lblIdiomasDB.setText(datos_perfil.getIdiomas());
			lblDisponibilidadDB.setText(datos_perfil.getDisponibilidad());
			lblNivelEstudiosDB.setText(datos_perfil.getFormacion());
			
			if(datos_perfil.getUltimoAccesso() != null) {
				lblUltimoAccesoDB.setText(datos_perfil.getUltimoAccesso());
			}
			else {
				lblUltimoAccesoDB.setText("Ningun acceso registrado");
			}
			
			if (datos_perfil.getRutaFoto() != null) {
				lblInformacionUsuarioAvatarDB.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(datos_perfil.getRutaFoto())).getImage().getScaledInstance(246, 172, Image.SCALE_SMOOTH)));
				
			}
			else {
				lblInformacionUsuarioAvatarDB.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Avatar.jpg")).getImage().getScaledInstance(246, 172, Image.SCALE_SMOOTH)));
				
			}
			
		}
		
	}
	/**
	 * 
	 * Descripcion: muestra los datos del usuario en la configuracion
	 * 
	 */
	private void inicializarDatosUsuario() {
		
		if(VentanaInicio.usuario_sistema != null) {
			
			lblUserBD.setText(usuario_datos_configuracion.getNombreUsuario());
			lblNombreApellidosDB.setText(usuario_datos_configuracion.getNombre()+" "+usuario_datos_configuracion.getApellidos());
			lblCorreoDB.setText(usuario_datos_configuracion.getCorreoElectronico());
			
			String telefono_usuario = comprobarTelefono(usuario_datos_configuracion.getTelefono());
			
			lblTelefonoDB.setText(telefono_usuario);
			
		}
		
	}
	private String comprobarTelefono(String cadena_telefono) {
		
		String cadena_comprobada = cadena_telefono;
		
		for(int i = 0; i<cadena_comprobada.length(); i++) {
			if (cadena_comprobada.charAt(i) == '*') {
				cadena_comprobada = "Ninguno";
			}
		}
		
		return cadena_comprobada;
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene los eventos del panel de configuracion
	 * 
	 */
	private void asociacionOyentesInformacionUsuario() {
		
	}
	/**
	 * 
	 * Descripcion: Datos generados parte de disenio al hacer el panel personalizado
	 * 
	 */
	private void inicializarDatosPanelInformacionUsuario() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{112, 84, 61, 53, 61, 0, 65, 54, 54, 41, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{145, 17, 22, 19, 7, 34, 32, 39, 23, 21, 20, 20, 16, 22, 15, 29, 28, 63, 44, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	/**
	 * 
	 * Descripcion: metodo generado de la parte de disenio relacionado con la edicion de la imagen del Usuario
	 * 
	 */
	private void inicializarDatosImagenUsuario() {
		
	}
	/**
	 * 
	 * Descripcion: datos generado de la parte de disenio para que el usuario edite los datos
	 * 
	 */
	private void inicializarCamposInformacionUsuario() {
		
		//Etiqueta que sirve de titulo
		
		lblEdicionDatosInformacionUsuario = new JLabel("Información actualizada del perfil de Usuario");
		lblEdicionDatosInformacionUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblEdicionDatosInformacionUsuario = new GridBagConstraints();
		gbc_lblEdicionDatosInformacionUsuario.gridwidth = 4;
		gbc_lblEdicionDatosInformacionUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblEdicionDatosInformacionUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionDatosInformacionUsuario.gridx = 1;
		gbc_lblEdicionDatosInformacionUsuario.gridy = 1;
		add(lblEdicionDatosInformacionUsuario, gbc_lblEdicionDatosInformacionUsuario);
		
		//Componente scrollPane para la imagen del Usuario
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		//Etiqueta que permite seleccionar la foto
		
		lblInformacionUsuarioAvatarDB = new JLabel("");
		lblInformacionUsuarioAvatarDB.setBackground(new Color(255, 255, 255));
		lblInformacionUsuarioAvatarDB.setIcon(new ImageIcon(MiPanelUsuario.class.getResource("/recursos/Avatar.png")));
		lblInformacionUsuarioAvatarDB.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblInformacionUsuarioAvatarDB);
		
		lblltimoAccesso = new JLabel("Información de accesso");
		lblltimoAccesso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblltimoAccesso = new GridBagConstraints();
		gbc_lblltimoAccesso.anchor = GridBagConstraints.SOUTH;
		gbc_lblltimoAccesso.gridwidth = 2;
		gbc_lblltimoAccesso.insets = new Insets(0, 0, 5, 5);
		gbc_lblltimoAccesso.gridx = 4;
		gbc_lblltimoAccesso.gridy = 3;
		add(lblltimoAccesso, gbc_lblltimoAccesso);
		
		lblHoraUltimoAcceso = new JLabel("Último accesso:");
		lblHoraUltimoAcceso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblHoraUltimoAcceso = new GridBagConstraints();
		gbc_lblHoraUltimoAcceso.anchor = GridBagConstraints.EAST;
		gbc_lblHoraUltimoAcceso.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraUltimoAcceso.gridx = 4;
		gbc_lblHoraUltimoAcceso.gridy = 5;
		add(lblHoraUltimoAcceso, gbc_lblHoraUltimoAcceso);
		
		lblUltimoAccesoDB = new JLabel("");
		lblUltimoAccesoDB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblUltimoAccesoDB = new GridBagConstraints();
		gbc_lblUltimoAccesoDB.anchor = GridBagConstraints.WEST;
		gbc_lblUltimoAccesoDB.gridwidth = 4;
		gbc_lblUltimoAccesoDB.insets = new Insets(0, 0, 5, 5);
		gbc_lblUltimoAccesoDB.gridx = 5;
		gbc_lblUltimoAccesoDB.gridy = 5;
		add(lblUltimoAccesoDB, gbc_lblUltimoAccesoDB);
		
		lblNombreUsuario = new JLabel("Usuario:");
		lblNombreUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblNombreUsuario = new GridBagConstraints();
		gbc_lblNombreUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreUsuario.gridx = 4;
		gbc_lblNombreUsuario.gridy = 6;
		add(lblNombreUsuario, gbc_lblNombreUsuario);
		
		lblUserBD = new JLabel("");
		lblUserBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblUserBD = new GridBagConstraints();
		gbc_lblUserBD.anchor = GridBagConstraints.WEST;
		gbc_lblUserBD.gridwidth = 2;
		gbc_lblUserBD.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserBD.gridx = 5;
		gbc_lblUserBD.gridy = 6;
		add(lblUserBD, gbc_lblUserBD);
		
		//Datos relacionados con el nombre
		
		lblInformacionUsuarioNombre = new JLabel("Nombre y apellidos:");
		lblInformacionUsuarioNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblInformacionUsuarioNombre = new GridBagConstraints();
		gbc_lblInformacionUsuarioNombre.gridwidth = 2;
		gbc_lblInformacionUsuarioNombre.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioNombre.gridx = 1;
		gbc_lblInformacionUsuarioNombre.gridy = 9;
		add(lblInformacionUsuarioNombre, gbc_lblInformacionUsuarioNombre);
		
		lblNombreApellidosDB = new JLabel("");
		lblNombreApellidosDB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombreApellidosDB = new GridBagConstraints();
		gbc_lblNombreApellidosDB.anchor = GridBagConstraints.WEST;
		gbc_lblNombreApellidosDB.gridwidth = 2;
		gbc_lblNombreApellidosDB.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreApellidosDB.gridx = 3;
		gbc_lblNombreApellidosDB.gridy = 9;
		add(lblNombreApellidosDB, gbc_lblNombreApellidosDB);
		
		lblTipoDeEmpleado = new JLabel("");
		lblTipoDeEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTipoDeEmpleado = new GridBagConstraints();
		gbc_lblTipoDeEmpleado.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDeEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeEmpleado.gridx = 3;
		gbc_lblTipoDeEmpleado.gridy = 10;
		add(lblTipoDeEmpleado, gbc_lblTipoDeEmpleado);
		
		//Datos relacionados con el correo electronico
		
		lblInformacionUsuarioCorreoElectronico = new JLabel("Correo electrónico:");
		lblInformacionUsuarioCorreoElectronico.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblInformacionUsuarioCorreoElectronico = new GridBagConstraints();
		gbc_lblInformacionUsuarioCorreoElectronico.gridwidth = 2;
		gbc_lblInformacionUsuarioCorreoElectronico.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioCorreoElectronico.gridx = 1;
		gbc_lblInformacionUsuarioCorreoElectronico.gridy = 11;
		add(lblInformacionUsuarioCorreoElectronico, gbc_lblInformacionUsuarioCorreoElectronico);
		
		lblCorreoDB = new JLabel("");
		lblCorreoDB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCorreoDB = new GridBagConstraints();
		gbc_lblCorreoDB.anchor = GridBagConstraints.WEST;
		gbc_lblCorreoDB.gridwidth = 2;
		gbc_lblCorreoDB.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoDB.gridx = 3;
		gbc_lblCorreoDB.gridy = 11;
		add(lblCorreoDB, gbc_lblCorreoDB);
		
		//Datos relacionados con el telefono
		
		lblInformacionUsuarioTelefono = new JLabel("Teléfono:");
		lblInformacionUsuarioTelefono.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblInformacionUsuarioTelefono = new GridBagConstraints();
		gbc_lblInformacionUsuarioTelefono.gridwidth = 2;
		gbc_lblInformacionUsuarioTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioTelefono.gridx = 1;
		gbc_lblInformacionUsuarioTelefono.gridy = 12;
		add(lblInformacionUsuarioTelefono, gbc_lblInformacionUsuarioTelefono);
		
		lblTelefonoDB = new JLabel("");
		lblTelefonoDB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTelefonoDB = new GridBagConstraints();
		gbc_lblTelefonoDB.anchor = GridBagConstraints.WEST;
		gbc_lblTelefonoDB.gridwidth = 2;
		gbc_lblTelefonoDB.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonoDB.gridx = 3;
		gbc_lblTelefonoDB.gridy = 12;
		add(lblTelefonoDB, gbc_lblTelefonoDB);
		
		lblInformacionUsuarioTelefono_2 = new JLabel("Idiomas:");
		lblInformacionUsuarioTelefono_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblInformacionUsuarioTelefono_2 = new GridBagConstraints();
		gbc_lblInformacionUsuarioTelefono_2.gridwidth = 2;
		gbc_lblInformacionUsuarioTelefono_2.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioTelefono_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioTelefono_2.gridx = 1;
		gbc_lblInformacionUsuarioTelefono_2.gridy = 14;
		add(lblInformacionUsuarioTelefono_2, gbc_lblInformacionUsuarioTelefono_2);
		
		lblIdiomasDB = new JLabel("");
		lblIdiomasDB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblIdiomasDB = new GridBagConstraints();
		gbc_lblIdiomasDB.anchor = GridBagConstraints.WEST;
		gbc_lblIdiomasDB.gridwidth = 2;
		gbc_lblIdiomasDB.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdiomasDB.gridx = 3;
		gbc_lblIdiomasDB.gridy = 14;
		add(lblIdiomasDB, gbc_lblIdiomasDB);
		
		lblInformacionUsuarioTelefono_1 = new JLabel("Disponibilidad:");
		lblInformacionUsuarioTelefono_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblInformacionUsuarioTelefono_1 = new GridBagConstraints();
		gbc_lblInformacionUsuarioTelefono_1.gridwidth = 2;
		gbc_lblInformacionUsuarioTelefono_1.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioTelefono_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioTelefono_1.gridx = 1;
		gbc_lblInformacionUsuarioTelefono_1.gridy = 15;
		add(lblInformacionUsuarioTelefono_1, gbc_lblInformacionUsuarioTelefono_1);
		
		lblDisponibilidadDB = new JLabel("");
		lblDisponibilidadDB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDisponibilidadDB = new GridBagConstraints();
		gbc_lblDisponibilidadDB.anchor = GridBagConstraints.WEST;
		gbc_lblDisponibilidadDB.gridwidth = 2;
		gbc_lblDisponibilidadDB.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisponibilidadDB.gridx = 3;
		gbc_lblDisponibilidadDB.gridy = 15;
		add(lblDisponibilidadDB, gbc_lblDisponibilidadDB);
		
		lblNivelDeEstudios_1 = new JLabel("Nivel de estudios:");
		lblNivelDeEstudios_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblNivelDeEstudios_1 = new GridBagConstraints();
		gbc_lblNivelDeEstudios_1.gridwidth = 2;
		gbc_lblNivelDeEstudios_1.anchor = GridBagConstraints.EAST;
		gbc_lblNivelDeEstudios_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelDeEstudios_1.gridx = 1;
		gbc_lblNivelDeEstudios_1.gridy = 16;
		add(lblNivelDeEstudios_1, gbc_lblNivelDeEstudios_1);
		
		lblNivelEstudiosDB = new JLabel("");
		lblNivelEstudiosDB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNivelEstudiosDB = new GridBagConstraints();
		gbc_lblNivelEstudiosDB.anchor = GridBagConstraints.WEST;
		gbc_lblNivelEstudiosDB.gridwidth = 2;
		gbc_lblNivelEstudiosDB.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelEstudiosDB.gridx = 3;
		gbc_lblNivelEstudiosDB.gridy = 16;
		add(lblNivelEstudiosDB, gbc_lblNivelEstudiosDB);
		
	}

}
