package Presentacion.Principal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Dominio.Perfil;
import Dominio.Usuario;
import Presentacion.InicioSesion.VentanaInicio;
import Traductor.Messages;

@SuppressWarnings("serial")
public class MiPanelGestorConfiguracion extends JPanel {
	
	private JPanel pnlBotones;
	private JButton btnConfiguracionAvanzada;
	private JPanel pnlGestorConfiguracion;
	private JPanel pnlConfiguracion;
	private JPanel pnlConfiguracionAvanzada;
	
	
	private Usuario usuario_datos_configuracion;
	private Perfil datos_perfil;
	private JButton btnConfiguracionNormal;

	/**
	 * Create the panel.
	 */
	public MiPanelGestorConfiguracion(Usuario usuario_datos_configuracion, Perfil datos_perfil) {
		setBackground(new Color(255, 255, 255));
		
		
		this.usuario_datos_configuracion = usuario_datos_configuracion;
		this.datos_perfil = datos_perfil;
		
		
		inicializarDatosPanelGestorConfiguracion();
		
		//Inicializacion datos del panel con el boton
		inicializarDatosPanelBoton();
		
		//Inicializacion datos del panel que contiene subp aneles
		inicializarDatosPanelGestor();
		
		//Inicializacion del boton del panel gestor
		inicializarDatosBoton();
		
		//Inicializacion oyentes
		asociacionOyentesGestorConfiguracion();
		
	}
	/**
	 * 
	 * Descripcion: Metodo con los oyentes
	 */
	private void asociacionOyentesGestorConfiguracion() {
		
		btnConfiguracionAvanzada.addActionListener(new NavegacionPanelGestorConfiguracionActionListener());
		btnConfiguracionNormal.addActionListener(new NavegacionPanelGestorConfiguracionActionListener());
				
	}
	/**
	 * 
	 * Descripcion: Oyente que al pulsar en el BtnConfiguracionAvanzada permite acceder al respectivo panel
	 * 
	 *
	 */
	private class NavegacionPanelGestorConfiguracionActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			CardLayout cardLayoutPanel = (CardLayout)(pnlGestorConfiguracion.getLayout());
			pnlGestorConfiguracion.setVisible(true);
			cardLayoutPanel.show(pnlGestorConfiguracion, e.getActionCommand());
			
			
			
		}
	}
	/**
	 * 
	 * Descripcion: Metodo de inicializacion de los datos del boton
	 * 
	 */
	private void inicializarDatosBoton() {
		{
			btnConfiguracionNormal = new JButton(Messages.getString("MiPanelGestorConfiguracion.btnConfiguracionNormal.text")); //$NON-NLS-1$
			btnConfiguracionNormal.setFocusTraversalKeysEnabled(false);
			btnConfiguracionNormal.setFocusPainted(false);
			btnConfiguracionNormal.setFocusable(false);
			GridBagConstraints gbc_btnConfiguracionNormal = new GridBagConstraints();
			gbc_btnConfiguracionNormal.anchor = GridBagConstraints.EAST;
			gbc_btnConfiguracionNormal.insets = new Insets(0, 0, 5, 5);
			gbc_btnConfiguracionNormal.gridx = 0;
			gbc_btnConfiguracionNormal.gridy = 0;
			pnlBotones.add(btnConfiguracionNormal, gbc_btnConfiguracionNormal);
			
			btnConfiguracionNormal.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnConfiguracionNormal.setForeground(new Color(255, 255, 255));
			btnConfiguracionNormal.setBackground(new Color(51, 51, 51));
		}
		
		//Boton de la configuracion avanzada
		
		btnConfiguracionAvanzada = new JButton(Messages.getString("MiPanelGestorConfiguracion.btnConfiguracionAvanzada.text")); //$NON-NLS-1$
		btnConfiguracionAvanzada.setFocusable(false);
		btnConfiguracionAvanzada.setFocusTraversalKeysEnabled(false);
		btnConfiguracionAvanzada.setFocusPainted(false);
		btnConfiguracionAvanzada.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnConfiguracionAvanzada.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnConfiguracionAvanzada.setForeground(new Color(255, 255, 255));
		btnConfiguracionAvanzada.setBackground(new Color(51, 51, 51));
		
		GridBagConstraints gbc_btnConfiguracionAvanzada = new GridBagConstraints();
		gbc_btnConfiguracionAvanzada.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfiguracionAvanzada.anchor = GridBagConstraints.NORTH;
		gbc_btnConfiguracionAvanzada.gridx = 1;
		gbc_btnConfiguracionAvanzada.gridy = 0;
		pnlBotones.add(btnConfiguracionAvanzada, gbc_btnConfiguracionAvanzada);
		
	}
	/**
	 * 
	 * Descripcion: Metodo de inicializacion de los datos que contiene el panel gestor que permite navegar entre paneles
	 * 
	 */
	private void inicializarDatosPanelGestor() {
		
		//Panel gestor
		
		pnlGestorConfiguracion = new JPanel();
		pnlGestorConfiguracion.setBackground(new Color(255, 255, 255));
		add(pnlGestorConfiguracion, BorderLayout.WEST);
		pnlGestorConfiguracion.setLayout(new CardLayout(0, 0));
		
		//Panel con la configuracion editable del Usuario
	
		
		//Panel con la configuracion avanzada editable del Usuario
		
		inicializarDatosConfiguracionAvanzadaBD();
	
		
	}
	private void inicializarDatosConfiguracionAvanzadaBD() {
		
		if(VentanaInicio.usuario_sistema != null) {
			
			pnlConfiguracion = new MiPanelConfiguracion(usuario_datos_configuracion, datos_perfil);
			pnlGestorConfiguracion.add(pnlConfiguracion, "Configuración");
		
			pnlConfiguracionAvanzada = new MiPanelConfiguracionAvanzada(usuario_datos_configuracion, datos_perfil);
			pnlGestorConfiguracion.add(pnlConfiguracionAvanzada, "Avanzada");
			
		}
	
	}
	/**
	 * 
	 * Descripcion: Metodo de inicializacion de los datos que contiene el panel con el boton de configuracion avanzada
	 * 
	 */
	private void inicializarDatosPanelBoton() {
		
		//Panel que contiene el boton
		
		pnlBotones = new JPanel();
		pnlBotones.setBackground(new Color(255, 255, 255));
		add(pnlBotones, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[]{178, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 74, 62, 0};
		gbl_pnlBotones.rowHeights = new int[]{19, 0, 0};
		gbl_pnlBotones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlBotones.setLayout(gbl_pnlBotones);
		
	}
	/**
	 * 
	 * Descripcion: Metodo de inicializacion datos del gestor de configuracion
	 * 
	 */
	private void inicializarDatosPanelGestorConfiguracion() {
		
		setLayout(new BorderLayout(0, 0));
		
	}

}
