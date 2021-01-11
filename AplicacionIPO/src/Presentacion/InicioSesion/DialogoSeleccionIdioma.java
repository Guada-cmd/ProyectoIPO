package Presentacion.InicioSesion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.Idioma;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class DialogoSeleccionIdioma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnIngles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoSeleccionIdioma dialog = new DialogoSeleccionIdioma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoSeleccionIdioma() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoSeleccionIdioma.class.getResource("/recursos/translation.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 585, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSeleccionIdioma = new JLabel("Selecciones el idioma:");
			lblSeleccionIdioma.setBounds(136, 14, 138, 20);
			lblSeleccionIdioma.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			contentPanel.add(lblSeleccionIdioma);
		}
		{
			rdbtnIngles = new JRadioButton("Inglés");
			rdbtnIngles.setIcon(new ImageIcon(DialogoSeleccionIdioma.class.getResource("/recursos/banderaIng.gif")));
			rdbtnIngles.setBounds(279, 10, 69, 29);
			rdbtnIngles.setBackground(new Color(255, 255, 255));
			rdbtnIngles.setFont(new Font("Segoe UI", Font.BOLD, 14));
			buttonGroup.add(rdbtnIngles);
			contentPanel.add(rdbtnIngles);
		}
		{
			JRadioButton rdbtnEspanol = new JRadioButton("Español");
			rdbtnEspanol.setIcon(new ImageIcon(DialogoSeleccionIdioma.class.getResource("/recursos/banderaEsp.gif")));
			rdbtnEspanol.setBounds(353, 10, 81, 29);
			rdbtnEspanol.setBackground(new Color(255, 255, 255));
			rdbtnEspanol.setFont(new Font("Segoe UI", Font.BOLD, 14));
			buttonGroup.add(rdbtnEspanol);
			contentPanel.add(rdbtnEspanol);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setForeground(new Color(255, 255, 255));
			okButton.setBackground(new Color(51, 51, 51));
			okButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
			okButton.setBounds(237, 72, 84, 31);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(rdbtnIngles.isSelected()) {
						
						Idioma.idioma = "en";
					}
					else {
						Idioma.idioma = "es";
					}
					VentanaInicio ventana_inicio = new VentanaInicio();
					ventana_inicio.getJFrameVentanaInicio().setVisible(true);
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}

}
