package Presentacion.Principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;

import Presentacion.rutas.MiPanelRutasSenderistas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AplicacionPrincipal {

	private JFrame frame;
	private JMenuBar menuBarAplicacionPrincipal;
	private JMenu mUsuario;
	private JMenuItem miUsuario;
	private JSeparator separatorUA;
	private JMenuItem miAbout;
	private JSeparator separatorAC;
	private JMenuItem miConfiguracion;
	private JMenuItem miAyuda;
	private JPanel pnlContenidoAplicacionPrincipal;
	private JPanel pnlBotones;
	private JPanel pnlReservas;
	private JButton btnReservas;
	private JButton btnNewButton;
	private JPanel pnlActividades;
	private JPanel pnlUsuario;
	private JPanel pnlGestorConfiguracion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionPrincipal window = new AplicacionPrincipal();
					window.frame.setVisible(true);
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
		
		//Oyentes de la aplicacion principal
		asociacionOyentesAplicacionPrincipal();
		
	}
	private void asociacionOyentesAplicacionPrincipal() {
		
		btnReservas.addActionListener(new NavegacionPanelesActionListener());
		btnNewButton.addActionListener(new NavegacionPanelesActionListener());
		miUsuario.addActionListener(new NavegacionPanelesActionListener());
		miConfiguracion.addActionListener(new NavegacionPanelesActionListener());
		
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
			
		}
	}
	/**
	 * 
	 * Descripcion: Datos generados en la parte de disenio para inicializar la aplicacion
	 * 
	 */
	private void inicializarDatosAplicacionPrincipal() {
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(new Rectangle(100, 100, 1150, 750));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
	}
	/**
	 * 
	 * Descripcion: Metodo que inicializa el panel principal de la aplicacion y sus sub paneles
	 * 
	 */
	private void inicializarPanelPrincipal() {
		
		//Panel Principal de la aplicacion
		
		pnlContenidoAplicacionPrincipal = new JPanel();
		frame.getContentPane().add(pnlContenidoAplicacionPrincipal, BorderLayout.CENTER);
		pnlContenidoAplicacionPrincipal.setLayout(new CardLayout(0, 0));
		
		//Panel que da acceso a las reservas
		
		pnlReservas = new MiPanelReservas();
		pnlContenidoAplicacionPrincipal.add(pnlReservas, "Reservas");
		
		//Panel que da acceso a las actividades
		
		pnlActividades = new MiPanelRutasSenderistas();
		pnlContenidoAplicacionPrincipal.add(pnlActividades, "Actividades");
		
		//Panel que da acceso a la informacion del usuario
		
		pnlUsuario = new MiPanelUsuario();
		pnlContenidoAplicacionPrincipal.add(pnlUsuario, "Usuario");
		
		//Panel que da acceso al gestor de la configuracion para editar la informacion
		
		pnlGestorConfiguracion = new MiPanelGestorConfiguracion();
		pnlContenidoAplicacionPrincipal.add(pnlGestorConfiguracion, "Configuración");
		
	}
	/**
	 * 
	 * Descripcion: Panel que permite navegar entre los distintos paneles de la aplicacion
	 * 
	 */
	private void inicializarPanelBotones() {
		
		//Panel que contiene los botones
		
		pnlBotones = new JPanel();
		frame.getContentPane().add(pnlBotones, BorderLayout.WEST);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[]{85, 0};
		gbl_pnlBotones.rowHeights = new int[]{21, 0, 0, 0, 0};
		gbl_pnlBotones.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBotones.setLayout(gbl_pnlBotones);
		
		//Boton Reservas
		
		btnReservas = new JButton("Reservas");
		GridBagConstraints gbc_btnReservas = new GridBagConstraints();
		gbc_btnReservas.insets = new Insets(0, 0, 5, 0);
		gbc_btnReservas.fill = GridBagConstraints.BOTH;
		gbc_btnReservas.gridx = 0;
		gbc_btnReservas.gridy = 1;
		pnlBotones.add(btnReservas, gbc_btnReservas);
		
		//Boton Actividades
		
		btnNewButton = new JButton("Actividades");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		pnlBotones.add(btnNewButton, gbc_btnNewButton);
		
	}
	/**
	 * 
	 * Descripcion: Metodo con los datos generados en la parte de disenio que permiten inicializar la barra de menu y sus items
	 * 
	 */
	private void inicializarDatosBarraMenuAplicacionPrincipal() {
		
		//Datos barra de menu
		
		menuBarAplicacionPrincipal = new JMenuBar();
		frame.setJMenuBar(menuBarAplicacionPrincipal);
		
		//Menu Usuario
		
		mUsuario = new JMenu("Usuario");
		menuBarAplicacionPrincipal.add(mUsuario);
		
		//Item Usuario
		
		miUsuario = new JMenuItem("Usuario");
		mUsuario.add(miUsuario);
		
		//Separador entre usuario y el item about
		
		separatorUA = new JSeparator();
		mUsuario.add(separatorUA);
		
		//Item About
		
		miAbout = new JMenuItem("About");
		mUsuario.add(miAbout);
		
		//Separador entre el item about y el item Configuracion
		
		separatorAC = new JSeparator();
		mUsuario.add(separatorAC);
		
		//Item configuracion
		
		miConfiguracion = new JMenuItem("Configuración");
		mUsuario.add(miConfiguracion);
		
		//Item ayuda

		miAyuda = new JMenuItem("Ayuda");
		mUsuario.add(miAyuda);
		
	}
	/**
	 * 
	 * Descripcion: Metodo get para poder obtener el frame de la aplicacion principal porque estamos trabajando con un Application Window
	 * 
	 * @return frame de la aplicacion principal
	 */
	public JFrame getJFrame() {
		
		return this.frame;
		
	}
}
