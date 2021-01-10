package Presentacion.Actividad;

import java.awt.AWTKeyStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import javax.swing.JFormattedTextField;

import Persistencia.gestorActividad;
import Persistencia.gestorPerfil;
import Persistencia.gestorRutas;
import Persistencia.gestorUsuario;
import Presentacion.InicioSesion.VentanaInicio;
import Presentacion.Principal.AplicacionPrincipal;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import com.toedter.components.JLocaleChooser;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

public class FormularioRegistroBajaActividad extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtNombreActividadBaja;
	private JLabel lblNombreActividadBaja;
	private JLabel lblComprobarNombreActividadBaja;
	
	private JButton btnRegistroRutaTerminado;
	private JButton btnRegistroRutaCancelado;

	//Creaccion de colores como atributos privados a nivel de clase
	
	private Color colorBlanco = new Color (255,255,255);
	private Color colorResaltado = new Color (255,255,210);	
	private Color colorVerde = new Color(0, 143, 57);
	
	//Creaccion de atributos privados a nivel de clase para determinar mediante colores acciones correctas o no
	
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(colorVerde);
	
	//Atributo que permite las operaciones con la base de datos
	
	private gestorActividad metodos_gestor_actividad = new gestorActividad();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioRegistroBajaActividad frame = new FormularioRegistroBajaActividad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioRegistroBajaActividad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inicializarDatosFormularioRegistro();
		
		//Inicializacion de los datos con respecto a los dos primeros campos agrupados
		inicializarDatosPrimerAgrupamiento();
		
		//Inicializacion de los datos con respecto a los cuatro siguientes campos agrupados
		inicializarDatosSegundoAgrupamiento();
		
		//Inicializacion de los datos con respecto a los tres ultimos campos agrupados
		inicializarDatosTercerAgrupamiento();
	
		//Inicializacion de los datos con respecto a los dos check box
		inicializarDatosAgrupamientoCheckBox();
		
		//Inicializacion botones
		inicializarDatosBotones();
		
		asociacionOyentesFormularioRegistro();
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene todos los oyentes del Formulario Registro
	 * 
	 */
	private void asociacionOyentesFormularioRegistro() {
		
		btnRegistroRutaTerminado.addActionListener(new BtnFinalizarRegistroActionListener());
		btnRegistroRutaCancelado.addActionListener(new BtnCancelarRegistroActionListener());
		
		txtNombreActividadBaja.addFocusListener(new TxtFormularioRegistroFocusListener());
			
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrarel registro
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra cerrar el registro
	 */
	private int  dialogoCerrarRegistro() {
		
		int opcion = -1;
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarRegistroMensaje = new JLabel("¿Está seguro que desea cerrar el registro? Los datos no seran guardados.");
		labelDialogoCerrarRegistroMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		if (MiPanelEditarActividad.frame_registro_actividad_baja != null) {
			opcion = JOptionPane.showOptionDialog(MiPanelEditarActividad.frame_registro_actividad_baja, labelDialogoCerrarRegistroMensaje, "Aviso de cierre registro.", 0, 2, null, botones_list, null);
		}
		
		return opcion;
	}
	/**
	 * 
	 * Descripcion: Cancelar el resgistro y salirse si el usuario lo desea
	 *
	 */
	private class BtnCancelarRegistroActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int opcion_registro = -1;
			
			if (MiPanelEditarActividad.frame_registro_actividad_baja != null) {
				opcion_registro = dialogoCerrarRegistro();
				if(opcion_registro == 0) {
					MiPanelEditarActividad.frame_registro_actividad_baja.dispose();
				}
			}
		}
	}
	
	private class TxtFormularioRegistroFocusListener extends FocusAdapter {
		
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(colorResaltado);
			
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorBlanco);
		}
		
	}
	
	
	private int ComprobacionNombreActividadRegistrado() {
		
		
		int comprobar_actividad_registrado = -1;
		
		if (txtNombreActividadBaja.getText() != null) {
			comprobar_actividad_registrado = metodos_gestor_actividad.buscarNombreActividadRegistrado(txtNombreActividadBaja.getText().toString());
			if(comprobar_actividad_registrado == 0) {
				lblComprobarNombreActividadBaja.setText("Actividad disponible");
				txtNombreActividadBaja.setBorder(bordeVerde);
			}
			else {
				
				txtNombreActividadBaja.setBorder(bordeRojo);
				lblComprobarNombreActividadBaja.setText("No hay actividad con ese nombre");
				
			}
	
		}
		
		return comprobar_actividad_registrado;
		
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que faltan campos por completar
	 * 
	 */
	private void dialogoCamposIncompletos() {
		
		//Datos dialogo aviso en el registro
		
		JLabel labelDialogoRegistroIncompletoMensaje = new JLabel("Termine de completar los campos que faltan.");
		labelDialogoRegistroIncompletoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		//Mensaje
		
		JOptionPane.showMessageDialog(MiPanelEditarActividad.frame_registro_actividad_baja, labelDialogoRegistroIncompletoMensaje, "Campos incompletos.", 2);
		
	}
	
	private class BtnFinalizarRegistroActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			int comprobar_actividad_nombre = ComprobacionNombreActividadRegistrado();
			
			
			
			if (txtNombreActividadBaja.getText().equals("")) {
				
				dialogoCamposIncompletos();
				
				if (lblComprobarNombreActividadBaja.getText() != "Actividad disponible") {
					txtNombreActividadBaja.setBorder(bordeRojo);
				}
				
				if (txtNombreActividadBaja.getText().equals("")) {
					
					dialogoNoDatos();
					
					txtNombreActividadBaja.setBorder(bordeRojo);
				}
				
				
				comprobarDatosFormularioBajaActividad();
				
				
			}
			else {
				
				if(comprobar_actividad_nombre == 0) {
					
					txtNombreActividadBaja.setBorder(bordeVerde);
					
					eliminarDatosActividad();
					
					MiPanelEditarActividad.frame_registro_actividad_baja.dispose();
					
				}			
			}
		}
	}
	

	private void eliminarDatosActividad() {
		
		
		int confirmar_decision = dialogoRealizarOperacion();
		
		if(confirmar_decision == 0) {
			
			int validar_eliminacion = metodos_gestor_actividad.eliminarActividad(txtNombreActividadBaja.getText().toString());
			
			if(validar_eliminacion != -1) {
				
				dialogoActividadEliminadaExitoso();
				AplicacionPrincipal.frmAplicacinPrincipalDe.dispose();
				//System.exit(0);
				
				
			}
			else {
				dialogoErrorEliminacionActividadBaja();
			}
			
		}
	
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que sus datos han sigo registrados correctamente
	 * 
	 */
	private void dialogoActividadEliminadaExitoso() {
				
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos han sido eliminados correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(MiPanelEditarActividad.frame_registro_actividad_baja, labelDialogoRegistroCorrectoMensaje, "Datos eliminados.", 1);
			
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que sus datos no han sigo registrados
	 * 
	 */
	private void dialogoErrorEliminacionActividadBaja() {
		
		//Datos dialogo error registrar datos
		
		JLabel labelDialogoRegistroErrorMensaje = new JLabel("No se han podido actualizar los datos.");
		labelDialogoRegistroErrorMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JOptionPane.showMessageDialog(MiPanelEditarActividad.frame_registro_actividad_baja, labelDialogoRegistroErrorMensaje, "Error eliminacion actividad.", 0);
			
	}
	
	/**
	 * 
	 * Descripcion: Datos generados de la parte de diseño al inicializar es estilo que tendra esta parte de la aplicacion
	 * 
	 */
	private void inicializarDatosFormularioRegistro() {
		
		setTitle("Ventana Formulario Baja Actividad.");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioRegistroBajaActividad.class.getResource("/recursos/Form.png")));
		
		setFont(new Font("Segoe UI", Font.BOLD, 16));
		setBounds(new Rectangle(50, 50, 500, 300));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Formulario Baja", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{99, 132, 73, 84, 193, 47, 0};
		gbl_contentPane.rowHeights = new int[]{320, 29, 33, 30, 31, 30, 24, 36, 29, 31, 33, 32, 32, 32, 0, 32, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//Permite al pulsat INTRO desplazarte entre campos
		
		Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
        teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
        
        getContentPane().setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, teclas);
		
	}
	private int dialogoRealizarOperacion() {
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarAplicacionMensaje = new JLabel("¿Está seguro que desea eliminar esta actividad?");
		labelDialogoCerrarAplicacionMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		return JOptionPane.showOptionDialog(null, labelDialogoCerrarAplicacionMensaje, "Aviso de cierre aplicacion principal.", 0, 2, null, botones_list, null);
	
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte disenio relacionados con los dos primeros campos similares del formulario
	 * 
	 */
	private void inicializarDatosPrimerAgrupamiento() {
		
	}
	/**
	 * 
	 * Descripcion: Datos generados con respecto a la parte de disenio del segundo grupo con caracteristicas similares
	 * 
	 */
	private void inicializarDatosSegundoAgrupamiento() {
		
		//Datos campos Nombre de Usuario
		
		lblNombreActividadBaja = new JLabel("Nombre ruta:");
		lblNombreActividadBaja.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombreActividadBaja = new GridBagConstraints();
		gbc_lblNombreActividadBaja.anchor = GridBagConstraints.EAST;
		gbc_lblNombreActividadBaja.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreActividadBaja.gridx = 1;
		gbc_lblNombreActividadBaja.gridy = 2;
		contentPane.add(lblNombreActividadBaja, gbc_lblNombreActividadBaja);
		
		txtNombreActividadBaja = new JTextField();
		GridBagConstraints gbc_txtNombreActividadBaja = new GridBagConstraints();
		gbc_txtNombreActividadBaja.gridwidth = 2;
		gbc_txtNombreActividadBaja.fill = GridBagConstraints.BOTH;
		gbc_txtNombreActividadBaja.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreActividadBaja.gridx = 2;
		gbc_txtNombreActividadBaja.gridy = 2;
		contentPane.add(txtNombreActividadBaja, gbc_txtNombreActividadBaja);
		txtNombreActividadBaja.setColumns(10);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte de disenio con respecto al ultimo grupo que tiene caracteristicas similares
	 * 
	 */
	private void inicializarDatosTercerAgrupamiento() {
		
		
		//Formaro al campo del telefono
		
		MaskFormatter formatoTlfno;
		try {
			formatoTlfno = new MaskFormatter("'(###')' ###' ###' ###");
			formatoTlfno.setPlaceholderCharacter('*');
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * Descripcion:Datos generados con respecto a la parte de disenio relacionados con los check box
	 * 
	 */
	private void inicializarDatosAgrupamientoCheckBox() {
		
	}
	/**
	 * 
	 * Descripcion: Inicializacion de los botones del Formulario Registro
	 * 
	 */
	private void inicializarDatosBotones() {
		
		lblComprobarNombreActividadBaja = new JLabel("");
		lblComprobarNombreActividadBaja.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblComprobarNombreActividadBaja = new GridBagConstraints();
		gbc_lblComprobarNombreActividadBaja.gridwidth = 2;
		gbc_lblComprobarNombreActividadBaja.anchor = GridBagConstraints.WEST;
		gbc_lblComprobarNombreActividadBaja.insets = new Insets(0, 0, 5, 5);
		gbc_lblComprobarNombreActividadBaja.gridx = 2;
		gbc_lblComprobarNombreActividadBaja.gridy = 3;
		contentPane.add(lblComprobarNombreActividadBaja, gbc_lblComprobarNombreActividadBaja);
		
		//Datos boton Cancelar el registro
		
		btnRegistroRutaCancelado = new JButton("Cancelar");
		btnRegistroRutaCancelado.setForeground(Color.WHITE);
		btnRegistroRutaCancelado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistroRutaCancelado.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnRegistroRutaCancelado = new GridBagConstraints();
		gbc_btnRegistroRutaCancelado.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroRutaCancelado.gridx = 2;
		gbc_btnRegistroRutaCancelado.gridy = 5;
		contentPane.add(btnRegistroRutaCancelado, gbc_btnRegistroRutaCancelado);
		
		//Datos boton Finalizar el registro
		
		btnRegistroRutaTerminado = new JButton("Guardar");
		btnRegistroRutaTerminado.setForeground(new Color(255, 255, 255));
		btnRegistroRutaTerminado.setBackground(new Color(51, 51, 51));
		btnRegistroRutaTerminado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistroRutaTerminado.setBounds(355, 192, 84, 31);
		GridBagConstraints gbc_btnRegistroRutaTerminado = new GridBagConstraints();
		gbc_btnRegistroRutaTerminado.anchor = GridBagConstraints.WEST;
		gbc_btnRegistroRutaTerminado.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroRutaTerminado.fill = GridBagConstraints.VERTICAL;
		gbc_btnRegistroRutaTerminado.gridx = 3;
		gbc_btnRegistroRutaTerminado.gridy = 5;
		contentPane.add(btnRegistroRutaTerminado, gbc_btnRegistroRutaTerminado);
		
	}
	
	
	private void comprobarDatosFormularioBajaActividad() {
		
		//Bordes Descripcion
		
		if (txtNombreActividadBaja.getText().equals("")) {
			txtNombreActividadBaja.setBorder(bordeRojo);
		}
	
			
		//Bordes Nombre ruta

		if (txtNombreActividadBaja.getText() != null) {
			
			int comprobar_nombre_actividad_sistema =  ComprobacionNombreActividadRegistrado();
			
			if(comprobar_nombre_actividad_sistema == 0) {
				lblComprobarNombreActividadBaja.setText("Actividad disponible");
				txtNombreActividadBaja.setBorder(bordeVerde);
			}
			else if (comprobar_nombre_actividad_sistema != 0 && txtNombreActividadBaja.getText().equals("") == false) {
				txtNombreActividadBaja.setBorder(bordeRojo);
				lblComprobarNombreActividadBaja.setText("No hay actividad con ese nombre");
			}
		}
		
	}
	private void dialogoNoDatos() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("No se han introducido datos.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(MiPanelEditarActividad.frame_registro_actividad_baja, labelDialogoRegistroCorrectoMensaje, "Datos no introducidos.", 2);
			
	}
	
}
