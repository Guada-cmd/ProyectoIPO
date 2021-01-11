package Presentacion.InicioSesion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Persistencia.gestorUsuario;
import Presentacion.Principal.AplicacionPrincipal;
import Traductor.Messages;

public class VentanaInicio {

	private JFrame frmVentanaDeLogin;
	private JTextField txtUsuario;
	private JPasswordField pwdfContrasena;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JLabel lblTituloVentana;
	private JLabel lblTexto;
	private JButton btnEntrar;
	private JLabel lblTituloCrearCuenta;
	private JLabel lblTextoRegistro1;
	private JButton btnRegistrase;
	private JCheckBox chckbxPasswordLogin;
	private JButton btnIdiomaAplicacion;

	private AplicacionPrincipal frame_principal;
	public static FormularioRegistro frame_registro;
	
	//Creaccion de dos atributos privados a nivel de clase
	
	private Color colorBlanco = new Color (255,255,255);
	private Color colorResaltado = new Color (255,255,210);
	private Color colorVerde = new Color(0, 143, 57);
	
	//Creaccion de atributos privados a nivel de clase para determinar mediante colores acciones correctas o no
	
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(colorVerde);
	
	//Creaccion imagenes ocultar o mostrar contrasena
	
	private ImageIcon image_icon_show_password_login = new ImageIcon(FormularioRegistro.class.getResource("/recursos/eye.png"));
	private ImageIcon image_icon_hide_password_login = new ImageIcon(FormularioRegistro.class.getResource("/recursos/hide_eye.png"));
	
	//Instancia para comprobar si el usuario esta registrado en el sistema
	
	private gestorUsuario metodos_gestor_usuario_login = new gestorUsuario();
	
	//Objeto usuario
	
	public static String usuario_sistema;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio window = new VentanaInicio();
					window.frmVentanaDeLogin.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicio() {
		initialize();
		this.frmVentanaDeLogin.setLocationRelativeTo(null); //Para centrar el frame en la pantalla
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			
		inicializarDatosFrameVentanaInicio();
		inicializarDatosPanelRegistroVentanaInicio();
		inicializarDatosPanelLoginVentanaInicio();
		cerrarAplicacion();
		
		asociacionOyentes();
	
	}
	/**
	 * 
	 * Descripcion: Permite cerrar la aplicacion
	 * 
	 */
	private void cerrarAplicacion() {
		
		try {
			getJFrameVentanaInicio().addWindowListener(new cerrarAplicacionWindowAdapter());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * Descripcion: Permite cerrar la aplicacion al pulsar la cruz
	 *
	 */
	private class cerrarAplicacionWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			
			int confirmar_cerrar_aplicacion_todo = dialogoCerrarAplicacion();
			
			if (confirmar_cerrar_aplicacion_todo == 0) {
				System.exit(0);
			}
			
		}
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrar la aplicacion del todo
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra cerrar la aplicacion del todo
	 */
	private int dialogoCerrarAplicacion() {
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarAplicacionMensaje = new JLabel("¿Está seguro que desea cerrar la aplicacion?");
		labelDialogoCerrarAplicacionMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		return JOptionPane.showOptionDialog(getJFrameVentanaInicio(), labelDialogoCerrarAplicacionMensaje, "Aviso de cierre aplicacion.", 0, 1, null, botones_list, null);
	
	}
	/**
	 * 
	 * Descripcion: metodo para asociar los oyentes a los distintos botones de la Ventana inicio
	 * 
	 * 
	 */
	private void asociacionOyentes() {
		
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		btnRegistrase.addActionListener(new BtnRegistrarseActionListener());
		
		//Eventos asociados al campo Usuario
		
		txtUsuario.addActionListener(new TxtUsuarioActionListener());
		txtUsuario.addFocusListener(new TxtVentanaInicioFocusListener());
		
		//Eventos asociados al campo Contrasena
		
		pwdfContrasena.addActionListener(new PwdfPasswordActionListener());
		pwdfContrasena.addFocusListener(new TxtVentanaInicioFocusListener()); 
		
		//Evento para ocultar o mostrar contrasena
		
		chckbxPasswordLogin.addActionListener(new CheckBoxShowHideActionListener());
		btnIdiomaAplicacion.addActionListener(new TraducirActionListener());
		
	}
	private class TraducirActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			frmVentanaDeLogin.dispose();
				
			DialogoSeleccionIdioma panel_idiomas = new DialogoSeleccionIdioma("inicio");
			panel_idiomas.setLocationRelativeTo(null);
			panel_idiomas.setVisible(true);
			
		}
	}	
	/**
	 * 
	 * Descripcion: Permite ocultar o mostrar la contrasena en la ventana de login
	 *
	 */
	private class CheckBoxShowHideActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(chckbxPasswordLogin.isSelected()) {
				
				pwdfContrasena.setEchoChar((char)0);
				chckbxPasswordLogin.setIcon(image_icon_show_password_login);
				
			}
			else {
				
				chckbxPasswordLogin.setIcon(image_icon_hide_password_login);
				pwdfContrasena.setEchoChar('*');
				
			}
			
		}
	}
	/**
	 * 
	 * Descripcion: Asociamos el comportamiento a los dos campos de introducir datos de la ventana Login 
	 *
	 */
	private class TxtVentanaInicioFocusListener extends FocusAdapter {
		
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
	 * Descripcion: Si el usuario se corresponde con su contrasena se podra acceder a la aplicacion
	 *
	 */
	private class PwdfPasswordActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				
			btnEntrar.setEnabled(true);
			
		}
	}
	/**
	 * 
	 * Descripcion: Cunado se introduzca el dato del nombre de usuario y se pulse intro se podran introducir los demas datos
	 *
	 */
	private class TxtUsuarioActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//Se activan la etiqueta y el campo de contrasena
			
			lblContrasena.setEnabled(true);
			pwdfContrasena.setEnabled(true);
			
			//Pasamos el foco (cursor) al campo contrasena
			
 			pwdfContrasena.requestFocus();
			
		}
	}		
	/**
	 * 
	 * 
	 * Descripcion: Oyente que al pulsar en el BtnRegistrarse permite acceder al Panel con un formulario de registro
	 * 
	 *
	 */
	private class BtnRegistrarseActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//Aparece un panel con el formulario registro
			
			frame_registro = new FormularioRegistro();
			
			//Para situarlo en el centro de la pantalla
			
			frame_registro.setLocationRelativeTo(null);
			frame_registro.setVisible(true);
			
		}
	}
	/**
	 * 
	 * Descripcion: Oyente que al pulsar en el BtnEntrar permite acceder al JFrame de la aplicacion principal
	 * 
	 *
	 */
	private class BtnEntrarActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int datos_sistema_usuario = -1;
			String datos_sistema_contrasena = null;
			
			if (txtUsuario.getText() != null) {
				
				datos_sistema_usuario = metodos_gestor_usuario_login.buscarUsuarioRegistrado(txtUsuario.getText().toString());
				
				if(datos_sistema_usuario == 0) {
					
					datos_sistema_contrasena = metodos_gestor_usuario_login.iniciarSesionSistema(txtUsuario.getText().toString());
					
					//Creamos al usuario que va a utilizar en estos momentos el sistema
					
					usuario_sistema = txtUsuario.getText();

					if(datos_sistema_contrasena.equals(String.valueOf(pwdfContrasena.getPassword()))) {

						dialogoExitoInicioSesion();
					
						//Se crea un frame con la aplicacion principal
					
						
						frame_principal = new AplicacionPrincipal();
						frame_principal.getJFrame().setVisible(true);
						
						//Se destruye la ventana actual (atributo a nivel de clase)
					
						frmVentanaDeLogin.dispose();
					}
					else {
						dialogoFalloInicioSesion();
					}
				}
				else {
					dialogoFalloInicioSesion();
				}
			}	
			else {
				dialogoFalloInicioSesion();
			}
		}

	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa de que el usuario ha iniciado sesion correctamente
	 * 
	 */
	private void dialogoExitoInicioSesion() {
		
		txtUsuario.setBorder(bordeVerde);
		pwdfContrasena.setBorder(bordeVerde);
		
		//Datos dialogo error datos ventana login
		
		JLabel labelDialogoInicioSesionExitoMensaje = new JLabel("La sesión ha sido iniciada correctamente.");
		labelDialogoInicioSesionExitoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoInicioSesionExitoMensaje, "Exito Inicio Sesión.", 1);
			
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa de que el nombre de usuario y la contrasena no coinciden
	 * 
	 */
	private void dialogoFalloInicioSesion() {
		
		txtUsuario.setBorder(bordeRojo);
		pwdfContrasena.setBorder(bordeRojo);
		
		//Datos dialogo error datos ventana login
		
		JLabel labelDialogoInicioSesionErrorMensaje = new JLabel("El nombre de usuario y la contraseña no coinciden.");
		labelDialogoInicioSesionErrorMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoInicioSesionErrorMensaje, "Fallo Inicio Sesión.", 0);
			
	}
	/**
	 * 
	 * Descripcion: metodo de inicializacion de la informacion del JFrame
	 * 
	 * 
	 */
	private void inicializarDatosFrameVentanaInicio() {
		
		//Datos frame
		
		frmVentanaDeLogin = new JFrame();
		frmVentanaDeLogin.setTitle(Messages.getString("VentanaInicio.frmVentanaDeLogin.title")); //$NON-NLS-1$ //$NON-NLS-1$
		frmVentanaDeLogin.setResizable(false);
		frmVentanaDeLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/recursos/iconoAplicacion.png")));
		frmVentanaDeLogin.setBounds(225, 225, 810, 287);
		frmVentanaDeLogin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmVentanaDeLogin.getContentPane().setLayout(null);
		
	}
	/**
	 * 
	 * Descripcion: metodo con el codigo que se genera en la parte de diseno al hacer el panel de registro
	 * 
	 */
	private void inicializarDatosPanelRegistroVentanaInicio() {
		
		//Datos del panel de registro
		
		JPanel panelRegistrarse = new JPanel();
		panelRegistrarse.setBackground(new Color(51, 51, 51));
		panelRegistrarse.setBounds(0, 0, 300, 259);
		frmVentanaDeLogin.getContentPane().add(panelRegistrarse);
		panelRegistrarse.setLayout(null);
		
		lblTituloCrearCuenta = new JLabel(Messages.getString("VentanaInicio.lblTituloCrearCuenta.text")); //$NON-NLS-1$ //$NON-NLS-1$
		lblTituloCrearCuenta.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTituloCrearCuenta.setForeground(new Color(255, 255, 255));
		lblTituloCrearCuenta.setBounds(new Rectangle(80, 65, 146, 47));
		panelRegistrarse.add(lblTituloCrearCuenta);
		
		lblTextoRegistro1 = new JLabel(Messages.getString("VentanaInicio.lblTextoRegistro1.text")); //$NON-NLS-1$ //$NON-NLS-1$
		lblTextoRegistro1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTextoRegistro1.setForeground(new Color(255, 255, 255));
		lblTextoRegistro1.setBounds(47, 111, 220, 31);
		panelRegistrarse.add(lblTextoRegistro1);

		btnRegistrase = new JButton("VentanaInicio.btnRegistrase.text"); //$NON-NLS-1$
		btnRegistrase.setText(Messages.getString("VentanaInicio.btnRegistrase.text")); //$NON-NLS-1$
		btnRegistrase.setFocusPainted(false);
		btnRegistrase.setFocusTraversalKeysEnabled(false);
		btnRegistrase.setFocusable(false);
		btnRegistrase.setBackground(new Color(255, 255, 255));
		btnRegistrase.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistrase.setForeground(new Color(51, 51, 51));
		btnRegistrase.setBounds(79, 163, 123, 29);
		panelRegistrarse.add(btnRegistrase);
		
	}
	/**
	 * 
	 * Descripcion: metodo con el codigo que se genera en la parte de diseno al hacer el panel de login
	 * 
	 * 
	 */
	private void inicializarDatosPanelLoginVentanaInicio() {
		
		//Datos del panel Login
		
		JPanel panelEntrar = new JPanel();
		panelEntrar.setBackground(new Color(255, 255, 255));
		panelEntrar.setBounds(299, 0, 507, 259);
		frmVentanaDeLogin.getContentPane().add(panelEntrar);
		panelEntrar.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(152, 92, 287, 31);
		panelEntrar.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdfContrasena = new JPasswordField();
		pwdfContrasena.setEnabled(false);
		pwdfContrasena.setBounds(152, 136, 287, 31);
		panelEntrar.add(pwdfContrasena);
		
		lblUsuario = new JLabel(Messages.getString("VentanaInicio.lblUsuario.text")); //$NON-NLS-1$ //$NON-NLS-1$
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(73, 99, 69, 13);
		panelEntrar.add(lblUsuario);
		
		lblContrasena = new JLabel(Messages.getString("VentanaInicio.lblContrasena.text")); //$NON-NLS-1$ //$NON-NLS-1$
		lblContrasena.setEnabled(false);
		lblContrasena.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblContrasena.setBounds(50, 137, 95, 24);
		panelEntrar.add(lblContrasena);
		
		lblTituloVentana = new JLabel(Messages.getString("VentanaInicio.lblTituloVentana.text")); //$NON-NLS-1$ //$NON-NLS-1$
		lblTituloVentana.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTituloVentana.setBounds(30, 8, 70, 31);
		panelEntrar.add(lblTituloVentana);
		
		lblTexto = new JLabel(Messages.getString("VentanaInicio.lblTexto.text")); //$NON-NLS-1$ //$NON-NLS-1$
		lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTexto.setBounds(31, 42, 389, 25);
		panelEntrar.add(lblTexto);
		
		btnEntrar = new JButton("VentanaInicio.btnEntrar.text"); //$NON-NLS-1$
		btnEntrar.setText(Messages.getString("VentanaInicio.btnEntrar.text")); //$NON-NLS-1$
		btnEntrar.setEnabled(false);
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(51, 51, 51));
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEntrar.setBounds(355, 192, 84, 31);
		panelEntrar.add(btnEntrar);
		
		chckbxPasswordLogin = new JCheckBox(Messages.getString("VentanaInicio.chckbxPasswordLogin.text")); //$NON-NLS-1$
		chckbxPasswordLogin.setIcon(new ImageIcon(VentanaInicio.class.getResource("/recursos/hide_eye.png")));
		chckbxPasswordLogin.setBackground(new Color(255, 255, 255));
		chckbxPasswordLogin.setBounds(445, 144, 35, 13);
		panelEntrar.add(chckbxPasswordLogin);
		
		btnIdiomaAplicacion = new JButton(Messages.getString("VentanaInicio.btnIdiomaAplicacion.text")); //$NON-NLS-1$
		btnIdiomaAplicacion.setFocusPainted(false);
		btnIdiomaAplicacion.setFocusable(false);
		btnIdiomaAplicacion.setFocusTraversalKeysEnabled(false);
		btnIdiomaAplicacion.setIcon(new ImageIcon(VentanaInicio.class.getResource("/recursos/translation.png")));
		btnIdiomaAplicacion.setBorder(null);
		btnIdiomaAplicacion.setBackground(new Color(255, 255, 255));
		btnIdiomaAplicacion.setBounds(401, 27, 56, 31);
		panelEntrar.add(btnIdiomaAplicacion);
			
	}

	public Window getJFrameVentanaInicio() {
		
		return this.frmVentanaDeLogin;
	}
}
