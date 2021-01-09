package Presentacion.Principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import Dominio.Perfil;
import Dominio.Usuario;
import Persistencia.gestorUsuario;
import Presentacion.InicioSesion.VentanaInicio;

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class MiPanelConfiguracion extends JPanel {
	
	private JScrollPane scrollPane;
	private JLabel lblInformacionUsuarioAvatar;
	private JLabel lblEdicionDatosInformacionUsuario;
	
	//Objeto que permite inicializar los datos de los usuarios
	
	private Usuario usuario_datos_configuracion;
	private Perfil datos_perfil;
	
	private JButton btnCambiarFoto;
	private JTextField txtUpdateApellidos;
	private JTextField textUpdateNombre;
	private JTextField txtUpdateCorreo;
	private JLabel lblDatosNombre;
	private JLabel lblDatosApellidos;
	private JLabel lblDatosCorreo;
	private JButton btnGuardarUpdateDatos;
	private JCheckBox chckbxPermitirEdicion;
	
	private Color colorVerde = new Color(0, 143, 57);
	
	private gestorUsuario metodos_gestor_usuario = new gestorUsuario();
	
	private VentanaInicio frame_ventana_inicio;

	
	//Creaccion de atributos privados a nivel de clase para determinar mediante colores acciones correctas o no
	
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(colorVerde);


	/**
	 * Create the panel.
	 */
	public MiPanelConfiguracion(Usuario usuario_datos_configuracion, Perfil datos_perfil) {
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
		
		
			
		}
		
	}
	/**
	 * 
	 * Descripcion: muestra los datos del usuario en la configuracion
	 * 
	 */
	private void inicializarDatosUsuario() {
		
		if(VentanaInicio.usuario_sistema != null) {
			
			
			
		}
		
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
		gridBagLayout.columnWidths = new int[]{112, 84, 61, 53, 40, 57, 65, 54, 54, 41, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{224, 17, 22, 19, 7, 34, 32, 32, 33, 21, 20, 20, 16, 22, 15, 29, 28, 63, 44, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		lblEdicionDatosInformacionUsuario = new JLabel("Editar información del Usuario");
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
		
		lblInformacionUsuarioAvatar = new JLabel("");
		lblInformacionUsuarioAvatar.setBackground(new Color(255, 255, 255));
		lblInformacionUsuarioAvatar.setIcon(new ImageIcon(MiPanelConfiguracion.class.getResource("/recursos/Avatar.png")));
		lblInformacionUsuarioAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblInformacionUsuarioAvatar);
		
		chckbxPermitirEdicion = new JCheckBox("");
		chckbxPermitirEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				if(chckbxPermitirEdicion.isSelected()) {
					
					textUpdateNombre.setEnabled(true);
					txtUpdateApellidos.setEnabled(true);
					txtUpdateCorreo.setEnabled(true);
					
					lblDatosNombre.setEnabled(true);
					lblDatosApellidos.setEnabled(true);
					lblDatosCorreo.setEnabled(true);
					
					btnGuardarUpdateDatos.setEnabled(true);
				
			
				}
				
			}
		});
		chckbxPermitirEdicion.setIcon(new ImageIcon(MiPanelConfiguracion.class.getResource("/recursos/pencil.png")));
		chckbxPermitirEdicion.setBackground(Color.WHITE);
		GridBagConstraints gbc_chckbxPermitirEdicion = new GridBagConstraints();
		gbc_chckbxPermitirEdicion.anchor = GridBagConstraints.EAST;
		gbc_chckbxPermitirEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPermitirEdicion.gridx = 5;
		gbc_chckbxPermitirEdicion.gridy = 3;
		add(chckbxPermitirEdicion, gbc_chckbxPermitirEdicion);
		
		lblDatosNombre = new JLabel("Nombre:");
		lblDatosNombre.setEnabled(false);
		lblDatosNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDatosNombre = new GridBagConstraints();
		gbc_lblDatosNombre.gridwidth = 2;
		gbc_lblDatosNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosNombre.anchor = GridBagConstraints.EAST;
		gbc_lblDatosNombre.gridx = 4;
		gbc_lblDatosNombre.gridy = 5;
		add(lblDatosNombre, gbc_lblDatosNombre);
		
		textUpdateNombre = new JTextField();
		textUpdateNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textUpdateNombre.setEnabled(false);
		GridBagConstraints gbc_textUpdateNombre = new GridBagConstraints();
		gbc_textUpdateNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textUpdateNombre.fill = GridBagConstraints.BOTH;
		gbc_textUpdateNombre.gridx = 6;
		gbc_textUpdateNombre.gridy = 5;
		add(textUpdateNombre, gbc_textUpdateNombre);
		textUpdateNombre.setColumns(10);
		
		lblDatosApellidos = new JLabel("Apellidos:");
		lblDatosApellidos.setEnabled(false);
		lblDatosApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDatosApellidos = new GridBagConstraints();
		gbc_lblDatosApellidos.gridwidth = 2;
		gbc_lblDatosApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblDatosApellidos.gridx = 4;
		gbc_lblDatosApellidos.gridy = 6;
		add(lblDatosApellidos, gbc_lblDatosApellidos);
		
		txtUpdateApellidos = new JTextField();
		txtUpdateApellidos.setEnabled(false);
		GridBagConstraints gbc_txtUpdateApellidos = new GridBagConstraints();
		gbc_txtUpdateApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtUpdateApellidos.fill = GridBagConstraints.BOTH;
		gbc_txtUpdateApellidos.gridx = 6;
		gbc_txtUpdateApellidos.gridy = 6;
		add(txtUpdateApellidos, gbc_txtUpdateApellidos);
		txtUpdateApellidos.setColumns(10);
		
		lblDatosCorreo = new JLabel("Correo:");
		lblDatosCorreo.setEnabled(false);
		lblDatosCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDatosCorreo = new GridBagConstraints();
		gbc_lblDatosCorreo.gridwidth = 2;
		gbc_lblDatosCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblDatosCorreo.gridx = 4;
		gbc_lblDatosCorreo.gridy = 8;
		add(lblDatosCorreo, gbc_lblDatosCorreo);
		
		txtUpdateCorreo = new JTextField();
		txtUpdateCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUpdateCorreo.setEnabled(false);
		GridBagConstraints gbc_txtUpdateCorreo = new GridBagConstraints();
		gbc_txtUpdateCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtUpdateCorreo.fill = GridBagConstraints.BOTH;
		gbc_txtUpdateCorreo.gridx = 6;
		gbc_txtUpdateCorreo.gridy = 8;
		add(txtUpdateCorreo, gbc_txtUpdateCorreo);
		txtUpdateCorreo.setColumns(10);
		
		btnCambiarFoto = new JButton("Cargar...");
		btnCambiarFoto.setBorder(null);
		btnCambiarFoto.setIcon(new ImageIcon(MiPanelConfiguracion.class.getResource("/recursos/add-picture.png")));
		btnCambiarFoto.setFocusPainted(false);
		btnCambiarFoto.setFocusTraversalKeysEnabled(false);
		btnCambiarFoto.setFocusable(false);
		btnCambiarFoto.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
	
		btnCambiarFoto.setForeground(new Color(51, 51, 51));
		btnCambiarFoto.setBackground(new Color(255, 255, 255));
		
		GridBagConstraints gbc_btnCambiarFoto = new GridBagConstraints();
		gbc_btnCambiarFoto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCambiarFoto.gridwidth = 2;
		gbc_btnCambiarFoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarFoto.gridx = 1;
		gbc_btnCambiarFoto.gridy = 9;
		add(btnCambiarFoto, gbc_btnCambiarFoto);
		
		btnGuardarUpdateDatos = new JButton("Guardar");
		btnGuardarUpdateDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int validar_nuevo_nombre = -1;
				int validar_nuevo_apellido = -1;
				int validar_nuevo_correo = -1;
				
				
				if (textUpdateNombre.getText() != null || txtUpdateApellidos.getText() != null || txtUpdateCorreo.getText() != null) {
					
					if(textUpdateNombre.getText().isEmpty() == false) {
					
						textUpdateNombre.setBorder(bordeVerde);
					
						validar_nuevo_nombre = metodos_gestor_usuario.updateUsuarioParametro(usuario_datos_configuracion.getNombreUsuario(), "Nombre", textUpdateNombre.getText().toString());
					
						if(validar_nuevo_nombre == -1) {
						
							errorConfiguracionDialogo();
						
						}
					
						else if(txtUpdateApellidos.getText().isEmpty() == false) {
						
							txtUpdateApellidos.setBorder(bordeVerde);
						
							validar_nuevo_apellido = metodos_gestor_usuario.updateUsuarioParametro(usuario_datos_configuracion.getNombreUsuario(), "Apellidos", txtUpdateApellidos.getText().toString());
						
							if(validar_nuevo_apellido == -1) {
							
								errorConfiguracionDialogo();
						
							}
					
						}
					
						else if(txtUpdateCorreo.getText().isEmpty() == false) {
						
							boolean correo_correcto_comprobacion = comprobarCorreoElectronico();
						
							if (correo_correcto_comprobacion == false) {
							
								txtUpdateCorreo.setBorder(bordeRojo);
								dialogoCorreoIncorrecto();
							
							}
							else {
							
								txtUpdateCorreo.setBorder(bordeVerde);
							
								validar_nuevo_correo = metodos_gestor_usuario.updateUsuarioParametro(usuario_datos_configuracion.getNombreUsuario(), "Correo", txtUpdateCorreo.getText().toString());
							
								if(validar_nuevo_correo == -1) {
								
									errorConfiguracionDialogo();
								
							
								}
							
							}
						
						
					
						}
					dialogoRegistroExitoso();
					}
				}
				else if (textUpdateNombre.getText().equals("") && txtUpdateApellidos.getText().equals("") && txtUpdateCorreo.getText().equals("")) {
					
					
					dialogoNoDatos();
					
				}
			
			
			}
		});
		btnGuardarUpdateDatos.setFocusable(false);
		btnGuardarUpdateDatos.setFocusPainted(false);
		btnGuardarUpdateDatos.setFocusTraversalKeysEnabled(false);
		btnGuardarUpdateDatos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardarUpdateDatos.setEnabled(false);
		
		btnGuardarUpdateDatos.setForeground(new Color(255, 255, 255));
		btnGuardarUpdateDatos.setBackground(new Color(51, 51, 51));
		
		GridBagConstraints gbc_btnGuardarUpdateDatos = new GridBagConstraints();
		gbc_btnGuardarUpdateDatos.fill = GridBagConstraints.VERTICAL;
		gbc_btnGuardarUpdateDatos.anchor = GridBagConstraints.EAST;
		gbc_btnGuardarUpdateDatos.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarUpdateDatos.gridx = 6;
		gbc_btnGuardarUpdateDatos.gridy = 9;
		add(btnGuardarUpdateDatos, gbc_btnGuardarUpdateDatos);
		
	}
	private void dialogoRegistroExitoso() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos han sido registrados correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos guardados.", 1);
			
	}
	private void dialogoNoDatos() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("No se han introducido datos que actualizar.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos no introducidos.", 2);
			
	}
	
	private void errorConfiguracionDialogo() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("No se han podido actualizar los datos.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Fallo de registro.", 0);
			
	}
	
	private void dialogoCorreoIncorrecto() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("El formato del dato correo no es correcto.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos incorrecto.", 0);
			
	}
	private boolean comprobarCorreoElectronico() {
		
		boolean correo_correcto = false;
		String comprobar_correo = txtUpdateCorreo.getText();
		
		for(int i = 0; i<comprobar_correo.length(); i++) {
			if(comprobar_correo.charAt(i) == '@') {
				correo_correcto = true;
			}
		}
		
		return correo_correcto;
		
	}

}
