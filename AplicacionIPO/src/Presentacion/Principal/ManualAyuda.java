package Presentacion.Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import Traductor.Messages;

public class ManualAyuda {

	private JFrame frmManualAplicacion;
	private JScrollPane scrollPane;
	private JEditorPane dtrpnElPropsitoDe;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManualAyuda window = new ManualAyuda();
					window.frmManualAplicacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManualAyuda() {
		
		initialize();
		
		centrarManualAyuda();
			
	}
	/**
	 * 
	 * Descripcion: Metodo para centrar el menu ayuda
	 * 
	 */
	private void centrarManualAyuda() {
		
		this.getJFrameManualAyuda().setLocationRelativeTo(null);
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		inicializarDatosManualAyuda();
		
		cerrarManualAyuda();
		
	
	}
	/**
	 * 
	 * Descripcion: Permite cerrar el manual
	 * 
	 */
	private void cerrarManualAyuda() {
		
		
		try {
			getJFrameManualAyuda().setDefaultCloseOperation(getJFrameManualAyuda().DO_NOTHING_ON_CLOSE);
			getJFrameManualAyuda().addWindowListener(new cerrarManualWindowAdapter());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	/**
	 * 
	 * Descripcion: Permite cerrar el manual al pulsar el boton de la cruz
	 *
	 */
	private class cerrarManualWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			
			int confirmar_cerrar_manual = dialogoCerrarManual();
			
			if (confirmar_cerrar_manual == 0) {
				getJFrameManualAyuda().dispose();
			}
			
		}
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrar el manual
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra el manual ayuda
	 */
	private int dialogoCerrarManual() {
		
		//Mensaje de cerrar manual
		
		JLabel labelDialogoAyudaMensaje = new JLabel("¿Está seguro que desea cerrar el manual?");
		labelDialogoAyudaMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		return JOptionPane.showOptionDialog(getJFrameManualAyuda(), labelDialogoAyudaMensaje, "Aviso de cierre manual ayuda.", 0, 1, null, botones_list, null);
	
	}
	/**
	 * 
	 * Descripcion: inicializacion de los datos de la parte de disenio del manual ayuda
	 * 
	 */
	private void inicializarDatosManualAyuda() {
		
		frmManualAplicacion = new JFrame();
		frmManualAplicacion.setIconImage(Toolkit.getDefaultToolkit().getImage(ManualAyuda.class.getResource("/recursos/inforManual.png")));
		frmManualAplicacion.getContentPane().setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{56, 0, 0, 57, 88, 0, 0};
		gridBagLayout.rowHeights = new int[]{44, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		frmManualAplicacion.getContentPane().setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel(Messages.getString("ManualAyuda.lblNewLabel.text")); //$NON-NLS-1$
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		frmManualAplicacion.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		frmManualAplicacion.getContentPane().add(scrollPane, gbc_scrollPane);
		
		dtrpnElPropsitoDe = new JEditorPane();
		dtrpnElPropsitoDe.setText(Messages.getString("ManualAyuda.dtrpnElPropsitoDe.text")); //$NON-NLS-1$
		dtrpnElPropsitoDe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		dtrpnElPropsitoDe.setEditable(false);
		scrollPane.setViewportView(dtrpnElPropsitoDe);
		frmManualAplicacion.setResizable(false);
		frmManualAplicacion.setTitle(Messages.getString("ManualAyuda.frmManualAplicacion.title")); //$NON-NLS-1$
		frmManualAplicacion.setBounds(100, 100, 758, 435);
		frmManualAplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * 
	 * Descripcion: Metodo get para poder obtener el frame del manual ayuda porque estamos trabajando con un Application Window
	 * 
	 * @return frame del manuak ayuda
	 */
	public JFrame getJFrameManualAyuda() {
		
		return frmManualAplicacion;
		
	}
	
}
