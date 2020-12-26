package Presentacion.rutas;

import javax.swing.JPanel;

import Presentacion.EditorGrafico.EditorGraficoRuta;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDayChooser;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class MiPanelAniadirRutas extends JPanel {
	
	private JButton btnEditorRutas;
	private EditorGraficoRuta frame_editor_rutas;
	private JLabel lbldeseaAadirUna;
	private JSpinner spinner;
	private JTextField textField;
	private JLabel lblNombreRuta;
	private JComboBox cmbTipoUsuario;
	private JLabel lblPuntoDeEncuentro;
	private JLabel lblNumMaximoPersonas;
	private JLabel lblNmMximoPersonas;
	private JSpinner spinner_1;
	private JLabel lblCamposParaCrear;
	private JLabel lblDificultad;
	private JLabel lblDescripcin;
	private JLabel lblEquipamineto;
	private JComboBox cmbTipoUsuario_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public MiPanelAniadirRutas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{52, 154, 147, 61, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{66, 43, 31, 23, 24, 27, 22, 27, 27, 29, 14, 34, 37, 42, 41, 71, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblCamposParaCrear = new JLabel("Campos para crear una ruta personalizada.");
		lblCamposParaCrear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblCamposParaCrear = new GridBagConstraints();
		gbc_lblCamposParaCrear.anchor = GridBagConstraints.WEST;
		gbc_lblCamposParaCrear.gridwidth = 2;
		gbc_lblCamposParaCrear.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamposParaCrear.gridx = 1;
		gbc_lblCamposParaCrear.gridy = 2;
		add(lblCamposParaCrear, gbc_lblCamposParaCrear);
		
		lblNombreRuta = new JLabel("Nombre ruta:");
		lblNombreRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombreRuta = new GridBagConstraints();
		gbc_lblNombreRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreRuta.anchor = GridBagConstraints.EAST;
		gbc_lblNombreRuta.gridx = 1;
		gbc_lblNombreRuta.gridy = 4;
		add(lblNombreRuta, gbc_lblNombreRuta);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnEditorRutas = new JButton("Editor Rutas");
		btnEditorRutas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_btnEditorRutas = new GridBagConstraints();
		gbc_btnEditorRutas.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditorRutas.fill = GridBagConstraints.BOTH;
		gbc_btnEditorRutas.gridx = 5;
		gbc_btnEditorRutas.gridy = 4;
		add(btnEditorRutas, gbc_btnEditorRutas);
		
		
		btnEditorRutas.addActionListener(new BtnEditorRutasActionListener());
		
		lblPuntoDeEncuentro = new JLabel("Punto de encuentro:");
		lblPuntoDeEncuentro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPuntoDeEncuentro = new GridBagConstraints();
		gbc_lblPuntoDeEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntoDeEncuentro.anchor = GridBagConstraints.EAST;
		gbc_lblPuntoDeEncuentro.gridx = 1;
		gbc_lblPuntoDeEncuentro.gridy = 5;
		add(lblPuntoDeEncuentro, gbc_lblPuntoDeEncuentro);
		
		cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Entrada campamento", "Salida campamento", "Zona parcelas", "Zona bungalows"}));
		cmbTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTipoUsuario.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbTipoUsuario = new GridBagConstraints();
		gbc_cmbTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoUsuario.fill = GridBagConstraints.BOTH;
		gbc_cmbTipoUsuario.gridx = 2;
		gbc_cmbTipoUsuario.gridy = 5;
		add(cmbTipoUsuario, gbc_cmbTipoUsuario);
		
		lbldeseaAadirUna = new JLabel("¿Desea añadir una imagen de la ruta?");
		lbldeseaAadirUna.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lbldeseaAadirUna = new GridBagConstraints();
		gbc_lbldeseaAadirUna.insets = new Insets(0, 0, 5, 0);
		gbc_lbldeseaAadirUna.gridwidth = 3;
		gbc_lbldeseaAadirUna.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbldeseaAadirUna.gridx = 5;
		gbc_lbldeseaAadirUna.gridy = 5;
		add(lbldeseaAadirUna, gbc_lbldeseaAadirUna);
		
		lblNumMaximoPersonas = new JLabel("Mínimo de personas:");
		lblNumMaximoPersonas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNumMaximoPersonas = new GridBagConstraints();
		gbc_lblNumMaximoPersonas.anchor = GridBagConstraints.EAST;
		gbc_lblNumMaximoPersonas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumMaximoPersonas.gridx = 1;
		gbc_lblNumMaximoPersonas.gridy = 7;
		add(lblNumMaximoPersonas, gbc_lblNumMaximoPersonas);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(2, 2, 50, 1));
		spinner_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		spinner_1.setFocusable(false);
		spinner_1.setFocusTraversalKeysEnabled(false);
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.VERTICAL;
		gbc_spinner_1.anchor = GridBagConstraints.WEST;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 2;
		gbc_spinner_1.gridy = 7;
		add(spinner_1, gbc_spinner_1);
		
		lblNmMximoPersonas = new JLabel("Máximo de personas:");
		lblNmMximoPersonas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNmMximoPersonas = new GridBagConstraints();
		gbc_lblNmMximoPersonas.anchor = GridBagConstraints.EAST;
		gbc_lblNmMximoPersonas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmMximoPersonas.gridx = 1;
		gbc_lblNmMximoPersonas.gridy = 8;
		add(lblNmMximoPersonas, gbc_lblNmMximoPersonas);
		
		spinner = new JSpinner();
		spinner.setFocusTraversalKeysEnabled(false);
		spinner.setFocusable(false);
		spinner.setModel(new SpinnerNumberModel(2, 2, 50, 1));
		spinner.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.VERTICAL;
		gbc_spinner.anchor = GridBagConstraints.WEST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 8;
		add(spinner, gbc_spinner);
		
		lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.anchor = GridBagConstraints.EAST;
		gbc_lblDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultad.gridx = 1;
		gbc_lblDificultad.gridy = 10;
		add(lblDificultad, gbc_lblDificultad);
		
		cmbTipoUsuario_1 = new JComboBox();
		cmbTipoUsuario_1.setModel(new DefaultComboBoxModel(new String[] {"Fácil", "Media", "Difícil"}));
		cmbTipoUsuario_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTipoUsuario_1.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbTipoUsuario_1 = new GridBagConstraints();
		gbc_cmbTipoUsuario_1.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoUsuario_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoUsuario_1.gridx = 2;
		gbc_cmbTipoUsuario_1.gridy = 10;
		add(cmbTipoUsuario_1, gbc_cmbTipoUsuario_1);
		
		lblEquipamineto = new JLabel("Equipamineto:");
		lblEquipamineto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEquipamineto = new GridBagConstraints();
		gbc_lblEquipamineto.anchor = GridBagConstraints.EAST;
		gbc_lblEquipamineto.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipamineto.gridx = 1;
		gbc_lblEquipamineto.gridy = 11;
		add(lblEquipamineto, gbc_lblEquipamineto);
		
		lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 1;
		gbc_lblDescripcin.gridy = 12;
		add(lblDescripcin, gbc_lblDescripcin);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 12;
		add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	}
	/**
	 * 
	 * Descripcion: Oyente que al pulsar en el BtnEditarRutas permite acceder al JFrame del editor de rutas
	 * 
	 *
	 */
	private class BtnEditorRutasActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//Se crea un frame con el editor grafico de rutas
			frame_editor_rutas = new EditorGraficoRuta();
			frame_editor_rutas.setVisible(true);
			

			
		}
	}
}
