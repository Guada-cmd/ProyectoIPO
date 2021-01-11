package Presentacion.rutas;

import javax.swing.JPanel;

import Presentacion.EditorGrafico.EditorGraficoRuta;
import Presentacion.InicioSesion.FormularioRegistro;

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
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import Traductor.Messages;


public class MiPanelCrearRuta extends JPanel {
	
	private JButton btnEditorRutas;
	private EditorGraficoRuta frame_editor_rutas;
	private JLabel lblPasosCrearRuta;
	private JLabel lblTituloParaCrearRuta;
	private JLabel lblPaso1CrearRuta;
	private JLabel lblPaso2CrearRuta;
	private JButton btnCrearRutaFormulario;
	
	public static FormularioRegistroRuta frame_registro_rutas;
	
	/**
	 * Create the panel.
	 */
	public MiPanelCrearRuta() {
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 41, 307, 91, 61, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{58, 32, 42, 17, 24, 27, 50, 27, 27, 29, 62, 34, 37, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		

		lblTituloParaCrearRuta = new JLabel(Messages.getString("MiPanelCrearRuta.lblTituloParaCrearRuta.text")); //$NON-NLS-1$
		lblTituloParaCrearRuta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblTituloParaCrearRuta = new GridBagConstraints();
		gbc_lblTituloParaCrearRuta.anchor = GridBagConstraints.WEST;
		gbc_lblTituloParaCrearRuta.gridwidth = 3;
		gbc_lblTituloParaCrearRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTituloParaCrearRuta.gridx = 1;
		gbc_lblTituloParaCrearRuta.gridy = 1;
		add(lblTituloParaCrearRuta, gbc_lblTituloParaCrearRuta);
		
		lblPasosCrearRuta = new JLabel(Messages.getString("MiPanelCrearRuta.lblPasosCrearRuta.text")); //$NON-NLS-1$
		lblPasosCrearRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPasosCrearRuta = new GridBagConstraints();
		gbc_lblPasosCrearRuta.gridwidth = 2;
		gbc_lblPasosCrearRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasosCrearRuta.anchor = GridBagConstraints.WEST;
		gbc_lblPasosCrearRuta.gridx = 1;
		gbc_lblPasosCrearRuta.gridy = 2;
		add(lblPasosCrearRuta, gbc_lblPasosCrearRuta);
		
		lblPaso1CrearRuta = new JLabel(Messages.getString("MiPanelCrearRuta.lblPaso1CrearRuta.text")); //$NON-NLS-1$
		lblPaso1CrearRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPaso1CrearRuta = new GridBagConstraints();
		gbc_lblPaso1CrearRuta.gridwidth = 2;
		gbc_lblPaso1CrearRuta.anchor = GridBagConstraints.WEST;
		gbc_lblPaso1CrearRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaso1CrearRuta.gridx = 2;
		gbc_lblPaso1CrearRuta.gridy = 4;
		add(lblPaso1CrearRuta, gbc_lblPaso1CrearRuta);
		
		btnCrearRutaFormulario = new JButton(Messages.getString("MiPanelCrearRuta.btnCrearRutaFormulario.text")); //$NON-NLS-1$
		btnCrearRutaFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Aparece un panel con el formulario registro ruta
				
				 frame_registro_rutas = new FormularioRegistroRuta();
				
				//Para situarlo en el centro de la pantalla
				
				frame_registro_rutas.setLocationRelativeTo(null);
				frame_registro_rutas.setVisible(true);
				
			}
		});
		btnCrearRutaFormulario.setBorder(null);
		btnCrearRutaFormulario.setIcon(new ImageIcon(MiPanelCrearRuta.class.getResource("/recursos/formRuta.png")));
		GridBagConstraints gbc_btnCrearRutaFormulario = new GridBagConstraints();
		gbc_btnCrearRutaFormulario.gridwidth = 7;
		gbc_btnCrearRutaFormulario.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearRutaFormulario.gridx = 0;
		gbc_btnCrearRutaFormulario.gridy = 6;
		add(btnCrearRutaFormulario, gbc_btnCrearRutaFormulario);
		
		
		btnCrearRutaFormulario.setFocusPainted(false);
		btnCrearRutaFormulario.setFocusTraversalKeysEnabled(false);
		btnCrearRutaFormulario.setFocusable(false);
		btnCrearRutaFormulario.setBackground(new Color(255, 255, 255));
		
		btnCrearRutaFormulario.setForeground(new Color(51, 51, 51));
		
		lblPaso2CrearRuta = new JLabel(Messages.getString("MiPanelCrearRuta.lblPaso2CrearRuta.text")); //$NON-NLS-1$
		lblPaso2CrearRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPaso2CrearRuta = new GridBagConstraints();
		gbc_lblPaso2CrearRuta.anchor = GridBagConstraints.WEST;
		gbc_lblPaso2CrearRuta.gridwidth = 2;
		gbc_lblPaso2CrearRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaso2CrearRuta.gridx = 2;
		gbc_lblPaso2CrearRuta.gridy = 8;
		add(lblPaso2CrearRuta, gbc_lblPaso2CrearRuta);
		
		btnEditorRutas = new JButton(Messages.getString("MiPanelCrearRuta.btnEditorRutas.text")); //$NON-NLS-1$
		btnEditorRutas.setBorder(null);
		btnEditorRutas.setIcon(new ImageIcon(MiPanelCrearRuta.class.getResource("/recursos/edit-picture.png")));
		btnEditorRutas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_btnEditorRutas = new GridBagConstraints();
		gbc_btnEditorRutas.gridwidth = 7;
		gbc_btnEditorRutas.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditorRutas.fill = GridBagConstraints.VERTICAL;
		gbc_btnEditorRutas.gridx = 0;
		gbc_btnEditorRutas.gridy = 10;
		add(btnEditorRutas, gbc_btnEditorRutas);
		

		btnEditorRutas.setFocusPainted(false);
		btnEditorRutas.setFocusTraversalKeysEnabled(false);
		btnEditorRutas.setFocusable(false);
		btnEditorRutas.setBackground(new Color(255, 255, 255));
		
		btnEditorRutas.setForeground(new Color(51, 51, 51));
	
		
		
		btnEditorRutas.addActionListener(new BtnEditorRutasActionListener());
		
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
