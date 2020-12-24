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

public class AvisoExitoRegistro extends JDialog {
	
	private JLabel lblExitoRegistro;
	private JLabel lblFotoRegistroExito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			AvisoExitoRegistro dialog = new AvisoExitoRegistro();
			
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
	public AvisoExitoRegistro() {
		
		inicializarDatosDialogoExitoRegistro();
		
		inicializarEtiquetasDialogoExitoRegistro();
		
	}
	/**
	 * 
	 * Descripcion: inicializacion de los datos de la ventana de dialogo al hacer la parte de disenio
	 * 
	 */
	private void inicializarDatosDialogoExitoRegistro() {
		
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setTitle("Registro finalizado.");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
	}
	/**
	 * 
	 * Descripcion: inicializacion de los datos de las etiquetas de la ventana de dialogo al hacer la parte de disenio
	 * 
	 */
	private void inicializarEtiquetasDialogoExitoRegistro() {
		
		//Datos etiqueta aviso 
		
		lblExitoRegistro = new JLabel("Los datos se han registrado correctamente.");
		lblExitoRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblExitoRegistro.setBounds(111, 22, 318, 46);
		getContentPane().add(lblExitoRegistro);
		
		//Datos etiqueta aviso foto 
		
		lblFotoRegistroExito = new JLabel("");
		lblFotoRegistroExito.setIcon(new ImageIcon(AvisoExitoRegistro.class.getResource("/recursos/cheque.png")));
		lblFotoRegistroExito.setBounds(228, 71, 68, 76);
		getContentPane().add(lblFotoRegistroExito);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AvisoExitoRegistro.class.getResource("/recursos/informacion.png")));
		setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 521, 213);
		
	}
}
