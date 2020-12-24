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

public class AvisoFormularioRegistro extends JDialog {
	
	private JLabel lblAvisoCamposIncompletos;
	private JLabel lblFotoAvisoCamposIncompletos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			AvisoFormularioRegistro dialog = new AvisoFormularioRegistro();
			
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
	public AvisoFormularioRegistro() {
		
		inicializarDatosDialogoAvisoRegistro();
		
		inicializarEtiquetasDialogoAvisoRegistro();
		
	}
	/**
	 * 
	 * Descripcion: inicializacion de los datos de la ventana de dialogo al hacer la parte de disenio
	 * 
	 */
	private void inicializarDatosDialogoAvisoRegistro() {
		
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setTitle("Formulario incompleto.\r\n");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
	}
	/**
	 * 
	 * Descripcion: inicializacion de los datos de las etiquetas de la ventana de dialogo al hacer la parte de disenio
	 * 
	 */
	private void inicializarEtiquetasDialogoAvisoRegistro() {
		
		//Datos etiqueta aviso 
		
		lblAvisoCamposIncompletos = new JLabel("Rellene los campos obligatorios que faltan.");
		lblAvisoCamposIncompletos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAvisoCamposIncompletos.setBounds(111, 22, 318, 46);
		getContentPane().add(lblAvisoCamposIncompletos);
		
		//Datos etiqueta aviso foto 
		
		lblFotoAvisoCamposIncompletos = new JLabel("");
		lblFotoAvisoCamposIncompletos.setIcon(new ImageIcon(AvisoFormularioRegistro.class.getResource("/recursos/incomplete.png")));
		lblFotoAvisoCamposIncompletos.setBounds(228, 71, 68, 76);
		getContentPane().add(lblFotoAvisoCamposIncompletos);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AvisoFormularioRegistro.class.getResource("/recursos/danger.png")));
		setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 521, 213);
		
	}
}
