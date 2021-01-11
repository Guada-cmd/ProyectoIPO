package Presentacion.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import Traductor.Messages;

@SuppressWarnings("serial")
public class MiPanelReservas extends JPanel {
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public MiPanelReservas() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel(Messages.getString("MiPanelReservas.lblNewLabel.text")); //$NON-NLS-1$
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelReservas = new JPanel();
		panelReservas.setBackground(new Color(255, 255, 255));
		add(panelReservas, BorderLayout.CENTER);
		GridBagLayout gbl_panelReservas = new GridBagLayout();
		gbl_panelReservas.columnWidths = new int[]{0, 53, 111, 0};
		gbl_panelReservas.rowHeights = new int[]{21, 0, 0, 0, 0, 0};
		gbl_panelReservas.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelReservas.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelReservas.setLayout(gbl_panelReservas);
		
		
		JButton btnParcela = new JButton(Messages.getString("MiPanelReservas.btnParcela.text")); //$NON-NLS-1$
		btnParcela.addActionListener(new BtnParcelaActionListener());
		
		JLabel lblReservarParcela = new JLabel(Messages.getString("MiPanelReservas.lblReservarParcela.text")); //$NON-NLS-1$
		lblReservarParcela.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReservarParcela.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblReservarParcela = new GridBagConstraints();
		gbc_lblReservarParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblReservarParcela.gridx = 1;
		gbc_lblReservarParcela.gridy = 0;
		panelReservas.add(lblReservarParcela, gbc_lblReservarParcela);
		GridBagConstraints gbc_btnParcela = new GridBagConstraints();
		gbc_btnParcela.insets = new Insets(0, 0, 5, 0);
		gbc_btnParcela.gridx = 2;
		gbc_btnParcela.gridy = 0;
		panelReservas.add(btnParcela, gbc_btnParcela);
		
		JLabel lblReservarCabana = new JLabel(Messages.getString("MiPanelReservas.lblReservarCabana.text")); //$NON-NLS-1$
		lblReservarCabana.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblReservarCabana = new GridBagConstraints();
		gbc_lblReservarCabana.insets = new Insets(0, 0, 5, 5);
		gbc_lblReservarCabana.gridx = 1;
		gbc_lblReservarCabana.gridy = 2;
		panelReservas.add(lblReservarCabana, gbc_lblReservarCabana);
		
		JButton btnCabana = new JButton(Messages.getString("MiPanelReservas.btnCabana.text")); //$NON-NLS-1$
		btnCabana.addActionListener(new BtnCabanaActionListener());
		GridBagConstraints gbc_btnCabana = new GridBagConstraints();
		gbc_btnCabana.insets = new Insets(0, 0, 5, 0);
		gbc_btnCabana.gridx = 2;
		gbc_btnCabana.gridy = 2;
		panelReservas.add(btnCabana, gbc_btnCabana);
		
		JLabel lblExplorarReservas = new JLabel(Messages.getString("MiPanelReservas.lblExplorarReservas.text")); //$NON-NLS-1$
		lblExplorarReservas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblExplorarReservas = new GridBagConstraints();
		gbc_lblExplorarReservas.insets = new Insets(0, 0, 0, 5);
		gbc_lblExplorarReservas.gridx = 1;
		gbc_lblExplorarReservas.gridy = 4;
		panelReservas.add(lblExplorarReservas, gbc_lblExplorarReservas);
		
		JButton btnExplorar = new JButton(Messages.getString("MiPanelReservas.btnExplorar.text")); //$NON-NLS-1$
		btnExplorar.addActionListener(new BtnExplorarActionListener());
		GridBagConstraints gbc_btnExplorar = new GridBagConstraints();
		gbc_btnExplorar.gridx = 2;
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
			ventanaReservas.mostrarReservas();
		}
	}
}
