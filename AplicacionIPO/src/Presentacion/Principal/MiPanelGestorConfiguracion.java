package Presentacion.Principal;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MiPanelGestorConfiguracion extends JPanel {
	
	private JPanel pnlBotones;
	private JButton btnConfiguracionAvanzada;
	private JPanel pnlGestorConfiguracion;
	private JPanel pnlConfiguracion;
	private JPanel pnlConfiguracionAvanzada;

	/**
	 * Create the panel.
	 */
	public MiPanelGestorConfiguracion() {
		
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
		gbc_btnConfiguracionAvanzada.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfiguracionAvanzada.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnConfiguracionAvanzada.gridx = 13;
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
		add(pnlGestorConfiguracion, BorderLayout.WEST);
		pnlGestorConfiguracion.setLayout(new CardLayout(0, 0));
		
		//Panel con la configuracion editable del Usuario
		
		pnlConfiguracion = new MiPanelConfiguracion();
		pnlGestorConfiguracion.add(pnlConfiguracion, "Configuración");
		
		//Panel con la configuracion avanzada editable del Usuario
		
		pnlConfiguracionAvanzada = new MiPanelConfiguracionAvanzada();
		pnlGestorConfiguracion.add(pnlConfiguracionAvanzada, "Configuracion Avanzada");
		
	}
	/**
	 * 
	 * Descripcion: Metodo de inicializacion de los datos que contiene el panel con el boton de configuracion avanzada
	 * 
	 */
	private void inicializarDatosPanelBoton() {
		
		//Panel que contiene el boton
		
		pnlBotones = new JPanel();
		add(pnlBotones, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[]{434, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 74, 62, 0};
		gbl_pnlBotones.rowHeights = new int[]{25, 19, 0};
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
