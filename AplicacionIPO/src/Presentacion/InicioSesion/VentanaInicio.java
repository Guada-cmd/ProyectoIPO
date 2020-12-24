package Presentacion.InicioSesion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Presentacion.Principal.AplicacionPrincipal;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

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
	private JLabel lblTextoRegistro2;
	private JButton btnRegistrase;
	private JCheckBox chckbxPasswordLogin;
	
	private AplicacionPrincipal frame_principal;
	private FormularioRegistro frame_registro;
	
	//Creaccion de dos atributos privados a nivel de clase
	
	private Color colorBlanco = new Color (255,255,255);
	private Color colorResaltado = new Color (255,255,210);
	
	
	private ImageIcon image_icon_show_password_login = new ImageIcon(FormularioRegistro.class.getResource("/recursos/eye.png"));
	private ImageIcon image_icon_hide_password_login = new ImageIcon(FormularioRegistro.class.getResource("/recursos/hide_eye.png"));

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
		
		//Se puede cambiar luego
		
		inicializarDatosFrameVentanaInicio();
		inicializarDatosPanelRegistroVentanaInicio();
		inicializarDatosPanelLoginVentanaInicio();
		
		asociacionOyentes();
	
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
			
			//TO DO
			
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
			
			//Se crea un frame con la aplicacion principal
			frame_principal = new AplicacionPrincipal();
			frame_principal.getJFrame().setVisible(true);
			
			//Se destruye la ventana actual (atributo a nivel de clase)
			frmVentanaDeLogin.dispose();
			
		}
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
		frmVentanaDeLogin.setTitle("Ventana de Login");
		frmVentanaDeLogin.setResizable(false);
		frmVentanaDeLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/recursos/logo_aplicacion.png")));
		frmVentanaDeLogin.setBounds(225, 225, 798, 287);
		frmVentanaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		lblTituloCrearCuenta = new JLabel("Crea una cuenta");
		lblTituloCrearCuenta.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTituloCrearCuenta.setForeground(new Color(255, 255, 255));
		lblTituloCrearCuenta.setBounds(new Rectangle(70, 50, 146, 47));
		panelRegistrarse.add(lblTituloCrearCuenta);
		
		lblTextoRegistro1 = new JLabel("Si todavía no tienes una cuenta");
		lblTextoRegistro1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTextoRegistro1.setForeground(new Color(255, 255, 255));
		lblTextoRegistro1.setBounds(45, 92, 220, 31);
		panelRegistrarse.add(lblTextoRegistro1);
		
		lblTextoRegistro2 = new JLabel("puedes crearla aquí");
		lblTextoRegistro2.setForeground(Color.WHITE);
		lblTextoRegistro2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTextoRegistro2.setBounds(80, 122, 220, 31);
		panelRegistrarse.add(lblTextoRegistro2);

		btnRegistrase = new JButton("Registrarse");
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
		panelEntrar.setBounds(299, 0, 499, 259);
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
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(73, 99, 69, 13);
		panelEntrar.add(lblUsuario);
		
		lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setEnabled(false);
		lblContrasena.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblContrasena.setBounds(50, 137, 95, 24);
		panelEntrar.add(lblContrasena);
		
		lblTituloVentana = new JLabel("Login");
		lblTituloVentana.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTituloVentana.setBounds(30, 8, 70, 31);
		panelEntrar.add(lblTituloVentana);
		
		lblTexto = new JLabel("Bienvenido/a a la aplicación de reservas");
		lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTexto.setBounds(31, 42, 389, 25);
		panelEntrar.add(lblTexto);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setEnabled(false);
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(51, 51, 51));
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEntrar.setBounds(355, 192, 84, 31);
		panelEntrar.add(btnEntrar);
		
		chckbxPasswordLogin = new JCheckBox("");
		chckbxPasswordLogin.setIcon(new ImageIcon(VentanaInicio.class.getResource("/recursos/hide_eye.png")));
		chckbxPasswordLogin.setBackground(new Color(255, 255, 255));
		chckbxPasswordLogin.setBounds(445, 144, 35, 13);
		panelEntrar.add(chckbxPasswordLogin);
			
	}
}
