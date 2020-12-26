package Presentacion.rutas;

import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JButton;

public class MiPanelGestorRutas extends JPanel {
	private JPanel pnlGestorRutas;
	private JPanel pnlNavegarRutas;
	private JPanel pnlRutasDisponibles;
	private JPanel pnlAniadirRutas;
	private JButton btnRutasDisponibles;
	private JButton btnAniadirRuta;

	/**
	 * Create the panel.
	 */
	public MiPanelGestorRutas() {
		setLayout(new BorderLayout(0, 0));
		
		pnlGestorRutas = new JPanel();
		add(pnlGestorRutas, BorderLayout.CENTER);
		pnlGestorRutas.setLayout(new CardLayout(0, 0));
		
		pnlRutasDisponibles = new MiPanelRutasSenderistas();
		pnlGestorRutas.add(pnlRutasDisponibles, "Mostrar");
		
		pnlAniadirRutas = new MiPanelAniadirRutas();
		pnlGestorRutas.add(pnlAniadirRutas, "Añadir");
		
		pnlNavegarRutas = new JPanel();
		add(pnlNavegarRutas, BorderLayout.SOUTH);
		
		btnRutasDisponibles = new JButton("Mostrar");
		pnlNavegarRutas.add(btnRutasDisponibles);
		
		btnAniadirRuta = new JButton("Añadir");
		pnlNavegarRutas.add(btnAniadirRuta);
		
		asociacionOyentesGestorRutas();
		
	}
	private void asociacionOyentesGestorRutas() {
		
		btnRutasDisponibles.addActionListener(new NavegacionPanelesActionListener());
		btnAniadirRuta.addActionListener(new NavegacionPanelesActionListener());
		
	}
	/**
	 * 
	 * Descripcion: Permite navegar entre los paneles al pulsar un boton
	 *
	 */
	private class NavegacionPanelesActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			CardLayout cardLayoutPanel = (CardLayout)(pnlGestorRutas.getLayout());
			pnlGestorRutas.setVisible(true);
			cardLayoutPanel.show(pnlGestorRutas, e.getActionCommand());
			
		}
	}

}
