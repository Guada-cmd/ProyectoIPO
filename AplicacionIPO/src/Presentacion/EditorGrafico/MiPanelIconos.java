package Presentacion.EditorGrafico;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MiPanelIconos extends JPanel {
	private JLabel lblTituloIconos;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblTramos;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;

	/**
	 * Create the panel.
	 */
	public MiPanelIconos() {
		setBackground(new Color(255, 255, 255));
		
		inicializarDatosPanel();
		
		inicializarDatosPanelIconos();
		

	}
	/**
	 * 
	 * Descripcion: inicializar los datos del panel de iconos
	 * 
	 */
	public void inicializarDatosPanel() {
		
		setBounds(new Rectangle(0, 0, 50, 700));
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{24, 26, 0, -4, 0};
		gridBagLayout.rowHeights = new int[]{40, 38, 33, 34, 35, 36, 33, 37, 34, 34, 33, 33, 31, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTituloIconos = new JLabel("Iconos:");
		lblTituloIconos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_lblTituloIconos = new GridBagConstraints();
		gbc_lblTituloIconos.gridwidth = 3;
		gbc_lblTituloIconos.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloIconos.gridx = 1;
		gbc_lblTituloIconos.gridy = 0;
		add(lblTituloIconos, gbc_lblTituloIconos);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/ubicacion.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/puentes.png")));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 3;
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/rio.png")));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridwidth = 3;
		gbc_btnNewButton_2.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 3;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/rest-area.png")));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_3.gridwidth = 3;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 4;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/noche.png")));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_4.gridwidth = 3;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 5;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/pata.png")));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_5.gridwidth = 3;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 6;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		lblTramos = new JLabel("Tramos:");
		lblTramos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_lblTramos = new GridBagConstraints();
		gbc_lblTramos.gridwidth = 3;
		gbc_lblTramos.insets = new Insets(0, 0, 5, 0);
		gbc_lblTramos.gridx = 1;
		gbc_lblTramos.gridy = 7;
		add(lblTramos, gbc_lblTramos);
		
		btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/NoTiene.png")));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_6.gridwidth = 3;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 1;
		gbc_btnNewButton_6.gridy = 8;
		add(btnNewButton_6, gbc_btnNewButton_6);
		
		btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/baja.png")));
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_7.gridwidth = 3;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 9;
		add(btnNewButton_7, gbc_btnNewButton_7);
		
		btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/Intermedio.png")));
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_8.gridwidth = 3;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_8.gridx = 1;
		gbc_btnNewButton_8.gridy = 10;
		add(btnNewButton_8, gbc_btnNewButton_8);
		
		btnNewButton_9 = new JButton("");
		btnNewButton_9.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/Experto.png")));
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_9.gridwidth = 3;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_9.gridx = 1;
		gbc_btnNewButton_9.gridy = 11;
		add(btnNewButton_9, gbc_btnNewButton_9);
		
	}
	/**
	 * 
	 * Descripcion: inicializar los datos de los botones del panel iconos
	 * 
	 */
	public void inicializarDatosPanelIconos() {
		
	}
}
