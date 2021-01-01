package Presentacion.Principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.Color;

public class MiPanelReservas extends JPanel {
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public MiPanelReservas() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Reservas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelReservas = new JPanel();
		panelReservas.setBackground(new Color(255, 255, 255));
		add(panelReservas, BorderLayout.CENTER);
		
		
		JButton btnParcela = new JButton("Reservar parcela");
		panelReservas.add(btnParcela, "2, 2");
		
		JButton btnCabana = new JButton("Reservar caba\u00F1a");
		panelReservas.add(btnCabana, "2, 4");
		
		JButton btnExplorar = new JButton("Explorar reservas");
		panelReservas.add(btnExplorar, "2, 6");

	}

}
