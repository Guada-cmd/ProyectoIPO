package Presentacion.rutas;

import javax.swing.JPanel;

import Presentacion.EditorGrafico.EditorGraficoRuta;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MiPanelAniadirRutas extends JPanel {
	
	private JButton btnEditorRutas;
	private EditorGraficoRuta frame_editor_rutas;
	private JLabel lbldeseaAadirUna;

	/**
	 * Create the panel.
	 */
	public MiPanelAniadirRutas() {
		setLayout(null);
		
		btnEditorRutas = new JButton("Editor Rutas");
		btnEditorRutas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnEditorRutas.setBounds(64, 372, 114, 27);
		add(btnEditorRutas);
		
		lbldeseaAadirUna = new JLabel("¿Desea añadir una imagen de la ruta?");
		lbldeseaAadirUna.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbldeseaAadirUna.setBounds(197, 375, 254, 20);
		add(lbldeseaAadirUna);
		
		
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
