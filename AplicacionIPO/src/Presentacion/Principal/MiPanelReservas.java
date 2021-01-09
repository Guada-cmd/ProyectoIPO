package Presentacion.Principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Presentacion.Principal.Reserva;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		GridBagLayout gbl_panelReservas = new GridBagLayout();
		gbl_panelReservas.columnWidths = new int[]{53, 111, 0};
		gbl_panelReservas.rowHeights = new int[]{21, 0, 0, 0, 0, 0};
		gbl_panelReservas.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelReservas.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelReservas.setLayout(gbl_panelReservas);
		
		
		JButton btnParcela = new JButton("Reservar parcela ");
		btnParcela.addActionListener(new BtnParcelaActionListener());
		
		JLabel lblReservarParcela = new JLabel("Para realizar reservas de parcelas:");
		GridBagConstraints gbc_lblReservarParcela = new GridBagConstraints();
		gbc_lblReservarParcela.fill = GridBagConstraints.VERTICAL;
		gbc_lblReservarParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblReservarParcela.gridx = 0;
		gbc_lblReservarParcela.gridy = 0;
		panelReservas.add(lblReservarParcela, gbc_lblReservarParcela);
		GridBagConstraints gbc_btnParcela = new GridBagConstraints();
		gbc_btnParcela.fill = GridBagConstraints.VERTICAL;
		gbc_btnParcela.insets = new Insets(0, 0, 5, 0);
		gbc_btnParcela.gridx = 1;
		gbc_btnParcela.gridy = 0;
		panelReservas.add(btnParcela, gbc_btnParcela);
		
		JLabel lblNewLabel_1 = new JLabel("Para realizar reservas de cabañas:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panelReservas.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnCabana = new JButton("Reservar cabaña ");
		btnCabana.addActionListener(new BtnCabanaActionListener());
		GridBagConstraints gbc_btnCabana = new GridBagConstraints();
		gbc_btnCabana.fill = GridBagConstraints.VERTICAL;
		gbc_btnCabana.insets = new Insets(0, 0, 5, 0);
		gbc_btnCabana.gridx = 1;
		gbc_btnCabana.gridy = 2;
		panelReservas.add(btnCabana, gbc_btnCabana);
		
		JLabel lblNewLabel_2 = new JLabel("Para explorar y finalizar reservas:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panelReservas.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnExplorar = new JButton("Explorar reservas");
		btnExplorar.addActionListener(new BtnExplorarActionListener());
		GridBagConstraints gbc_btnExplorar = new GridBagConstraints();
		gbc_btnExplorar.fill = GridBagConstraints.VERTICAL;
		gbc_btnExplorar.gridx = 1;
		gbc_btnExplorar.gridy = 4;
		panelReservas.add(btnExplorar, gbc_btnExplorar);

	}

	private class BtnParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Reserva ventanaReservas = new Reserva();
			ventanaReservas.getJFrame().setVisible(true);
			ventanaReservas.showParcelasPane();
			ventanaReservas.mostrarParcelas();
		}
	}
	private class BtnCabanaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Reserva ventanaReservas = new Reserva();
			ventanaReservas.getJFrame().setVisible(true);
			ventanaReservas.showCabanasPane();
			ventanaReservas.mostrarCabañas();
		}
	}
	private class BtnExplorarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Reserva ventanaReservas = new Reserva();
			ventanaReservas.getJFrame().setVisible(true);
			ventanaReservas.showExplorarPane();
			ventanaReservas.mostrarReservas(false);
		}
	}
}
