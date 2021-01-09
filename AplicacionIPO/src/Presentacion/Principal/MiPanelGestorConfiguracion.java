package Presentacion.Principal;

import javax.swing.JPanel;
import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Dominio.Perfil;
import Dominio.Usuario;
import Presentacion.InicioSesion.VentanaInicio;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MiPanelGestorConfiguracion extends JPanel {
	
	private JPanel pnlBotones;
	private JButton btnConfiguracionAvanzada;
	private JPanel pnlGestorConfiguracion;
	private JPanel pnlConfiguracion;
	private JPanel pnlConfiguracionAvanzada;
	
	
	private Usuario usuario_datos_configuracion;
	private Perfil datos_perfil;

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
			cardLayoutPanel.show(pnlGestorConfiguracion, e.getActionCommand());
			
		}
	}
	/**
	 * 
	 * Descripcion: Metodo de inicializacion de los datos del boton
	 * 
	 */
	private void inicializarDatosBoton() {
		
		//Boton de la configuracion avanzada
		
		btnConfiguracionAvanzada = new JButton("Configuracion Avanzada");
		btnConfiguracionAvanzada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnConfiguracionAvanzada.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnConfiguracionAvanzada = new GridBagConstraints();
		gbc_btnConfiguracionAvanzada.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfiguracionAvanzada.anchor = GridBagConstraints.NORTHWEST;
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
		
		pnlConfiguracion = new MiPanelConfiguracion();
		GridBagLayout gridBagLayout = (GridBagLayout) pnlConfiguracion.getLayout();
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 303, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		pnlGestorConfiguracion.add(pnlConfiguracion, "Configuración");
		
		//Panel con la configuracion avanzada editable del Usuario
		
		inicializarDatosConfiguracionAvanzadaBD();
	
		
	}
	private void inicializarDatosConfiguracionAvanzadaBD() {
		
		if(VentanaInicio.usuario_sistema != null) {
		
			pnlConfiguracionAvanzada = new MiPanelConfiguracionAvanzada(usuario_datos_configuracion, datos_perfil);
			pnlGestorConfiguracion.add(pnlConfiguracionAvanzada, "Configuracion Avanzada");
			
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
		gbl_pnlBotones.columnWidths = new int[]{434, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 74, 62, 0};
		gbl_pnlBotones.rowHeights = new int[]{19, 0};
		gbl_pnlBotones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
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
