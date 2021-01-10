package Presentacion.Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Dominio.Perfil;
import Dominio.Usuario;
import Persistencia.gestorPerfil;
import Persistencia.gestorUsuario;
import Presentacion.InicioSesion.FormularioRegistro;
import Presentacion.InicioSesion.VentanaInicio;

@SuppressWarnings("serial")
public class MiPanelConfiguracionAvanzada extends JPanel {
	
	private JCheckBox chckbxPermitirEdicion;
	
	private JLabel lblContrasenaCA;
	private JLabel lblConfirmarContrasenaCA;
	private JLabel lblEdicionDatosConfiguracion;
	private JLabel lblDatosEmpleados;
	private JLabel lblEditarIdiomas;
	private JLabel lblEditarFormacion;
	private JLabel lblDisponibilidad;
	private JLabel lblPanelDeConfiguracin;
	
	private JPasswordField pswfContrasenaCA;
	private JPasswordField pswfConfirmarContrasenaCA;
	
	private JButton btnDarBajaCuenta;
	private JButton btnGuardarNuevosDatos;
	
	private JTextField txtEditarIdiomas;
	
	private JComboBox<String> cmbEditarFormacion;
	private JComboBox<String> cmbEditarDisponibilidad;
	

	private Usuario usuario_datos_configuracion;
	private Perfil datos_perfil;
	

	private Color colorVerde = new Color(0, 143, 57);

	
	private Color colorBlanco = new Color (255,255,255);
	private Color colorResaltado = new Color (255,255,210);	
	
	//Creaccion de atributos privados a nivel de clase para determinar mediante colores acciones correctas o no
	
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(colorVerde);

	private JButton btnGuardarNuevaContrasena;
	
	private gestorUsuario metodos_gestor_usuario = new gestorUsuario();
	private gestorPerfil metodos_gestor_perfil = new gestorPerfil();
	private JCheckBox chckbxPasswordEdit;
	
	//Creaccion imagenes ocultar o mostrar contrasena
	
	private ImageIcon image_icon_show_password_login = new ImageIcon(FormularioRegistro.class.getResource("/recursos/eye.png"));
	private ImageIcon image_icon_hide_password_login = new ImageIcon(FormularioRegistro.class.getResource("/recursos/hide_eye.png"));
	
	private VentanaInicio frame_ventana_inicio;
	

	/**
	 * Create the panel.
	 */
	public MiPanelConfiguracionAvanzada(Usuario usuario_datos_configuracion, Perfil datos_perfil) {
		setBackground(new Color(255, 255, 255));
		
		this.usuario_datos_configuracion = usuario_datos_configuracion;
		this.datos_perfil = datos_perfil;
		
		
		inicializarDatosPanelConfiguracionAvanzada();
		
		//Inicializacion de los datos respecto a la parte de la imagen del usuario
		inicializarBotonEdicionConfiguracionAvanzada();
		
		//Inicializacion de los datos respecto a la parte de edicion de datos de la configuracion
		inicializarDatosEdicionConfiguracionAvanzada();
		
		
		//Oyentes del panel configuracion
		asociacionOyentesConfiguracionAvanzada();
		
		//System.out.println(usuario_datos_configuracion.getNombre());

		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene los eventos del panel de configuracion
	 * 
	 */
	private void asociacionOyentesConfiguracionAvanzada() {
		
	}
	/**
	 * 
	 * Descripcion: Datos generados parte de disenio al hacer el panel personalizado
	 * 
	 */
	private void inicializarDatosPanelConfiguracionAvanzada() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{84, 103, 156, 70, 139, 85, 108, 0, 0};
		gridBagLayout.rowHeights = new int[]{189, 31, 27, 47, 34, 36, 37, 25, 33, 37, 29, 28, 16, 32, 23, 42, 27, 27, 41, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Etiqueta que sirve de titulo
		
		lblEdicionDatosConfiguracion = new JLabel("Configuraciones avanzada de los datos del Usuario");
		lblEdicionDatosConfiguracion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblEdicionDatosConfiguracion = new GridBagConstraints();
		gbc_lblEdicionDatosConfiguracion.anchor = GridBagConstraints.WEST;
		gbc_lblEdicionDatosConfiguracion.gridwidth = 3;
		gbc_lblEdicionDatosConfiguracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionDatosConfiguracion.gridx = 2;
		gbc_lblEdicionDatosConfiguracion.gridy = 0;
		add(lblEdicionDatosConfiguracion, gbc_lblEdicionDatosConfiguracion);
		
		
	}
	/**
	 * 
	 * Descripcion: metodo generado de la parte de disenio relacionado con la creaccion del boton
	 * 
	 */
	private void inicializarBotonEdicionConfiguracionAvanzada() {
		
	
	
		
	}
	/**
	 * 
	 * Descripcion: datos generado de la parte de disenio para que el usuario edite los datos
	 * 
	 */
	private void inicializarDatosEdicionConfiguracionAvanzada() {
		
		chckbxPermitirEdicion = new JCheckBox("");
		chckbxPermitirEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxPermitirEdicion.isSelected()) {
					
					pswfContrasenaCA.setEnabled(true);
					pswfConfirmarContrasenaCA.setEnabled(true);
					lblContrasenaCA.setEnabled(true);
					lblConfirmarContrasenaCA.setEnabled(true);
					
					
					txtEditarIdiomas.setEnabled(true);
					cmbEditarFormacion.setEnabled(true);
					cmbEditarDisponibilidad.setEnabled(true);
					lblEditarIdiomas.setEnabled(true);
					lblEditarFormacion.setEnabled(true);
					lblDisponibilidad.setEnabled(true);
					
					btnGuardarNuevosDatos.setEnabled(true);
					btnGuardarNuevaContrasena.setEnabled(true);
			
				}
			
				
			}
		});
		
		lblPanelDeConfiguracin = new JLabel("Panel de configuración avanzada");
		lblPanelDeConfiguracin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblPanelDeConfiguracin = new GridBagConstraints();
		gbc_lblPanelDeConfiguracin.anchor = GridBagConstraints.WEST;
		gbc_lblPanelDeConfiguracin.gridwidth = 3;
		gbc_lblPanelDeConfiguracin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPanelDeConfiguracin.gridx = 2;
		gbc_lblPanelDeConfiguracin.gridy = 2;
		add(lblPanelDeConfiguracin, gbc_lblPanelDeConfiguracin);
		chckbxPermitirEdicion.setIcon(new ImageIcon(MiPanelConfiguracionAvanzada.class.getResource("/recursos/pencil.png")));
		chckbxPermitirEdicion.setBackground(Color.WHITE);
		GridBagConstraints gbc_chckbxPermitirEdicion = new GridBagConstraints();
		gbc_chckbxPermitirEdicion.anchor = GridBagConstraints.EAST;
		gbc_chckbxPermitirEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPermitirEdicion.gridx = 2;
		gbc_chckbxPermitirEdicion.gridy = 3;
		add(chckbxPermitirEdicion, gbc_chckbxPermitirEdicion);
		
		//Datos relacionados con la contrasena
		
		lblContrasenaCA = new JLabel("Contraseña:");
		lblContrasenaCA.setEnabled(false);
		lblContrasenaCA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblContrasenaCA = new GridBagConstraints();
		gbc_lblContrasenaCA.anchor = GridBagConstraints.EAST;
		gbc_lblContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasenaCA.gridx = 2;
		gbc_lblContrasenaCA.gridy = 4;
		add(lblContrasenaCA, gbc_lblContrasenaCA);
		
		pswfContrasenaCA = new JPasswordField();
		pswfContrasenaCA.setEnabled(false);
		GridBagConstraints gbc_pswfContrasenaCA = new GridBagConstraints();
		gbc_pswfContrasenaCA.gridwidth = 2;
		gbc_pswfContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_pswfContrasenaCA.fill = GridBagConstraints.BOTH;
		gbc_pswfContrasenaCA.gridx = 3;
		gbc_pswfContrasenaCA.gridy = 4;
		add(pswfContrasenaCA, gbc_pswfContrasenaCA);
		
		//Datos relacionados con la confirmacion contrasena
		
		lblConfirmarContrasenaCA = new JLabel("Confirmar contraseña:");
		lblConfirmarContrasenaCA.setEnabled(false);
		lblConfirmarContrasenaCA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfirmarContrasenaCA = new GridBagConstraints();
		gbc_lblConfirmarContrasenaCA.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmarContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasenaCA.gridx = 2;
		gbc_lblConfirmarContrasenaCA.gridy = 5;
		add(lblConfirmarContrasenaCA, gbc_lblConfirmarContrasenaCA);
		
		pswfConfirmarContrasenaCA = new JPasswordField();
		pswfConfirmarContrasenaCA.setEnabled(false);
		GridBagConstraints gbc_pswfConfirmarContrasenaCA = new GridBagConstraints();
		gbc_pswfConfirmarContrasenaCA.gridwidth = 2;
		gbc_pswfConfirmarContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_pswfConfirmarContrasenaCA.fill = GridBagConstraints.BOTH;
		gbc_pswfConfirmarContrasenaCA.gridx = 3;
		gbc_pswfConfirmarContrasenaCA.gridy = 5;
		add(pswfConfirmarContrasenaCA, gbc_pswfConfirmarContrasenaCA);
		
		btnGuardarNuevaContrasena = new JButton("Guardar");
		btnGuardarNuevaContrasena.setFocusable(false);
		btnGuardarNuevaContrasena.setFocusTraversalKeysEnabled(false);
		btnGuardarNuevaContrasena.setFocusPainted(false);
		btnGuardarNuevaContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(String.valueOf(pswfContrasenaCA.getPassword()).isEmpty() ||  String.valueOf(pswfConfirmarContrasenaCA.getPassword()).isEmpty()) {
					
					pswfContrasenaCA.setBorder(bordeRojo);
					pswfConfirmarContrasenaCA.setBorder(bordeRojo);
					
				}else {
					
					if(String.valueOf(pswfContrasenaCA.getPassword()).equals(String.valueOf(pswfConfirmarContrasenaCA.getPassword()))) {
				
						pswfContrasenaCA.setBorder(bordeVerde);
						pswfConfirmarContrasenaCA.setBorder(bordeVerde);
				
						//CAMBIAMOS EN BASE DE DATOS
						
						int validar_nueva_pass = metodos_gestor_usuario.updateUsuarioPass(usuario_datos_configuracion.getNombreUsuario(), String.valueOf(pswfContrasenaCA.getPassword()).toString());
						
						if(validar_nueva_pass != -1) {
							
							frame_ventana_inicio = new VentanaInicio();
							
							dialogoRegistroExitoso();
							AplicacionPrincipal.frmAplicacinPrincipalDe.dispose();
							
							frame_ventana_inicio.getJFrameVentanaInicio().setVisible(true);
							
							
							//System.exit(0);
							
							
						}
						
						errorUpdateDialogo();
						//ERROR O EXITO
				
					}
					else {
						
						//MENSAJE CONTRASENAS NO IGUALES
						
						 dialogoContrasenasDistintas();
						
						
		

					}
					
				}
			}
			
				

		});
		
		chckbxPasswordEdit = new JCheckBox("");
		chckbxPasswordEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxPasswordEdit.isSelected()) {
					
					
					pswfContrasenaCA.setEchoChar((char)0);
					pswfConfirmarContrasenaCA.setEchoChar((char)0);
					
					chckbxPasswordEdit.setIcon(image_icon_show_password_login);
					
				}
				else {
					
					chckbxPasswordEdit.setIcon(image_icon_hide_password_login);
					pswfContrasenaCA.setEchoChar('*');
					pswfConfirmarContrasenaCA.setEchoChar('*');
				
					
				}
			}
		});
		chckbxPasswordEdit.setIcon(new ImageIcon(MiPanelConfiguracionAvanzada.class.getResource("/recursos/hide_eye.png")));
		chckbxPasswordEdit.setBackground(Color.WHITE);
		GridBagConstraints gbc_chckbxPasswordEdit = new GridBagConstraints();
		gbc_chckbxPasswordEdit.anchor = GridBagConstraints.WEST;
		gbc_chckbxPasswordEdit.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPasswordEdit.gridx = 5;
		gbc_chckbxPasswordEdit.gridy = 5;
		add(chckbxPasswordEdit, gbc_chckbxPasswordEdit);
		
		btnGuardarNuevaContrasena.setForeground(Color.WHITE);
		btnGuardarNuevaContrasena.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardarNuevaContrasena.setEnabled(false);
		btnGuardarNuevaContrasena.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnGuardarNuevaContrasena = new GridBagConstraints();
		gbc_btnGuardarNuevaContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarNuevaContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarNuevaContrasena.gridx = 4;
		gbc_btnGuardarNuevaContrasena.gridy = 6;
		add(btnGuardarNuevaContrasena, gbc_btnGuardarNuevaContrasena);
		
		lblDatosEmpleados = new JLabel("Informacion adicional");
		lblDatosEmpleados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblDatosEmpleados = new GridBagConstraints();
		gbc_lblDatosEmpleados.anchor = GridBagConstraints.WEST;
		gbc_lblDatosEmpleados.gridwidth = 2;
		gbc_lblDatosEmpleados.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosEmpleados.gridx = 2;
		gbc_lblDatosEmpleados.gridy = 7;
		add(lblDatosEmpleados, gbc_lblDatosEmpleados);
		
		lblEditarIdiomas = new JLabel("Idiomas:");
		lblEditarIdiomas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEditarIdiomas.setEnabled(false);
		GridBagConstraints gbc_lblEditarIdiomas = new GridBagConstraints();
		gbc_lblEditarIdiomas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditarIdiomas.anchor = GridBagConstraints.EAST;
		gbc_lblEditarIdiomas.gridx = 2;
		gbc_lblEditarIdiomas.gridy = 9;
		add(lblEditarIdiomas, gbc_lblEditarIdiomas);
		
		txtEditarIdiomas = new JTextField();
		txtEditarIdiomas.setEnabled(false);
		txtEditarIdiomas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_txtEditarIdiomas = new GridBagConstraints();
		gbc_txtEditarIdiomas.gridwidth = 2;
		gbc_txtEditarIdiomas.insets = new Insets(0, 0, 5, 5);
		gbc_txtEditarIdiomas.fill = GridBagConstraints.BOTH;
		gbc_txtEditarIdiomas.gridx = 3;
		gbc_txtEditarIdiomas.gridy = 9;
		add(txtEditarIdiomas, gbc_txtEditarIdiomas);
		txtEditarIdiomas.setColumns(10);
		
		lblEditarFormacion = new JLabel("Formacion:");
		lblEditarFormacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEditarFormacion.setEnabled(false);
		GridBagConstraints gbc_lblEditarFormacion = new GridBagConstraints();
		gbc_lblEditarFormacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditarFormacion.anchor = GridBagConstraints.EAST;
		gbc_lblEditarFormacion.gridx = 2;
		gbc_lblEditarFormacion.gridy = 10;
		add(lblEditarFormacion, gbc_lblEditarFormacion);
		
		cmbEditarFormacion = new JComboBox();
		cmbEditarFormacion.setEnabled(false);
		cmbEditarFormacion.setModel(new DefaultComboBoxModel<String>(new String[] {"ESO", "Bachillerato", "Grado Universitario", "Otros"}));
		cmbEditarFormacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbEditarFormacion.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbEditarFormacion = new GridBagConstraints();
		gbc_cmbEditarFormacion.gridwidth = 2;
		gbc_cmbEditarFormacion.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEditarFormacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEditarFormacion.gridx = 3;
		gbc_cmbEditarFormacion.gridy = 10;
		add(cmbEditarFormacion, gbc_cmbEditarFormacion);
		
		lblDisponibilidad = new JLabel("Disponibilidad:");
		lblDisponibilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDisponibilidad.setEnabled(false);
		GridBagConstraints gbc_lblDisponibilidad = new GridBagConstraints();
		gbc_lblDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisponibilidad.anchor = GridBagConstraints.EAST;
		gbc_lblDisponibilidad.gridx = 2;
		gbc_lblDisponibilidad.gridy = 11;
		add(lblDisponibilidad, gbc_lblDisponibilidad);
		
		cmbEditarDisponibilidad = new JComboBox<String>();
		cmbEditarDisponibilidad.setEnabled(false);
		cmbEditarDisponibilidad.setModel(new DefaultComboBoxModel<String>(new String[] {"No", "Si"}));
		cmbEditarDisponibilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbEditarDisponibilidad.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbEditarDisponibilidad = new GridBagConstraints();
		gbc_cmbEditarDisponibilidad.gridwidth = 2;
		gbc_cmbEditarDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEditarDisponibilidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEditarDisponibilidad.gridx = 3;
		gbc_cmbEditarDisponibilidad.gridy = 11;
		add(cmbEditarDisponibilidad, gbc_cmbEditarDisponibilidad);
		
		btnGuardarNuevosDatos = new JButton("Guardar");
		btnGuardarNuevosDatos.setFocusable(false);
		btnGuardarNuevosDatos.setFocusTraversalKeysEnabled(false);
		btnGuardarNuevosDatos.setFocusPainted(false);
		btnGuardarNuevosDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//boolean comprobar_correo = comprobarCorreoElectronico();
				//int comprobar_usuario_registrado_sistema = ComprobacionUsuarioRegistrado();
				//int validacion = 0;
				
				 
					
					//private JComboBox cmbEditarFormacion;
					//private JComboBox cmbEditarDisponibilidad;
				
				if (txtEditarIdiomas.getText().isEmpty()) {
					
					dialogoCamposIncompletos();
					
					txtEditarIdiomas.setBorder(bordeRojo);
					
				}
				
				else {
					
					txtEditarIdiomas.setBorder(bordeVerde);
					
					int validar_nuevo_perfil = metodos_gestor_perfil.updatePerfil(usuario_datos_configuracion.getNombreUsuario(), txtEditarIdiomas.getText().toString(), (String)cmbEditarDisponibilidad.getSelectedItem(), (String) cmbEditarFormacion.getSelectedItem());
					
					if(validar_nuevo_perfil != -1) {
						
						frame_ventana_inicio = new VentanaInicio();
						
						dialogoRegistroExitoso();
						AplicacionPrincipal.frmAplicacinPrincipalDe.dispose();
						
						frame_ventana_inicio.getJFrameVentanaInicio().setVisible(true);
						
						
						//System.exit(0);
						
						
					}
					else {
						
						errorUpdateDialogo();
						
					}

			
				}
			
					
				
				
			}
		});
		btnGuardarNuevosDatos.setEnabled(false);
		btnGuardarNuevosDatos.setForeground(Color.WHITE);
		btnGuardarNuevosDatos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardarNuevosDatos.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnGuardarNuevosDatos = new GridBagConstraints();
		gbc_btnGuardarNuevosDatos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarNuevosDatos.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarNuevosDatos.gridx = 4;
		gbc_btnGuardarNuevosDatos.gridy = 12;
		add(btnGuardarNuevosDatos, gbc_btnGuardarNuevosDatos);
		
		btnDarBajaCuenta = new JButton("Darse de baja");
		btnDarBajaCuenta.setFocusPainted(false);
		btnDarBajaCuenta.setFocusTraversalKeysEnabled(false);
		btnDarBajaCuenta.setFocusable(false);
		btnDarBajaCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirmar_decision = dialogoRealizarOperacion();
				
				if(confirmar_decision == 0) {
					
					int validar_eliminacion = metodos_gestor_usuario.eliminarUsuario(usuario_datos_configuracion.getNombreUsuario());	
					
					if(validar_eliminacion!= -1) {
						
						dialogoEliminacionUsuario();
						AplicacionPrincipal.frmAplicacinPrincipalDe.dispose();
						//System.exit(0);
						
						
					}
					else {
						errorElimianarUsuario();
					}
					
				}
				
				
				
				//ERROR O EXITO
				
			}
		});
		btnDarBajaCuenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDarBajaCuenta.setForeground(new Color(255, 255, 255));
		btnDarBajaCuenta.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnDarBajaCuenta = new GridBagConstraints();
		gbc_btnDarBajaCuenta.fill = GridBagConstraints.BOTH;
		gbc_btnDarBajaCuenta.insets = new Insets(0, 0, 5, 5);
		gbc_btnDarBajaCuenta.gridx = 6;
		gbc_btnDarBajaCuenta.gridy = 12;
		add(btnDarBajaCuenta, gbc_btnDarBajaCuenta);
		

		
	}

	private int dialogoRealizarOperacion() {
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarAplicacionMensaje = new JLabel("¿Está seguro que desea eliminar su cuenta?");
		labelDialogoCerrarAplicacionMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		return JOptionPane.showOptionDialog(null, labelDialogoCerrarAplicacionMensaje, "Aviso de cierre aplicacion principal.", 0, 2, null, botones_list, null);
	
	}
	private void dialogoCamposIncompletos() {
	
	//Datos dialogo aviso en el registro
	
	JLabel labelDialogoRegistroIncompletoMensaje = new JLabel("Termine de completar los campos que faltan.");
	labelDialogoRegistroIncompletoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
	//Mensaje
	
	JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroIncompletoMensaje, "Campos incompletos.", 2);
	
	}
	private void dialogoRegistroExitoso() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos han sido registrados correctamente y el sistema se va a reiniciar.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos guardados.", 1);
			
	}
	private void errorUpdateDialogo() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos no han sido registrados correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos no guardados.", 0);
			
	}
	private void dialogoContrasenasDistintas() {
		
		//Datos dialogo error contrasena
			
		JLabel labelDialogoContrasenasMensaje = new JLabel("Las contraseñas no coinciden.");
		labelDialogoContrasenasMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoContrasenasMensaje, "Contraseñas no válidas.", 0);
		
		pswfContrasenaCA.setBorder(bordeRojo);
		pswfConfirmarContrasenaCA.setBorder(bordeRojo);
			
	}
	
	private void dialogoEliminacionUsuario() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos se han eliminado del sistema correctamente y el sistema se va a reiniciar.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Usuario eliminado.", 1);
			
	}
	private void errorElimianarUsuario() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos no se han eliminado correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Usuario no eliminado.", 0);
			
	}
}
