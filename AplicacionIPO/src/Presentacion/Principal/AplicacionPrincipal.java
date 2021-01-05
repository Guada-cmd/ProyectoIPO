package Presentacion.Principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;

import Presentacion.InicioSesion.VentanaInicio;
import Presentacion.rutas.MiPanelGestorRutas;
import Presentacion.rutas.MiPanelRutasSenderistas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Dominio.Perfil;
import Dominio.Usuario;
import Persistencia.gestorPerfil;
import Persistencia.gestorUsuario;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

public class AplicacionPrincipal {

	private JFrame frmAplicacinPrincipalDe;
	private JMenuBar menuBarAplicacionPrincipal;
	private JMenu mUsuario;
	private JMenuItem miUsuario;
	private JSeparator separatorUA;
	private JMenuItem miConfiguracion;
	private JMenuItem miCerrarSesion;
	private JPanel pnlContenidoAplicacionPrincipal;
	private JPanel pnlBotones;
	private JPanel pnlReservas;
	private JButton btnReservas;
	private JButton btnActividades;
	private JPanel pnlActividades;
	private JPanel pnlUsuario;
	private JPanel pnlGestorConfiguracion;
	private JButton btnRutas;
	private JPanel pnlRutas;
	private JTextArea MarcadorActividades;
	private JTextArea MarcadorReservas;
	private JTextArea MarcadorRutas;
	private JMenu mAyuda;
	private JMenuItem miManual;
	private JButton btnEditarActividad;
	private JButton btnCrearRuta;
	
	//Variable para cerrar sesion
	
	private VentanaInicio frame_ventana_inicio;
	
	//Variable para abrir manual
	
	private ManualAyuda frame_ayuda_usuario = new ManualAyuda();
	
	//Para la base de datos
	
	private gestorUsuario metodos_gestor_usuario = new gestorUsuario();
	private gestorPerfil metodos_gestor_perfil = new gestorPerfil();
	
	//Objeto atributo que permite guardar los datos del usuario que actualmente esta en el sistema
	
	private Usuario usuario_actual;
	
	//Objeto con los datos del perfil de usuario que se inicializaron por defecto
	
	private Perfil perfil_usuario;
	private JButton btnParcelas;
	private JButton btnCabanas;
	private JButton btnExplorarReservas;
	
	private GridBagConstraints gbc_btnReservas = new GridBagConstraints();
	private GridBagConstraints gbc_btnCabanas = new GridBagConstraints();
	private GridBagConstraints gbc_btnParcelas = new GridBagConstraints();
	private GridBagConstraints gbc_btnExplorarReservas = new GridBagConstraints();
	
	private GridBagConstraints gbc_btnActividades = new GridBagConstraints();
	private GridBagConstraints gbc_btnEditarActividad = new GridBagConstraints();
	
	private GridBagConstraints gbc_btnCrearRuta = new GridBagConstraints();
	private GridBagConstraints gbc_btnRutas = new GridBagConstraints();
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionPrincipal window = new AplicacionPrincipal();
					window.frmAplicacinPrincipalDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacionPrincipal() {
		
		initialize();
		
		centrarAplicacionPrincipal();
		
		
	}
	/**
	 * 
	 * Descripcion: Metodo para centrar la aplicacion principal
	 * 
	 */
	private void centrarAplicacionPrincipal() {
		
		this.getJFrame().setLocationRelativeTo(null);
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		inicializarDatosAplicacionPrincipal();
		
		//Inicializacion del Panel Principal de la aplicacion
		
		inicializarPanelPrincipal();
		
		//Inicializacion del Panel con los botones que permiten navegar en la aplicacion
		
		inicializarPanelBotones();
		
		//Inicializacion de la barra de menu y sus items
		
		inicializarDatosBarraMenuAplicacionPrincipal();
		
		//Cerrar Aplicacion
		
		cerrarAplicacionPrincipal();
		
		//Oyentes de la aplicacion principal
		
		asociacionOyentesAplicacionPrincipal();
		
	}
	/**
	 * 
	 * Descripcion: metodo con los oyentes de la aplicacion principal
	 * 
	 */
	private void asociacionOyentesAplicacionPrincipal() {
		
		btnReservas.addActionListener(new NavegacionPanelesActionListener());
		btnActividades.addActionListener(new NavegacionPanelesActionListener());
		btnRutas.addActionListener(new NavegacionPanelesActionListener());
		
		miUsuario.addActionListener(new NavegacionPanelesActionListener());
		miConfiguracion.addActionListener(new NavegacionPanelesActionListener());
		miCerrarSesion.addActionListener(new CerrarSesionActionListener());
		miManual.addActionListener(new AbrirManualAyudaActionListener());
		
		btnReservas.addActionListener(new MarcadorUbicacionActionListener());
		btnActividades.addActionListener(new MarcadorUbicacionActionListener());
		btnRutas.addActionListener(new MarcadorUbicacionActionListener());
	
	}
	/**
	 * 
	 * Descripcion: Permite indicar en que panel estas
	 *
	 */
	private class MarcadorUbicacionActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnReservas) {
				
						
				colocarLayout(0);
							
				//MarcadorReservas.setVisible(true);
				//MarcadorActividades.setVisible(false);
				//MarcadorRutas.setVisible(false);
			}
			else if (e.getSource() == btnActividades) {
				
				//MarcadorReservas.setVisible(false);
				//MarcadorActividades.setVisible(true);
				//MarcadorRutas.setVisible(false);
				
				btnParcelas.setVisible(false);
				btnCabanas.setVisible(false);
				btnExplorarReservas.setVisible(false);
				
				colocarLayout(1);
				
			}
			else if (e.getSource() == btnRutas) {
				
				//MarcadorReservas.setVisible(false);
				//MarcadorActividades.setVisible(false);
				//MarcadorRutas.setVisible(true);
				
				
				colocarLayout(2);
			}
		}
	}
	private void colocarLayout(int var) {
		
		switch(var) {
		
			case 0:
				
				btnParcelas.setVisible(true);
				btnCabanas.setVisible(true);
				btnExplorarReservas.setVisible(true);
				btnEditarActividad.setVisible(false);
				btnCrearRuta.setVisible(false);
				
				//Colocar Layout reservas
				
				gbc_btnReservas.gridwidth = 2;
				gbc_btnReservas.gridx = 1;
				gbc_btnReservas.gridy = 1;
				pnlBotones.add(btnReservas, gbc_btnReservas);
						
				gbc_btnActividades.gridwidth = 2;
				gbc_btnActividades.gridx = 1;
				gbc_btnActividades.gridy = 5;
				pnlBotones.add(btnActividades, gbc_btnActividades);
				
				gbc_btnRutas.gridwidth = 2;
				gbc_btnRutas.gridx = 1;
				gbc_btnRutas.gridy = 6;
				pnlBotones.add(btnRutas, gbc_btnRutas);
				
				//Rama reservas
				
				gbc_btnCabanas.gridwidth = 2;
				gbc_btnCabanas.gridx = 1;
				gbc_btnCabanas.gridy = 2;
				pnlBotones.add(btnCabanas, gbc_btnCabanas);
				
				gbc_btnParcelas.gridwidth = 2;
				gbc_btnParcelas.gridx = 1;
				gbc_btnParcelas.gridy = 3;
				pnlBotones.add(btnParcelas, gbc_btnParcelas);
				
				gbc_btnExplorarReservas.gridwidth = 2;
				gbc_btnExplorarReservas.gridx = 1;
				gbc_btnExplorarReservas.gridy = 4;
				pnlBotones.add(btnExplorarReservas, gbc_btnExplorarReservas);
				
				//Rama actividades
				
				gbc_btnEditarActividad.gridwidth = 2;
				gbc_btnEditarActividad.gridx = 1;
				gbc_btnEditarActividad.gridy = 7;
				pnlBotones.add(btnEditarActividad, gbc_btnEditarActividad);
				
				//Rama ruta
				
				gbc_btnCrearRuta.gridwidth = 2;
				gbc_btnCrearRuta.gridx = 1;
				gbc_btnCrearRuta.gridy = 8;
				pnlBotones.add(btnCrearRuta, gbc_btnCrearRuta);
				
				break;
				
			case 1:
				
				btnParcelas.setVisible(false);
				btnCabanas.setVisible(false);
				btnExplorarReservas.setVisible(false);
				btnEditarActividad.setVisible(true);
				btnCrearRuta.setVisible(false);
				
				//Colocar Layout reservas
				
				gbc_btnReservas.gridwidth = 2;
				gbc_btnReservas.gridx = 1;
				gbc_btnReservas.gridy = 1;
				pnlBotones.add(btnReservas, gbc_btnReservas);
						
				gbc_btnActividades.gridwidth = 2;
				gbc_btnActividades.gridx = 1;
				gbc_btnActividades.gridy = 2;
				pnlBotones.add(btnActividades, gbc_btnActividades);
				
				gbc_btnRutas.gridwidth = 2;
				gbc_btnRutas.gridx = 1;
				gbc_btnRutas.gridy = 4;
				pnlBotones.add(btnRutas, gbc_btnRutas);
				
				//Rama reservas
				
				gbc_btnCabanas.gridwidth = 2;
				gbc_btnCabanas.gridx = 1;
				gbc_btnCabanas.gridy = 6;
				pnlBotones.add(btnCabanas, gbc_btnCabanas);
				
				gbc_btnParcelas.gridwidth = 2;
				gbc_btnParcelas.gridx = 1;
				gbc_btnParcelas.gridy = 7;
				pnlBotones.add(btnParcelas, gbc_btnParcelas);
				
				gbc_btnExplorarReservas.gridwidth = 2;
				gbc_btnExplorarReservas.gridx = 1;
				gbc_btnExplorarReservas.gridy = 8;
				pnlBotones.add(btnExplorarReservas, gbc_btnExplorarReservas);
				
				//Rama actividades
				
				gbc_btnEditarActividad.gridwidth = 2;
				gbc_btnEditarActividad.gridx = 1;
				gbc_btnEditarActividad.gridy = 3;
				pnlBotones.add(btnEditarActividad, gbc_btnEditarActividad);
				
				//Rama ruta
				
				gbc_btnCrearRuta.gridwidth = 2;
				gbc_btnCrearRuta.gridx = 1;
				gbc_btnCrearRuta.gridy = 5;
				pnlBotones.add(btnCrearRuta, gbc_btnCrearRuta);
				
				break;
				
			case 2:
				
				btnParcelas.setVisible(false);
				btnCabanas.setVisible(false);
				btnExplorarReservas.setVisible(false);
				btnEditarActividad.setVisible(false);
				btnCrearRuta.setVisible(true);
				
				//Colocar Layout reservas
				
				gbc_btnReservas.gridwidth = 2;
				gbc_btnReservas.gridx = 1;
				gbc_btnReservas.gridy = 1;
				pnlBotones.add(btnReservas, gbc_btnReservas);
						
				gbc_btnActividades.gridwidth = 2;
				gbc_btnActividades.gridx = 1;
				gbc_btnActividades.gridy = 2;
				pnlBotones.add(btnActividades, gbc_btnActividades);
				
				gbc_btnRutas.gridwidth = 2;
				gbc_btnRutas.gridx = 1;
				gbc_btnRutas.gridy = 3;
				pnlBotones.add(btnRutas, gbc_btnRutas);
				
				//Rama reservas
				
				gbc_btnCabanas.gridwidth = 2;
				gbc_btnCabanas.gridx = 1;
				gbc_btnCabanas.gridy = 6;
				pnlBotones.add(btnCabanas, gbc_btnCabanas);
				
				gbc_btnParcelas.gridwidth = 2;
				gbc_btnParcelas.gridx = 1;
				gbc_btnParcelas.gridy = 7;
				pnlBotones.add(btnParcelas, gbc_btnParcelas);
				
				gbc_btnExplorarReservas.gridwidth = 2;
				gbc_btnExplorarReservas.gridx = 1;
				gbc_btnExplorarReservas.gridy = 8;
				pnlBotones.add(btnExplorarReservas, gbc_btnExplorarReservas);
				
				//Rama actividades
				
				gbc_btnEditarActividad.gridwidth = 2;
				gbc_btnEditarActividad.gridx = 1;
				gbc_btnEditarActividad.gridy = 5;
				pnlBotones.add(btnEditarActividad, gbc_btnEditarActividad);
				
				//Rama ruta
				
				gbc_btnCrearRuta.gridwidth = 2;
				gbc_btnCrearRuta.gridx = 1;
				gbc_btnCrearRuta.gridy = 4;
				pnlBotones.add(btnCrearRuta, gbc_btnCrearRuta);
				
				break;
			
		}
		
		
	}
	/**
	 * 
	 * Descripcion: Permite cerrar la aplicacion
	 * 
	 */
	private void cerrarAplicacionPrincipal() {
		
		
		try {
			getJFrame().setDefaultCloseOperation(getJFrame().DO_NOTHING_ON_CLOSE);
			getJFrame().addWindowListener(new cerrarAplicacionPrincipalWindowAdapter());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	/**
	 * 
	 * Descripcion: Permite cerrar la aplicacion al pulsar la cruz
	 *
	 */
	private class cerrarAplicacionPrincipalWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			
			frame_ventana_inicio = new VentanaInicio();
			int confirmar_cerrar_aplicacion = dialogoCerrarAplicacionPrincipal();
			
			if (confirmar_cerrar_aplicacion == 0) {
				getJFrame().dispose();
				frame_ventana_inicio.getJFrameVentanaInicio().setVisible(true);
			}
			
		}
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrar la aplicacion principal
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra cerrar la aplicacion
	 */
	private int dialogoCerrarAplicacionPrincipal() {
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarAplicacionMensaje = new JLabel("¿Está seguro que desea cerrar la aplicacion?");
		labelDialogoCerrarAplicacionMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		return JOptionPane.showOptionDialog(getJFrame(), labelDialogoCerrarAplicacionMensaje, "Aviso de cierre aplicacion principal.", 0, 1, null, botones_list, null);
	
	}
	/**
	 * 
	 * Descripcion: Permite abrir el manual ayuda
	 *
	 */
	private class AbrirManualAyudaActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			frame_ayuda_usuario.getJFrameManualAyuda().setVisible(true);
		
		}
	}
	/**
	 * 
	 * Descripcion: Permite cerrar sesion y volver a la pantalla de Login
	 *
	 */
	private class CerrarSesionActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			frame_ventana_inicio = new VentanaInicio();
			int opcion_cerrar_sesion = -1;
			
			opcion_cerrar_sesion = dialogoCerrarSesion();
			
			if(opcion_cerrar_sesion == 0) {
				getJFrame().dispose();
				frame_ventana_inicio.getJFrameVentanaInicio().setVisible(true);
			}
		
		}
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrar la sesion
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra cerrar sesion
	 */
	private int dialogoCerrarSesion() {
		
		//Mensaje de cerrar sesion
		
		JLabel labelDialogoCerrarSesionMensaje = new JLabel("¿Está seguro que desea cerrar sesión?");
		labelDialogoCerrarSesionMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		return JOptionPane.showOptionDialog(getJFrame(), labelDialogoCerrarSesionMensaje, "Cerrar Sesión.", 0, 1, null, botones_list, null);
	
	}
	/**
	 * 
	 * Descripcion: Permite navegar entre los paneles al pulsar un boton
	 *
	 */
	private class NavegacionPanelesActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			CardLayout cardLayoutPanel = (CardLayout)(pnlContenidoAplicacionPrincipal.getLayout());
			pnlContenidoAplicacionPrincipal.setVisible(true);
			cardLayoutPanel.show(pnlContenidoAplicacionPrincipal, e.getActionCommand());
			
			
			if(e.getSource() == miUsuario || e.getSource() == miConfiguracion || e.getSource() == miCerrarSesion || e.getSource() == miManual) {
				
				MarcadorReservas.setVisible(false);
				MarcadorActividades.setVisible(false);
				MarcadorRutas.setVisible(false);
				
				
				//METODO QUE CON SET ACTUALIZA LOS DATOS
				
				
				
			}
		}
	}
	private void inicializarDatosUsuarioBD() {
		
		if(VentanaInicio.usuario_sistema != null) {
			
			String nombre_usuarioDB = VentanaInicio.usuario_sistema;
			String nombreDB = metodos_gestor_usuario.buscarDatoUsuario("Nombre",  VentanaInicio.usuario_sistema);
			String apellidoDB = metodos_gestor_usuario.buscarDatoUsuario("Apellidos",  VentanaInicio.usuario_sistema);
			String telefonoDB = metodos_gestor_usuario.buscarDatoUsuario("Telefono",  VentanaInicio.usuario_sistema);
			String correo_electronicoDB = metodos_gestor_usuario.buscarDatoUsuario("Correo",  VentanaInicio.usuario_sistema);
			
			usuario_actual = new Usuario (nombre_usuarioDB, nombreDB, apellidoDB, telefonoDB, correo_electronicoDB);
			
			String nombre_usuario_perfilDB = nombre_usuarioDB;
			String idiomasDB = metodos_gestor_perfil.buscarDatoPerfilUsuario("Idiomas", VentanaInicio.usuario_sistema);
			String disponibilidadDB = metodos_gestor_perfil.buscarDatoPerfilUsuario("Disponibilidad", VentanaInicio.usuario_sistema);
			String formacion = metodos_gestor_perfil.buscarDatoPerfilUsuario("Formacion", VentanaInicio.usuario_sistema);
			
			perfil_usuario = new Perfil (nombre_usuario_perfilDB, idiomasDB, disponibilidadDB, formacion);
			
			pnlUsuario = new MiPanelUsuario(usuario_actual, perfil_usuario);
			pnlContenidoAplicacionPrincipal.add(pnlUsuario, "Perfil");
			
		}
	
	}
	/**
	 * 
	 * Descripcion: Datos generados en la parte de disenio para inicializar la aplicacion
	 * 
	 */
	private void inicializarDatosAplicacionPrincipal() {
		
		frmAplicacinPrincipalDe = new JFrame();
		frmAplicacinPrincipalDe.setTitle("Aplicación principal.");
		frmAplicacinPrincipalDe.setResizable(false);
		frmAplicacinPrincipalDe.setIconImage(Toolkit.getDefaultToolkit().getImage(AplicacionPrincipal.class.getResource("/recursos/logo_aplicacion.png")));
		frmAplicacinPrincipalDe.setVisible(true);
		frmAplicacinPrincipalDe.setBounds(new Rectangle(100, 100, 960, 540));
		frmAplicacinPrincipalDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAplicacinPrincipalDe.getContentPane().setLayout(new BorderLayout(0, 0));
		
	}
	/**
	 * 
	 * Descripcion: Metodo que inicializa el panel principal de la aplicacion y sus sub paneles
	 * 
	 */
	private void inicializarPanelPrincipal() {
		
		//Panel Principal de la aplicacion
		
		pnlContenidoAplicacionPrincipal = new JPanel();
		frmAplicacinPrincipalDe.getContentPane().add(pnlContenidoAplicacionPrincipal, BorderLayout.CENTER);
		pnlContenidoAplicacionPrincipal.setLayout(new CardLayout(0, 0));
		
		//Panel que da acceso a las reservas
		
		pnlReservas = new MiPanelReservas();
		pnlContenidoAplicacionPrincipal.add(pnlReservas, "Reservas");
		
		//Panel que da acceso a las actividades
		
		pnlActividades = new MiPanelGestorRutas();
		pnlContenidoAplicacionPrincipal.add(pnlActividades, "Actividades");
		
		//Panel que da acceso a la informacion del usuario
		
		inicializarDatosUsuarioBD();
		
		
		//Panel que da acceso al gestor de la configuracion para editar la informacion
		
		pnlGestorConfiguracion = new MiPanelGestorConfiguracion();
		pnlContenidoAplicacionPrincipal.add(pnlGestorConfiguracion, "Configuración");
		
		pnlRutas = new MiPanelGestorRutas();
		pnlContenidoAplicacionPrincipal.add(pnlRutas, "Rutas");
		
	}
	/**
	 * 
	 * Descripcion: Panel que permite navegar entre los distintos paneles de la aplicacion
	 * 
	 */
	private void inicializarPanelBotones() {
		
		//Panel que contiene los botones
		
		pnlBotones = new JPanel();
		pnlBotones.setFont(new Font("Segoe UI", Font.BOLD, 14));
		frmAplicacinPrincipalDe.getContentPane().add(pnlBotones, BorderLayout.WEST);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[]{9, 85, 21, 0};
		gbl_pnlBotones.rowHeights = new int[]{51, 36, 34, 38, 32, 33, 36, 40, 32, 0, 0};
		gbl_pnlBotones.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBotones.setLayout(gbl_pnlBotones);
		
		pnlBotones.setBackground(new Color(51, 51, 51));
		
		MarcadorReservas = new JTextArea();
		MarcadorReservas.setFocusable(false);
		MarcadorReservas.setFocusTraversalKeysEnabled(false);
		MarcadorReservas.setEditable(false);
		GridBagConstraints gbc_MarcadorReservas = new GridBagConstraints();
		gbc_MarcadorReservas.insets = new Insets(0, 0, 5, 5);
		gbc_MarcadorReservas.fill = GridBagConstraints.BOTH;
		gbc_MarcadorReservas.gridx = 0;
		gbc_MarcadorReservas.gridy = 1;
		pnlBotones.add(MarcadorReservas, gbc_MarcadorReservas);

		
		//Boton Reservas
		
		btnReservas = new JButton("Reservas");
		btnReservas.setFocusable(false);
		btnReservas.setFocusTraversalKeysEnabled(false);
		btnReservas.setFocusPainted(false);

		btnReservas.setBorder(null);
		btnReservas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnReservas.setBackground(new Color(51, 51, 51));
		btnReservas.setForeground(new Color(255, 255, 255));
		
		gbc_btnReservas.gridwidth = 2;
		gbc_btnReservas.anchor = GridBagConstraints.WEST;
		gbc_btnReservas.insets = new Insets(0, 0, 5, 0);
		gbc_btnReservas.fill = GridBagConstraints.VERTICAL;
		gbc_btnReservas.gridx = 1;
		gbc_btnReservas.gridy = 1;
		pnlBotones.add(btnReservas, gbc_btnReservas);
		
		MarcadorActividades = new JTextArea();
		MarcadorActividades.setVisible(false);
		MarcadorActividades.setEditable(false);
		MarcadorActividades.setFocusTraversalKeysEnabled(false);
		MarcadorActividades.setFocusable(false);
		GridBagConstraints gbc_MarcadorActividades = new GridBagConstraints();
		gbc_MarcadorActividades.insets = new Insets(0, 0, 5, 5);
		gbc_MarcadorActividades.fill = GridBagConstraints.BOTH;
		gbc_MarcadorActividades.gridx = 0;
		gbc_MarcadorActividades.gridy = 2;
		pnlBotones.add(MarcadorActividades, gbc_MarcadorActividades);
		
		MarcadorRutas = new JTextArea();
		MarcadorRutas.setVisible(false);
		
		btnParcelas = new JButton("Parcelas");
		btnParcelas.setVisible(false);
		btnParcelas.setForeground(Color.WHITE);
		btnParcelas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnParcelas.setFocusable(false);
		btnParcelas.setFocusTraversalKeysEnabled(false);
		btnParcelas.setFocusPainted(false);
		btnParcelas.setBorder(null);
		btnParcelas.setBackground(new Color(51, 51, 51));
		
		gbc_btnParcelas.anchor = GridBagConstraints.WEST;
		gbc_btnParcelas.insets = new Insets(0, 0, 5, 5);
		gbc_btnParcelas.gridx = 1;
		gbc_btnParcelas.gridy = 4;
		pnlBotones.add(btnParcelas, gbc_btnParcelas);
		
		MarcadorRutas.setFocusable(false);
		MarcadorRutas.setFocusTraversalKeysEnabled(false);
		MarcadorRutas.setEditable(false);
		GridBagConstraints gbc_MarcadorRutas = new GridBagConstraints();
		gbc_MarcadorRutas.insets = new Insets(0, 0, 5, 5);
		gbc_MarcadorRutas.fill = GridBagConstraints.BOTH;
		gbc_MarcadorRutas.gridx = 0;
		gbc_MarcadorRutas.gridy = 3;
		pnlBotones.add(MarcadorRutas, gbc_MarcadorRutas);
		
		btnCabanas = new JButton("Cabañas");
		btnCabanas.setVisible(false);
		btnCabanas.setForeground(Color.WHITE);
		btnCabanas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCabanas.setFocusable(false);
		btnCabanas.setFocusTraversalKeysEnabled(false);
		btnCabanas.setFocusPainted(false);
		btnCabanas.setBorder(null);
		btnCabanas.setBackground(new Color(51, 51, 51));
		
		gbc_btnCabanas.anchor = GridBagConstraints.WEST;
		gbc_btnCabanas.insets = new Insets(0, 0, 5, 5);
		gbc_btnCabanas.gridx = 1;
		gbc_btnCabanas.gridy = 5;
		pnlBotones.add(btnCabanas, gbc_btnCabanas);
		
		btnExplorarReservas = new JButton("Mis reservas");
		btnExplorarReservas.setVisible(false);
		btnExplorarReservas.setForeground(Color.WHITE);
		btnExplorarReservas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnExplorarReservas.setFocusable(false);
		btnExplorarReservas.setFocusTraversalKeysEnabled(false);
		btnExplorarReservas.setFocusPainted(false);
		btnExplorarReservas.setBorder(null);
		btnExplorarReservas.setBackground(new Color(51, 51, 51));
		
		gbc_btnExplorarReservas.anchor = GridBagConstraints.WEST;
		gbc_btnExplorarReservas.insets = new Insets(0, 0, 5, 5);
		gbc_btnExplorarReservas.gridx = 1;
		gbc_btnExplorarReservas.gridy = 6;
		pnlBotones.add(btnExplorarReservas, gbc_btnExplorarReservas);
		
		//Boton Actividades
		
		btnActividades = new JButton("Actividades");
		btnActividades.setFocusPainted(false);
		btnActividades.setFocusTraversalKeysEnabled(false);
		btnActividades.setFocusable(false);
		btnActividades.setBorder(null);
		btnActividades.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnActividades.setBackground(new Color(51, 51, 51));
		btnActividades.setForeground(new Color(255, 255, 255));
		
		gbc_btnActividades.gridwidth = 2;
		gbc_btnActividades.anchor = GridBagConstraints.WEST;
		gbc_btnActividades.insets = new Insets(0, 0, 5, 0);
		gbc_btnActividades.fill = GridBagConstraints.VERTICAL;
		gbc_btnActividades.gridx = 1;
		gbc_btnActividades.gridy = 2;
		pnlBotones.add(btnActividades, gbc_btnActividades);
		
		btnEditarActividad = new JButton("Editar Act.");
		btnEditarActividad.setVisible(false);
		btnEditarActividad.setForeground(Color.WHITE);
		btnEditarActividad.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEditarActividad.setFocusable(false);
		btnEditarActividad.setFocusTraversalKeysEnabled(false);
		btnEditarActividad.setFocusPainted(false);
		btnEditarActividad.setBorder(null);
		btnEditarActividad.setBackground(new Color(51, 51, 51));
				
		gbc_btnEditarActividad.gridwidth = 2;
		gbc_btnEditarActividad.anchor = GridBagConstraints.WEST;
		gbc_btnEditarActividad.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditarActividad.gridx = 1;
		gbc_btnEditarActividad.gridy = 7;
		pnlBotones.add(btnEditarActividad, gbc_btnEditarActividad);
		
		btnRutas = new JButton("Rutas");
		btnRutas.setFocusable(false);
		btnRutas.setFocusTraversalKeysEnabled(false);
		btnRutas.setFocusPainted(false);
		
		btnRutas.setBorder(null);
		btnRutas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRutas.setBackground(new Color(51, 51, 51));
		btnRutas.setForeground(new Color(255, 255, 255));
		
		gbc_btnRutas.gridwidth = 2;
		gbc_btnRutas.anchor = GridBagConstraints.WEST;
		gbc_btnRutas.insets = new Insets(0, 0, 5, 0);
		gbc_btnRutas.gridx = 1;
		gbc_btnRutas.gridy = 3;
		pnlBotones.add(btnRutas, gbc_btnRutas);
		
		btnCrearRuta = new JButton("Crear Ruta");
		btnCrearRuta.setVisible(false);
		btnCrearRuta.setForeground(Color.WHITE);
		btnCrearRuta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCrearRuta.setFocusable(false);
		btnCrearRuta.setFocusTraversalKeysEnabled(false);
		btnCrearRuta.setFocusPainted(false);
		btnCrearRuta.setBorder(null);
		btnCrearRuta.setBackground(new Color(51, 51, 51));
		
		gbc_btnCrearRuta.anchor = GridBagConstraints.WEST;
		gbc_btnCrearRuta.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearRuta.gridx = 1;
		gbc_btnCrearRuta.gridy = 8;
		pnlBotones.add(btnCrearRuta, gbc_btnCrearRuta);
		
	
	}
	/**
	 * 
	 * Descripcion: Metodo con los datos generados en la parte de disenio que permiten inicializar la barra de menu y sus items
	 * 
	 */
	private void inicializarDatosBarraMenuAplicacionPrincipal() {
		
		//Datos barra de menu
		
		menuBarAplicacionPrincipal = new JMenuBar();
		menuBarAplicacionPrincipal.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		frmAplicacinPrincipalDe.setJMenuBar(menuBarAplicacionPrincipal);
		
		//Menu Usuario
		
		mUsuario = new JMenu("");
		mUsuario.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/recursos/profile-user.png")));
		menuBarAplicacionPrincipal.add(mUsuario);
		
		//Item Usuario
		
		miUsuario = new JMenuItem("Perfil");
		miUsuario.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/recursos/perfil.png")));
		mUsuario.add(miUsuario);
		
		//Separador entre usuario y el item about
		
		separatorUA = new JSeparator();
		mUsuario.add(separatorUA);
		
		//Item configuracion
		
		miConfiguracion = new JMenuItem("Configuración");
		miConfiguracion.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/recursos/settings.png")));
		mUsuario.add(miConfiguracion);
		
		//Item cerrar sesion

		miCerrarSesion = new JMenuItem("Cerrar sesion");
		miCerrarSesion.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/recursos/logout.png")));
		mUsuario.add(miCerrarSesion);
		
		//Menu ayuda
		
		mAyuda = new JMenu("");
		mAyuda.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/recursos/information.png")));
		menuBarAplicacionPrincipal.add(mAyuda);
		
		//Item manual
		
		miManual = new JMenuItem("Manual");
		miManual.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/recursos/big-manual-book.png")));
		mAyuda.add(miManual);
		
	}
	/**
	 * 
	 * Descripcion: Metodo get para poder obtener el frame de la aplicacion principal porque estamos trabajando con un Application Window
	 * 
	 * @return frame de la aplicacion principal
	 */
	public JFrame getJFrame() {
		
		return this.frmAplicacinPrincipalDe;
		
	}
}
