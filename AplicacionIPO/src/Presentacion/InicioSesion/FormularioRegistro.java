package Presentacion.InicioSesion;

import java.awt.AWTKeyStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import javax.swing.JFormattedTextField;

import Persistencia.gestorPerfil;
import Persistencia.gestorUsuario;
import Traductor.Messages;

public class FormularioRegistro extends JFrame {

	private JPanel contentPane;
	private JLabel lblNombre;
	private JTextField txtNombreUsuario;
	private JLabel lblApellidos;
	private JTextField txtNombre;
	private JLabel lblNombreUsuario;
	private JTextField txtApellido;
	private JLabel lblConfirmarContrasena;
	private JPasswordField pwdfContrasena;
	private JPasswordField pwdfConfirmarContrasena;
	private JLabel lblContrasena;
	private JTextField txtCorreoElectronico;
	private JLabel lblTelefono;
	private JLabel lblTipoUsuario;
	private JComboBox cmbTipoUsuario;
	private JLabel lblCorreoElectronico;
	private JButton btnRegistroTerminado;
	private JLabel lblblFechaNacimiento;
	private JLabel lblOpcional1;
	private JLabel lblOpcional2;
	private JCheckBox chckbxS;
	private JCheckBox chckbxN;
	private JCheckBox chckbxHideShow;
	private JDateChooser dcFechaNacimiento;
	private JFormattedTextField ftxtTelefono;
	private JLabel lblEstadoContrasena;
	private JButton btnRegistroCancelado;
	private JLabel lblComprobarUsuario;
	
	//Creaccion de colores como atributos privados a nivel de clase
	
	private Color colorBlanco = new Color (255,255,255);
	private Color colorResaltado = new Color (255,255,210);	
	private Color colorVerde = new Color(0, 143, 57);
	private Color colorNaranja = new Color(255, 128, 0);
	
	//Creaccion de atributos privados a nivel de clase para determinar mediante colores acciones correctas o no
	
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(colorVerde);
	private Border bordeNaranja = BorderFactory.createLineBorder(colorNaranja);
	
	//Creaccion de atributos privados para cambiar la imagen de ocultar o mostrar la contrasena
	
	private ImageIcon image_icon_show_password = new ImageIcon(FormularioRegistro.class.getResource("/recursos/eye.png"));
	private ImageIcon image_icon_hide_password = new ImageIcon(FormularioRegistro.class.getResource("/recursos/hide_eye.png"));
	
	//Atributo que permite las operaciones con la base de datos
	
	private gestorUsuario metodos_gestor_usuario = new gestorUsuario();
	private gestorPerfil metodos_gestor_perfil = new gestorPerfil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioRegistro frame = new FormularioRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioRegistro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		inicializarDatosFormularioRegistro();
		
		//Inicializacion de los datos con respecto a los dos primeros campos agrupados
		inicializarDatosPrimerAgrupamiento();
		
		//Inicializacion de los datos con respecto a los cuatro siguientes campos agrupados
		inicializarDatosSegundoAgrupamiento();
		
		//Inicializacion de los datos con respecto a los tres ultimos campos agrupados
		inicializarDatosTercerAgrupamiento();
	
		//Inicializacion de los datos con respecto a los dos check box
		inicializarDatosAgrupamientoCheckBox();
		
		//Inicializacion botones
		inicializarDatosBotones();
		
		asociacionOyentesFormularioRegistro();
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene todos los oyentes del Formulario Registro
	 * 
	 */
	private void asociacionOyentesFormularioRegistro() {
		
		btnRegistroTerminado.addActionListener(new BtnFinalizarRegistroActionListener());
		btnRegistroCancelado.addActionListener(new BtnCancelarRegistroActionListener());
		
		txtNombre.addFocusListener(new TxtFormularioRegistroFocusListener());
		txtApellido.addFocusListener(new TxtFormularioRegistroFocusListener());
		txtNombreUsuario.addFocusListener(new TxtFormularioRegistroFocusListener());
		
		pwdfContrasena.addFocusListener(new TxtFormularioRegistroFocusListener());
		pwdfContrasena.addKeyListener(new DeterminarTeclaPulsadaOyenteKeyAdapter());
		
		pwdfConfirmarContrasena.addFocusListener(new TxtFormularioRegistroFocusListener());
		pwdfConfirmarContrasena.addKeyListener(new DeterminarContrasenasIgualesKeyAdapter());
		
		txtCorreoElectronico.addFocusListener(new TxtFormularioRegistroFocusListener());
		
		chckbxHideShow.addActionListener(new OcultarMostrarContrasenaActionListener());
			
	}
	/**
	 * 
	 * Descripcion: cambia de color el borde si las contrasenas coincide
	 *
	 */
	private class DeterminarContrasenasIgualesKeyAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			
			if (pwdfContrasena.getText().equals(pwdfConfirmarContrasena.getText())) {
				
				pwdfConfirmarContrasena.setBorder(bordeVerde);
				
			}
			else {
				
				pwdfConfirmarContrasena.setBorder(bordeRojo);
				
			}
			
		}
		
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrarel registro
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra cerrar el registro
	 */
	private int  dialogoCerrarRegistro() {
		
		int opcion = -1;
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarRegistroMensaje = new JLabel("¿Está seguro que desea cerrar el registro? Los datos no seran guardados.");
		labelDialogoCerrarRegistroMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		if (VentanaInicio.frame_registro != null) {
			opcion = JOptionPane.showOptionDialog(VentanaInicio.frame_registro, labelDialogoCerrarRegistroMensaje, "Aviso de cierre registro.", 0, 2, null, botones_list, null);
		}
		
		return opcion;
	}
	/**
	 * 
	 * Descripcion: Cancelar el resgistro y salirse si el usuario lo desea
	 *
	 */
	private class BtnCancelarRegistroActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int opcion_registro = -1;
			
			if (VentanaInicio.frame_registro != null) {
				opcion_registro = dialogoCerrarRegistro();
				if(opcion_registro == 0) {
					VentanaInicio.frame_registro.dispose();
				}
			}
		}
	}
	/**
	 * 
	 * Descripcion: Ocultar o mostrar la contrasena del formulario registro
	 *
	 */
	private class OcultarMostrarContrasenaActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(chckbxHideShow.isSelected()) {
				
				pwdfContrasena.setEchoChar((char)0);
				pwdfConfirmarContrasena.setEchoChar((char)0);
				chckbxHideShow.setIcon(image_icon_show_password);
				
			}
			else {
				
				chckbxHideShow.setIcon(image_icon_hide_password);
				pwdfContrasena.setEchoChar('*');
				pwdfConfirmarContrasena.setEchoChar('*');
			}
		}	
	}
	/**
	 * 
	 * Descripcion: cambia de color el borde dependiendo de la longitud de la cadena de la contrasena
	 *
	 */
	private class DeterminarTeclaPulsadaOyenteKeyAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			
			if (pwdfContrasena.getText().isEmpty()) {
				
				pwdfContrasena.setBorder(bordeRojo);
				lblEstadoContrasena.setText("");
				
			}
			else {
				
				if (pwdfContrasena.getText().length() < 3) {
					
					pwdfContrasena.setBorder(bordeRojo);
					lblEstadoContrasena.setText("(Contraseña débil)");
					
				} 
				if (pwdfContrasena.getText().length() > 4 && pwdfContrasena.getText().length() < 7) {
					
					pwdfContrasena.setBorder(bordeNaranja);
					lblEstadoContrasena.setText("(Contraseña media)");
					
				}
				if (pwdfContrasena.getText().length() > 8) {
					
					pwdfContrasena.setBorder(bordeVerde);
					lblEstadoContrasena.setText("(Contraseña fuerte)");
					
				}
			}
			
		}
		
	}
	/**
	 * 
	 * Descripcion: Asociamos el comportamiento a los dos campos de introducir datos del formulario registro
	 *
	 */
	private class TxtFormularioRegistroFocusListener extends FocusAdapter {
		
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(colorResaltado);
			
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorBlanco);
		}
		
	}
	/**
	 * 
	 * Descripcion: metodo que determina si en el campo del correo por lo menos el usuario ha introducido el caracter @
	 * 
	 * @return una variable boolean que determina si el correo introducido por el usuario es correcto
	 */
	private boolean comprobarCorreoElectronico() {
		
		boolean correo_correcto = false;
		String comprobar_correo = txtCorreoElectronico.getText();
		
		for(int i = 0; i<comprobar_correo.length(); i++) {
			if(comprobar_correo.charAt(i) == '@') {
				correo_correcto = true;
			}
		}
		
		return correo_correcto;
		
	}
	/**
	 * 
	 * Descripcion: Metodo para saber si ya hay un usuario con ese nombre registrado en el sistema
	 * 
	 * @return el valor que si es 0 significa que el usuario ya esta registrado en el sistema
	 */
	private int ComprobacionUsuarioRegistrado() {
		
		int comprobar_usuario_registrado_sistema = -1;
		
		if (txtNombreUsuario.getText() != null) {
			comprobar_usuario_registrado_sistema = metodos_gestor_usuario.buscarUsuarioRegistrado(txtNombreUsuario.getText().toString());
			if(comprobar_usuario_registrado_sistema == 0) {
				lblComprobarUsuario.setText("Usuario en uso");
				txtNombreUsuario.setBorder(bordeRojo);
			}
		}
		
		return comprobar_usuario_registrado_sistema;
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que faltan campos por completar
	 * 
	 */
	private void dialogoCamposIncompletos() {
		
		//Datos dialogo aviso en el registro
		
		JLabel labelDialogoRegistroIncompletoMensaje = new JLabel("Termine de completar los campos que faltan.");
		labelDialogoRegistroIncompletoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		//Mensaje
		
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroIncompletoMensaje, "Campos incompletos.", 2);
		
	}
	/**
	 * 
	 * Descripcion: Al pulsar el boton finalizar se guardan los datos y se finaliza el registro
	 *
	 */
	private class BtnFinalizarRegistroActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			boolean comprobar_correo = comprobarCorreoElectronico();
			int comprobar_usuario_registrado_sistema = ComprobacionUsuarioRegistrado();
			int validacion = 0;
			
			
			if (txtCorreoElectronico.getText().equals("") || comprobar_usuario_registrado_sistema == 0 || comprobar_correo == false || txtNombreUsuario.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("") || pwdfContrasena.getText().equals("") || pwdfConfirmarContrasena.getText().equals("")) {
				
				dialogoCamposIncompletos();
				
			
				if (lblComprobarUsuario.getText().equals("Usuario en uso") ) {
					txtNombreUsuario.setBorder(bordeRojo);
				}
				
				if (txtNombreUsuario.getText().equals("") ) {
					txtNombreUsuario.setBorder(bordeRojo);
				}
				
				comprobarDatosFormularioRegistro();
				
			}
			else {
							
				if (pwdfConfirmarContrasena.getText().equals(pwdfContrasena.getText())) {
					
					txtNombre.setBorder(bordeVerde);
					txtApellido.setBorder(bordeVerde);
					
					txtNombreUsuario.setBorder(bordeVerde);
					pwdfContrasena.setBorder(bordeVerde);
					pwdfConfirmarContrasena.setBorder(bordeVerde);
					lblEstadoContrasena.setText("");
					
					txtCorreoElectronico.setBorder(bordeVerde);
					
					validacion = insertarDatosUsuario();
					
					//Para cerrar la ventana del formulario y no se puedan introducir mas datos
					
					if (VentanaInicio.frame_registro != null) {	
						VentanaInicio.frame_registro.dispose();	
					}
					
					//Mostrar cuadros de dialogos correspondientes
					
					if(validacion > 0) {
						dialogoRegistroExitoso();
						
						//Insertar datos por defecto
						metodos_gestor_perfil.insertarPerfilUsuario(txtNombreUsuario.getText().toString(), "Ninguno".toString(), 
								"No".toString(), "Otro".toString(), "/recursos/Avatar.png".toString());
					}
					else {
						dialogoErrorRegistro();
					}
				}
				else {
					dialogoContrasenasDistintas();
				}
			}
		}
	}
	/**
	 * 
	 * Descripcion: metodo que permite insertar un nuevo usuario en la base de datos para registrarlo
	 * 
	 * @return un entero para saber si la operacion ha salido bien
	 */
	private int insertarDatosUsuario() {
		
		int comprobacion = 0;
		String cadena_formato_fecha = null;
		
		//Codigo que permite insertar los datos en la base de datos
		
		if (dcFechaNacimiento.getDate() == null) {
			comprobacion = metodos_gestor_usuario.insertarUsuario(txtNombreUsuario.getText().toString(), txtNombre.getText().toString(), txtApellido.getText().toString(), pwdfContrasena.getText().toString(), (String)cmbTipoUsuario.getSelectedItem(), ftxtTelefono.getText(), txtCorreoElectronico.getText().toString(), null);
		} else {
			cadena_formato_fecha = dcFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH)+"/"+ dcFechaNacimiento.getCalendar().get(Calendar.MONTH)+"/"+ dcFechaNacimiento.getCalendar().get(Calendar.YEAR);	
			comprobacion = metodos_gestor_usuario.insertarUsuario(txtNombreUsuario.getText().toString(), txtNombre.getText().toString(), txtApellido.getText().toString(), pwdfContrasena.getText().toString(), (String)cmbTipoUsuario.getSelectedItem(), ftxtTelefono.getText(), txtCorreoElectronico.getText().toString(), cadena_formato_fecha);
		}
		
	
		return comprobacion;
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que sus datos han sigo registrados correctamente
	 * 
	 */
	private void dialogoRegistroExitoso() {
				
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos han sido registrados correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos guardados.", 1);
			
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que sus datos no han sigo registrados
	 * 
	 */
	private void dialogoErrorRegistro() {
		
		//Datos dialogo error registrar datos
		
		JLabel labelDialogoRegistroErrorMensaje = new JLabel("No se han podido registrar los datos.");
		labelDialogoRegistroErrorMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroErrorMensaje, "Error registro.", 0);
			
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que las contrasenas no coinciden
	 * 
	 */
	private void dialogoContrasenasDistintas() {
		
		//Datos dialogo error contrasena
			
		JLabel labelDialogoContrasenasMensaje = new JLabel("Las contraseñas no coinciden.");
		labelDialogoContrasenasMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoContrasenasMensaje, "Contraseñas no válidas.", 0);
		
		pwdfContrasena.setBorder(bordeRojo);
		pwdfConfirmarContrasena.setBorder(bordeRojo);
			
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte de diseño al inicializar es estilo que tendra esta parte de la aplicacion
	 * 
	 */
	private void inicializarDatosFormularioRegistro() {
		
		setTitle(Messages.getString("FormularioRegistro.this.title")); //$NON-NLS-1$
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioRegistro.class.getResource("/recursos/Form.png")));
		
		setFont(new Font("Segoe UI", Font.BOLD, 16));
		setBounds(new Rectangle(50, 50, 500, 650));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		contentPane.setBorder(new TitledBorder(null, Messages.getString("FormularioRegistro.contentPane.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{48, 167, 52, 80, 129, 47, 0};
		gbl_contentPane.rowHeights = new int[]{45, 29, 30, 42, 31, 30, 32, 36, 46, 31, 33, 32, 32, 25, 0, 32, 22, 35, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//Permite al pulsat INTRO desplazarte entre campos
		
		Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
        teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
        
        getContentPane().setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, teclas);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte disenio relacionados con los dos primeros campos similares del formulario
	 * 
	 */
	private void inicializarDatosPrimerAgrupamiento() {
		
		//Datos campos Nombre
		
		lblNombre = new JLabel(Messages.getString("FormularioRegistro.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.BOTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		//Datos campos Apellido
		
		lblApellidos = new JLabel(Messages.getString("FormularioRegistro.lblApellidos.text")); //$NON-NLS-1$
		lblApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 2;
		contentPane.add(lblApellidos, gbc_lblApellidos);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.fill = GridBagConstraints.BOTH;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 2;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados con respecto a la parte de disenio del segundo grupo con caracteristicas similares
	 * 
	 */
	private void inicializarDatosSegundoAgrupamiento() {
		
		//Datos campos Nombre de Usuario
		
		lblNombreUsuario = new JLabel(Messages.getString("FormularioRegistro.lblNombreUsuario.text")); //$NON-NLS-1$
		lblNombreUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombreUsuario = new GridBagConstraints();
		gbc_lblNombreUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreUsuario.gridx = 1;
		gbc_lblNombreUsuario.gridy = 4;
		contentPane.add(lblNombreUsuario, gbc_lblNombreUsuario);
		
		txtNombreUsuario = new JTextField();
		GridBagConstraints gbc_txtNombreUsuario = new GridBagConstraints();
		gbc_txtNombreUsuario.fill = GridBagConstraints.BOTH;
		gbc_txtNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreUsuario.gridx = 2;
		gbc_txtNombreUsuario.gridy = 4;
		contentPane.add(txtNombreUsuario, gbc_txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		lblComprobarUsuario = new JLabel(Messages.getString("FormularioRegistro.lblComprobarUsuario.text")); //$NON-NLS-1$
		lblComprobarUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblComprobarUsuario = new GridBagConstraints();
		gbc_lblComprobarUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblComprobarUsuario.gridwidth = 2;
		gbc_lblComprobarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblComprobarUsuario.gridx = 3;
		gbc_lblComprobarUsuario.gridy = 4;
		contentPane.add(lblComprobarUsuario, gbc_lblComprobarUsuario);
		
		// Datos campos contrasenas
		
		lblContrasena = new JLabel(Messages.getString("FormularioRegistro.lblContrasena.text")); //$NON-NLS-1$
		lblContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.anchor = GridBagConstraints.EAST;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 1;
		gbc_lblContrasena.gridy = 5;
		contentPane.add(lblContrasena, gbc_lblContrasena);
		
		pwdfContrasena = new JPasswordField();
		GridBagConstraints gbc_pwdfContrasena = new GridBagConstraints();
		gbc_pwdfContrasena.gridwidth = 2;
		gbc_pwdfContrasena.fill = GridBagConstraints.BOTH;
		gbc_pwdfContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_pwdfContrasena.gridx = 2;
		gbc_pwdfContrasena.gridy = 5;
		contentPane.add(pwdfContrasena, gbc_pwdfContrasena);
		
		chckbxHideShow = new JCheckBox(Messages.getString("FormularioRegistro.chckbxHideShow.text")); //$NON-NLS-1$
		chckbxHideShow.setIcon(new ImageIcon(FormularioRegistro.class.getResource("/recursos/hide_eye.png")));
		chckbxHideShow.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_chckbxHideShow = new GridBagConstraints();
		gbc_chckbxHideShow.anchor = GridBagConstraints.WEST;
		gbc_chckbxHideShow.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHideShow.gridx = 4;
		gbc_chckbxHideShow.gridy = 5;
		contentPane.add(chckbxHideShow, gbc_chckbxHideShow);
		
		
		//Datos campos de confirmacion contrasenas
		
		lblConfirmarContrasena = new JLabel(Messages.getString("FormularioRegistro.lblConfirmarContrasena.text")); //$NON-NLS-1$
		lblConfirmarContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfirmarContrasena = new GridBagConstraints();
		gbc_lblConfirmarContrasena.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmarContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasena.gridx = 1;
		gbc_lblConfirmarContrasena.gridy = 6;
		contentPane.add(lblConfirmarContrasena, gbc_lblConfirmarContrasena);
		
		pwdfConfirmarContrasena = new JPasswordField();
		GridBagConstraints gbc_pwdfConfirmarContrasena = new GridBagConstraints();
		gbc_pwdfConfirmarContrasena.gridwidth = 2;
		gbc_pwdfConfirmarContrasena.fill = GridBagConstraints.BOTH;
		gbc_pwdfConfirmarContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_pwdfConfirmarContrasena.gridx = 2;
		gbc_pwdfConfirmarContrasena.gridy = 6;
		contentPane.add(pwdfConfirmarContrasena, gbc_pwdfConfirmarContrasena);
		
		lblEstadoContrasena = new JLabel(Messages.getString("FormularioRegistro.lblEstadoContrasena.text")); //$NON-NLS-1$
		lblEstadoContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEstadoContrasena = new GridBagConstraints();
		gbc_lblEstadoContrasena.anchor = GridBagConstraints.WEST;
		gbc_lblEstadoContrasena.gridwidth = 2;
		gbc_lblEstadoContrasena.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstadoContrasena.gridx = 4;
		gbc_lblEstadoContrasena.gridy = 6;
		contentPane.add(lblEstadoContrasena, gbc_lblEstadoContrasena);
		
		//Datos seleccion tipo de Usuario aplicacion
		
		lblTipoUsuario = new JLabel(Messages.getString("FormularioRegistro.lblTipoUsuario.text")); //$NON-NLS-1$
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuario.gridx = 1;
		gbc_lblTipoUsuario.gridy = 7;
		contentPane.add(lblTipoUsuario, gbc_lblTipoUsuario);
		
		cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setBackground(new Color(248, 248, 255));
		cmbTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Guía", "Monitor", "Otro"}));
		GridBagConstraints gbc_cmbTipoUsuario = new GridBagConstraints();
		gbc_cmbTipoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoUsuario.anchor = GridBagConstraints.NORTH;
		gbc_cmbTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoUsuario.gridx = 2;
		gbc_cmbTipoUsuario.gridy = 7;
		contentPane.add(cmbTipoUsuario, gbc_cmbTipoUsuario);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte de disenio con respecto al ultimo grupo que tiene caracteristicas similares
	 * 
	 */
	private void inicializarDatosTercerAgrupamiento() {
		
		//Datos campos Telefono
		
		lblTelefono = new JLabel(Messages.getString("FormularioRegistro.lblTelefono.text")); //$NON-NLS-1$
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 9;
		contentPane.add(lblTelefono, gbc_lblTelefono);
		
		
		//Formaro al campo del telefono
		
		MaskFormatter formatoTlfno;
		try {
			formatoTlfno = new MaskFormatter("'(###')' ###' ###' ###");
			formatoTlfno.setPlaceholderCharacter('*');
			ftxtTelefono = new JFormattedTextField(formatoTlfno);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		//ftxtTelefono = new JFormattedTextField();
		GridBagConstraints gbc_ftxtTelefono = new GridBagConstraints();
		gbc_ftxtTelefono.gridwidth = 2;
		gbc_ftxtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtTelefono.fill = GridBagConstraints.BOTH;
		gbc_ftxtTelefono.gridx = 2;
		gbc_ftxtTelefono.gridy = 9;
		contentPane.add(ftxtTelefono, gbc_ftxtTelefono);
		
		lblOpcional2 = new JLabel(Messages.getString("FormularioRegistro.lblOpcional2.text")); //$NON-NLS-1$
		lblOpcional2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOpcional2 = new GridBagConstraints();
		gbc_lblOpcional2.anchor = GridBagConstraints.WEST;
		gbc_lblOpcional2.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcional2.gridx = 4;
		gbc_lblOpcional2.gridy = 9;
		contentPane.add(lblOpcional2, gbc_lblOpcional2);
		
		//Datos campos correo electronico
		
		lblCorreoElectronico = new JLabel(Messages.getString("FormularioRegistro.lblCorreoElectronico.text")); //$NON-NLS-1$
		lblCorreoElectronico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCorreoElectronico = new GridBagConstraints();
		gbc_lblCorreoElectronico.anchor = GridBagConstraints.EAST;
		gbc_lblCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectronico.gridx = 1;
		gbc_lblCorreoElectronico.gridy = 10;
		contentPane.add(lblCorreoElectronico, gbc_lblCorreoElectronico);
		
		txtCorreoElectronico = new JTextField();
		GridBagConstraints gbc_txtCorreoElectronico = new GridBagConstraints();
		gbc_txtCorreoElectronico.fill = GridBagConstraints.BOTH;
		gbc_txtCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreoElectronico.gridwidth = 2;
		gbc_txtCorreoElectronico.gridx = 2;
		gbc_txtCorreoElectronico.gridy = 10;
		contentPane.add(txtCorreoElectronico, gbc_txtCorreoElectronico);
		txtCorreoElectronico.setColumns(10);
		
		//Datos campos fecha de nacimiento
		
		lblblFechaNacimiento = new JLabel(Messages.getString("FormularioRegistro.lblblFechaNacimiento.text")); //$NON-NLS-1$
		lblblFechaNacimiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblblFechaNacimiento = new GridBagConstraints();
		gbc_lblblFechaNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblblFechaNacimiento.gridx = 1;
		gbc_lblblFechaNacimiento.gridy = 11;
		contentPane.add(lblblFechaNacimiento, gbc_lblblFechaNacimiento);
		
		dcFechaNacimiento = new JDateChooser();
		GridBagConstraints gbc_dcFechaNacimiento = new GridBagConstraints();
		gbc_dcFechaNacimiento.gridwidth = 2;
		gbc_dcFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_dcFechaNacimiento.fill = GridBagConstraints.BOTH;
		gbc_dcFechaNacimiento.gridx = 2;
		gbc_dcFechaNacimiento.gridy = 11;
		contentPane.add(dcFechaNacimiento, gbc_dcFechaNacimiento);
		
		lblOpcional1 = new JLabel(Messages.getString("FormularioRegistro.lblOpcional1.text")); //$NON-NLS-1$
		lblOpcional1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOpcional1 = new GridBagConstraints();
		gbc_lblOpcional1.anchor = GridBagConstraints.WEST;
		gbc_lblOpcional1.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcional1.gridx = 4;
		gbc_lblOpcional1.gridy = 11;
		contentPane.add(lblOpcional1, gbc_lblOpcional1);
		
	}
	/**
	 * 
	 * Descripcion:Datos generados con respecto a la parte de disenio relacionados con los check box
	 * 
	 */
	private void inicializarDatosAgrupamientoCheckBox() {
		
		//Datos primer chexk box
		
		chckbxS = new JCheckBox(Messages.getString("FormularioRegistro.chckbxS.text")); //$NON-NLS-1$
		chckbxS.setBackground(new Color(255, 255, 255));
		chckbxS.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_chckbxS = new GridBagConstraints();
		gbc_chckbxS.gridwidth = 3;
		gbc_chckbxS.anchor = GridBagConstraints.WEST;
		gbc_chckbxS.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxS.gridx = 2;
		gbc_chckbxS.gridy = 13;
		contentPane.add(chckbxS, gbc_chckbxS);
		
		// Datos segundo check box
		
		chckbxN = new JCheckBox(Messages.getString("FormularioRegistro.chckbxN.text")); //$NON-NLS-1$
		chckbxN.setBackground(new Color(255, 255, 255));
		chckbxN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_chckbxN = new GridBagConstraints();
		gbc_chckbxN.gridwidth = 3;
		gbc_chckbxN.anchor = GridBagConstraints.WEST;
		gbc_chckbxN.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxN.gridx = 2;
		gbc_chckbxN.gridy = 14;
		contentPane.add(chckbxN, gbc_chckbxN);
		
	}
	/**
	 * 
	 * Descripcion: Inicializacion de los botones del Formulario Registro
	 * 
	 */
	private void inicializarDatosBotones() {
		
		//Datos boton Cancelar el registro
		
		btnRegistroCancelado = new JButton(Messages.getString("FormularioRegistro.btnRegistroCancelado.text")); //$NON-NLS-1$
		btnRegistroCancelado.setForeground(Color.WHITE);
		btnRegistroCancelado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistroCancelado.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnRegistroCancelado = new GridBagConstraints();
		gbc_btnRegistroCancelado.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroCancelado.gridx = 3;
		gbc_btnRegistroCancelado.gridy = 16;
		contentPane.add(btnRegistroCancelado, gbc_btnRegistroCancelado);
		
		//Datos boton Finalizar el registro
		
		btnRegistroTerminado = new JButton(Messages.getString("FormularioRegistro.btnRegistroTerminado.text")); //$NON-NLS-1$
		btnRegistroTerminado.setForeground(new Color(255, 255, 255));
		btnRegistroTerminado.setBackground(new Color(51, 51, 51));
		btnRegistroTerminado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistroTerminado.setBounds(355, 192, 84, 31);
		GridBagConstraints gbc_btnRegistroTerminado = new GridBagConstraints();
		gbc_btnRegistroTerminado.anchor = GridBagConstraints.WEST;
		gbc_btnRegistroTerminado.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroTerminado.fill = GridBagConstraints.VERTICAL;
		gbc_btnRegistroTerminado.gridx = 4;
		gbc_btnRegistroTerminado.gridy = 16;
		contentPane.add(btnRegistroTerminado, gbc_btnRegistroTerminado);
		
	}
	/**
	 * 
	 * Descripcion: metodo para saber que campos estan completos o no mediante la iluminacion de los bordes
	 * 
	 */
	private void comprobarDatosFormularioRegistro() {
		
		//Bordes Nombre
		
		if (txtNombre.getText().equals("")) {
			txtNombre.setBorder(bordeRojo);
		}
		else {
			txtNombre.setBorder(bordeVerde);
		}
		
		//Bordes Apellido
		
		if (txtApellido.getText().equals("")) {
			txtApellido.setBorder(bordeRojo);
		}
		else {
			txtApellido.setBorder(bordeVerde);
		}
		
		
		//Bordes Nombre usuario
		
		
		if (txtNombreUsuario.getText() != null) {
			
			int comprobar_usuario_registrado_sistema = metodos_gestor_usuario.buscarUsuarioRegistrado(txtNombreUsuario.getText());
			
			if(comprobar_usuario_registrado_sistema == 0) {
				lblComprobarUsuario.setText("Usuario en uso");
				txtNombreUsuario.setBorder(bordeRojo);
			}
			else if (comprobar_usuario_registrado_sistema != 0 && txtNombreUsuario.getText().equals("") == false) {
				txtNombreUsuario.setBorder(bordeVerde);
				lblComprobarUsuario.setText("Usuario disponible");
			}
		}
		
		//Bordes contrasena
		
		if (pwdfContrasena.getText().equals("")) {
			pwdfContrasena.setBorder(bordeRojo);
		}
		else {
			pwdfContrasena.setBorder(bordeVerde);
		}
		
        //Bordes confirmacion contrasena
		
		if (pwdfConfirmarContrasena.getText().equals("")) {
			pwdfConfirmarContrasena.setBorder(bordeRojo);
		}
		
		//Bordes correo
		
		boolean correo_correcto_comprobacion = comprobarCorreoElectronico();
		
		if (txtCorreoElectronico.getText().equals("") || correo_correcto_comprobacion == false) {
			txtCorreoElectronico.setBorder(bordeRojo);
		}
		else {
			txtCorreoElectronico.setBorder(bordeVerde);
		}
		
	}
}
