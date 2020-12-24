package Presentacion.InicioSesion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AvisoFalloRegistro extends JDialog {
	
	private JLabel lblFalloRegistro;
	private JLabel lblFotoRegistroFallo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			AvisoFalloRegistro dialog = new AvisoFalloRegistro();
			
			dialog.setLocationRelativeTo(null); //Para centrar la ventana de dialogo
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

	/**
	 * Create the dialog.
	 */
	public AvisoFalloRegistro() {
		
		inicializarDatosDialogoFalloRegistro();
		
		inicializarEtiquetasDialogoFalloRegistro();
		
	}
	/**
	 * 
	 * Descripcion: inicializacion de los datos de la ventana de dialogo al hacer la parte de disenio
	 * 
	 */
	private void inicializarDatosDialogoFalloRegistro() {
		
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setTitle("Error registro.");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
	}
	/**
	 * 
	 * Descripcion: inicializacion de los datos de las etiquetas de la ventana de dialogo al hacer la parte de disenio
	 * 
	 */
	private void inicializarEtiquetasDialogoFalloRegistro() {
		
		//Datos etiqueta aviso 
		
		lblFalloRegistro = new JLabel("Los datos de las contraseñas no coinciden.");
		lblFalloRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFalloRegistro.setBounds(111, 22, 318, 46);
		getContentPane().add(lblFalloRegistro);
		
		//Datos etiqueta aviso foto 
		
		lblFotoRegistroFallo = new JLabel("");
		lblFotoRegistroFallo.setIcon(new ImageIcon(AvisoFalloRegistro.class.getResource("/recursos/incomplete.png")));
		lblFotoRegistroFallo.setBounds(228, 71, 68, 76);
		getContentPane().add(lblFotoRegistroFallo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AvisoFalloRegistro.class.getResource("/recursos/cancel.png")));
		setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 521, 213);
		
	}
}
