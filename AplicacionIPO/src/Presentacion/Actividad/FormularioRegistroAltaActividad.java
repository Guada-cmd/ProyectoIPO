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
import Presentacion.Principal.AplicacionPrincipal;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import com.toedter.components.JLocaleChooser;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import Traductor.Messages;

public class FormularioRegistroAltaActividad extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtNombreActividad;
	private JTextField txtDescripcionActividad;
	private JTextField txtPrecioActividad;
	
	private JLabel lblDescripcionActividad;
	private JLabel lblNombreActividad;
	private JLabel lblMaterialActividad;
	private JLabel lblPrecioActividad;
	private JLabel lblHoraInicioActividad;
	private JLabel lblAreaActividad;
	private JLabel lblMximoActividad;
	private JLabel lblComprobarNombreActividad;
	private JLabel lblHoraFinActividad;
	private JLabel lblDiaActividad;
	private JLabel lblDirigida;
	
	private JComboBox cmbAreaActividad;
	private JComboBox cmbMaterialActividad;
	private JComboBox cmbHoraInicioActividad;
	private JComboBox cmbHoraFinActividad;
	private JComboBox cmbDiaActividad;
	private JComboBox cmbDestinadaActividad;

	private JSpinner spnMaximoActividad;
	
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
					FormularioRegistroAltaActividad frame = new FormularioRegistroAltaActividad();
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
	public FormularioRegistroAltaActividad() {
		
		inicializarDatosFormularioAlta();
		
		//Inicializacion de los datos con respecto a los dos primeros campos agrupados
		inicializarDatosPrimerAgrupamiento();
		
		//Inicializacion de los datos con respecto a los cuatro siguientes campos agrupados
		inicializarDatosSegundoAgrupamiento();
		
		//Inicializacion de los datos con respecto a los tres ultimos campos agrupados
		inicializarDatosTercerAgrupamiento();
		
		//Inicializacion de los datos con respecto a los botones
		inicializarDatosBotonesFormularioAlta();
		
		asociacionOyentesFormularioAlta();
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene todos los oyentes del Formulario Alta
	 * 
	 */
	private void asociacionOyentesFormularioAlta() {
		
		btnRegistroRutaTerminado.addActionListener(new BtnFinalizarRegistroActionListener());
		btnRegistroRutaCancelado.addActionListener(new BtnCancelarRegistroActionListener());
		
		txtNombreActividad.addFocusListener(new TxtFormularioRegistroFocusListener());
		txtDescripcionActividad.addFocusListener(new TxtFormularioRegistroFocusListener());
		txtPrecioActividad.addFocusListener(new TxtFormularioRegistroFocusListener());
			
	}
	/**
	 * 
	 * Descripcion: Cancelar el resgistro y salirse si el usuario lo desea
	 *
	 */
	private class BtnCancelarRegistroActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int opcion_registro = -1;
			
			if (MiPanelEditarActividad.frame_registro_actividad_alta != null) {
				opcion_registro = dialogoCerrarRegistro();
				if(opcion_registro == 0) {
					MiPanelEditarActividad.frame_registro_actividad_alta.dispose();
				}
			}
		}
	}
	/**
	 * 
	 * Descripcion: Finalizar dar de alta la actividad
	 *
	 */
	private class BtnFinalizarRegistroActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			int comprobarnombre_actividad = ComprobacionNombreActividadRegistrado();
			int validacion = 0;
			
			
			if (txtNombreActividad.getText().equals("") || comprobarnombre_actividad == 0 || txtDescripcionActividad.getText().equals("")
					|| txtPrecioActividad.getText().equals("")) {
				
				dialogoCamposIncompletos();
				
				if (lblComprobarNombreActividad.getText().equals("Nombre en uso")) {
					txtNombreActividad.setBorder(bordeRojo);
				}
				

				if (txtNombreActividad.getText().equals("")) {
					txtNombreActividad.setBorder(bordeRojo);
				}
				
				if (txtDescripcionActividad.getText().equals("")) {
					txtDescripcionActividad.setBorder(bordeRojo);
				}
				
				if (txtPrecioActividad.getText().equals("")) {
					txtPrecioActividad.setBorder(bordeRojo);
				}
			
				comprobarDatosFormularioAltaActividad();
				
			}
			else {
							
				txtNombreActividad.setBorder(bordeVerde);
				txtDescripcionActividad.setBorder(bordeVerde);
				txtPrecioActividad.setBorder(bordeVerde);
					
				validacion = insertarDatosActividad();
					
				//Para cerrar la ventana del formulario y no se puedan introducir mas datos
					
				if (MiPanelEditarActividad.frame_registro_actividad_alta != null) {	
					MiPanelEditarActividad.frame_registro_actividad_alta.dispose();	
				}
					
				//Mostrar cuadros de dialogos correspondientes
					
				if(validacion > 0) {
					dialogoRegistroExitoso();
						
				}
				else {
					dialogoErrorRegistro();
				}
			}
		}
	}
	/**
	 * 
	 * Descripcion: Comprobar que la actividad registrada no tenga el mismo nombre que otra
	 * 
	 * @return
	 */
	private int ComprobacionNombreActividadRegistrado() {
		
		
		int comprobar_nombre_registrado = -1;
		
		if (txtNombreActividad.getText() != null) {
			comprobar_nombre_registrado = metodos_gestor_actividad.buscarNombreActividadRegistrado(txtNombreActividad.getText().toString());
			if(comprobar_nombre_registrado == 0) {
				lblComprobarNombreActividad.setText("Nombre en uso");
				txtNombreActividad.setBorder(bordeRojo);
			}
		}
		
		return comprobar_nombre_registrado;
		
	}
	/**
	 * 
	 * Descripcion: cambiar el foco en los txt
	 *
	 */
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
	/**
	 * 
	 * Descripcion: Comprobacion de los registros antes de dar de alta
	 * 
	 */
	private void comprobarDatosFormularioAltaActividad() {
		
		//Bordes Descripcion
		
		if (txtDescripcionActividad.getText().equals("")) {
			txtDescripcionActividad.setBorder(bordeRojo);
		}
		else {
			txtDescripcionActividad.setBorder(bordeVerde);
		}
		
		if(txtPrecioActividad.getText().equals("")) {
			txtPrecioActividad.setBorder(bordeRojo);
		}
		else {
			txtPrecioActividad.setBorder(bordeVerde);
		}
		
		//Bordes Nombre ruta

		if (txtNombreActividad.getText() != null) {
			
			int comprobar_nombre_registrado_sistema = ComprobacionNombreActividadRegistrado();
			
			if(comprobar_nombre_registrado_sistema == 0) {
				lblComprobarNombreActividad.setText("Nombre en uso");
				txtNombreActividad.setBorder(bordeRojo);
			}
			else if (comprobar_nombre_registrado_sistema != 0 && txtNombreActividad.getText().equals("") == false) {
				txtNombreActividad.setBorder(bordeVerde);
				lblComprobarNombreActividad.setText("Nombre disponible");
			}
		}
	}
	/**
	 * 
	 * Descripcion: Metodo para insertar una actividad
	 * 
	 * @return
	 */
	private int insertarDatosActividad() {
		
		int comprobacion = 0;
		String cadena_formato_horario = null;
		
		//Codigo que permite insertar los datos en la base de datos
	

		cadena_formato_horario = (String)cmbDiaActividad.getSelectedItem()+" "+(String)cmbHoraInicioActividad.getSelectedItem()+" - "+(String)cmbHoraFinActividad.getSelectedItem();
		
		comprobacion = metodos_gestor_actividad.insertarActividad(txtNombreActividad.getText().toString(), cadena_formato_horario, 2,
				(Integer) spnMaximoActividad.getValue(), (String)cmbDestinadaActividad.getSelectedItem(), txtPrecioActividad.getText().toString(), 
				(String)cmbAreaActividad.getSelectedItem(), txtDescripcionActividad.getText().toString(), (String)cmbMaterialActividad.getSelectedItem());
		

		return comprobacion;
	}
	/**
	 * 
	 * Descripcion: Inicializacion datos botones
	 * 
	 */
	private void inicializarDatosBotonesFormularioAlta() {
		
		//Datos boton Cancelar el registro
		
		btnRegistroRutaCancelado = new JButton(Messages.getString("FormularioRegistroAltaActividad.btnRegistroRutaCancelado.text")); //$NON-NLS-1$
		btnRegistroRutaCancelado.setForeground(Color.WHITE);
		btnRegistroRutaCancelado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistroRutaCancelado.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnRegistroRutaCancelado = new GridBagConstraints();
		gbc_btnRegistroRutaCancelado.anchor = GridBagConstraints.EAST;
		gbc_btnRegistroRutaCancelado.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroRutaCancelado.gridx = 2;
		gbc_btnRegistroRutaCancelado.gridy = 14;
		contentPane.add(btnRegistroRutaCancelado, gbc_btnRegistroRutaCancelado);
			
		//Datos boton Finalizar el registro
		
		btnRegistroRutaTerminado = new JButton(Messages.getString("FormularioRegistroAltaActividad.btnRegistroRutaTerminado.text")); //$NON-NLS-1$
		btnRegistroRutaTerminado.setForeground(new Color(255, 255, 255));
		btnRegistroRutaTerminado.setBackground(new Color(51, 51, 51));
		btnRegistroRutaTerminado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistroRutaTerminado.setBounds(355, 192, 84, 31);
		GridBagConstraints gbc_btnRegistroRutaTerminado = new GridBagConstraints();
		gbc_btnRegistroRutaTerminado.anchor = GridBagConstraints.WEST;
		gbc_btnRegistroRutaTerminado.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroRutaTerminado.fill = GridBagConstraints.VERTICAL;
		gbc_btnRegistroRutaTerminado.gridx = 3;
		gbc_btnRegistroRutaTerminado.gridy = 14;
		contentPane.add(btnRegistroRutaTerminado, gbc_btnRegistroRutaTerminado);
		
	}
	/**
	 * 
	 * Descripcion: Inicializacion de los botones del Formulario Registro
	 * 
	 */
	private void inicializarDatosTercerAgrupamiento() {
		
		//Datos campos Hora inicio
		
		lblHoraInicioActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblHoraInicioActividad.text")); //$NON-NLS-1$
		lblHoraInicioActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHoraInicioActividad = new GridBagConstraints();
		gbc_lblHoraInicioActividad.anchor = GridBagConstraints.EAST;
		gbc_lblHoraInicioActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicioActividad.gridx = 1;
		gbc_lblHoraInicioActividad.gridy = 10;
		contentPane.add(lblHoraInicioActividad, gbc_lblHoraInicioActividad);
		
		cmbHoraInicioActividad = new JComboBox();
		cmbHoraInicioActividad.setModel(new DefaultComboBoxModel(new String[] {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		cmbHoraInicioActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbHoraInicioActividad.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbHoraInicioActividad = new GridBagConstraints();
		gbc_cmbHoraInicioActividad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbHoraInicioActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbHoraInicioActividad.gridx = 2;
		gbc_cmbHoraInicioActividad.gridy = 10;
		contentPane.add(cmbHoraInicioActividad, gbc_cmbHoraInicioActividad);
		
		//Datos campos Hora Fin
		
		lblHoraFinActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblHoraFinActividad.text")); //$NON-NLS-1$
		lblHoraFinActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHoraFinActividad = new GridBagConstraints();
		gbc_lblHoraFinActividad.anchor = GridBagConstraints.EAST;
		gbc_lblHoraFinActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraFinActividad.gridx = 1;
		gbc_lblHoraFinActividad.gridy = 11;
		contentPane.add(lblHoraFinActividad, gbc_lblHoraFinActividad);
		
		//Datos campos fecha
		
		cmbHoraFinActividad = new JComboBox();
		cmbHoraFinActividad.setModel(new DefaultComboBoxModel(new String[] {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		cmbHoraFinActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbHoraFinActividad.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbHoraFinActividad = new GridBagConstraints();
		gbc_cmbHoraFinActividad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbHoraFinActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbHoraFinActividad.gridx = 2;
		gbc_cmbHoraFinActividad.gridy = 11;
		contentPane.add(cmbHoraFinActividad, gbc_cmbHoraFinActividad);
		
		lblDiaActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblDiaActividad.text")); //$NON-NLS-1$
		lblDiaActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDiaActividad = new GridBagConstraints();
		gbc_lblDiaActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaActividad.anchor = GridBagConstraints.EAST;
		gbc_lblDiaActividad.gridx = 1;
		gbc_lblDiaActividad.gridy = 12;
		contentPane.add(lblDiaActividad, gbc_lblDiaActividad);
		
		cmbDiaActividad = new JComboBox();
		cmbDiaActividad.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"}));
		cmbDiaActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbDiaActividad.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbDiaActividad = new GridBagConstraints();
		gbc_cmbDiaActividad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbDiaActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDiaActividad.gridx = 2;
		gbc_cmbDiaActividad.gridy = 12;
		contentPane.add(cmbDiaActividad, gbc_cmbDiaActividad);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados con respecto a la parte de disenio del segundo grupo con caracteristicas similares
	 * 
	 */
	private void inicializarDatosSegundoAgrupamiento() {
			
		// Datos campos precio
		
		lblPrecioActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblPrecioActividad.text")); //$NON-NLS-1$
		lblPrecioActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPrecioActividad = new GridBagConstraints();
		gbc_lblPrecioActividad.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioActividad.gridx = 1;
		gbc_lblPrecioActividad.gridy = 4;
		contentPane.add(lblPrecioActividad, gbc_lblPrecioActividad);
		
		txtPrecioActividad = new JTextField();
		GridBagConstraints gbc_txtPrecioActividad = new GridBagConstraints();
		gbc_txtPrecioActividad.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecioActividad.fill = GridBagConstraints.BOTH;
		gbc_txtPrecioActividad.gridx = 2;
		gbc_txtPrecioActividad.gridy = 4;
		contentPane.add(txtPrecioActividad, gbc_txtPrecioActividad);
		txtPrecioActividad.setColumns(10);
		
		
		//Datos campos Material
		
		lblMaterialActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblMaterialActividad.text")); //$NON-NLS-1$
		lblMaterialActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMaterialActividad = new GridBagConstraints();
		gbc_lblMaterialActividad.anchor = GridBagConstraints.EAST;
		gbc_lblMaterialActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterialActividad.gridx = 1;
		gbc_lblMaterialActividad.gridy = 5;
		contentPane.add(lblMaterialActividad, gbc_lblMaterialActividad);
		
		cmbMaterialActividad = new JComboBox();
		cmbMaterialActividad.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Bañador", "Ropa Tenis", "Equipación baloncesto", "Zapato deportivo", "Chandal"}));
		cmbMaterialActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbMaterialActividad.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbMaterialActividad = new GridBagConstraints();
		gbc_cmbMaterialActividad.gridwidth = 2;
		gbc_cmbMaterialActividad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbMaterialActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbMaterialActividad.gridx = 2;
		gbc_cmbMaterialActividad.gridy = 5;
		contentPane.add(cmbMaterialActividad, gbc_cmbMaterialActividad);
		
		//Datos Area
		
		lblAreaActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblAreaActividad.text")); //$NON-NLS-1$
		lblAreaActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAreaActividad = new GridBagConstraints();
		gbc_lblAreaActividad.anchor = GridBagConstraints.EAST;
		gbc_lblAreaActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblAreaActividad.gridx = 1;
		gbc_lblAreaActividad.gridy = 6;
		contentPane.add(lblAreaActividad, gbc_lblAreaActividad);
		
		cmbAreaActividad = new JComboBox();
		cmbAreaActividad.setBackground(new Color(248, 248, 255));
		cmbAreaActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbAreaActividad.setModel(new DefaultComboBoxModel(new String[] {"Pistas", "Piscina", "Gimnasio", "Carpa", "Zona de práctica tiro con arco", "Patio zona alta"}));
		GridBagConstraints gbc_cmbAreaActividad = new GridBagConstraints();
		gbc_cmbAreaActividad.gridwidth = 2;
		gbc_cmbAreaActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAreaActividad.anchor = GridBagConstraints.NORTH;
		gbc_cmbAreaActividad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbAreaActividad.gridx = 2;
		gbc_cmbAreaActividad.gridy = 6;
		contentPane.add(cmbAreaActividad, gbc_cmbAreaActividad);
		
		//Datos destinada
		
		lblDirigida = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblDirigida.text")); //$NON-NLS-1$
		lblDirigida.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDirigida = new GridBagConstraints();
		gbc_lblDirigida.anchor = GridBagConstraints.EAST;
		gbc_lblDirigida.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirigida.gridx = 1;
		gbc_lblDirigida.gridy = 7;
		contentPane.add(lblDirigida, gbc_lblDirigida);
		
		cmbDestinadaActividad = new JComboBox();
		cmbDestinadaActividad.setModel(new DefaultComboBoxModel(new String[] {"Todos los públicos", "Niños", "Adultos"}));
		cmbDestinadaActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbDestinadaActividad.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbDestinadaActividad = new GridBagConstraints();
		gbc_cmbDestinadaActividad.gridwidth = 2;
		gbc_cmbDestinadaActividad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbDestinadaActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDestinadaActividad.gridx = 2;
		gbc_cmbDestinadaActividad.gridy = 7;
		contentPane.add(cmbDestinadaActividad, gbc_cmbDestinadaActividad);
		
		//Datos maximo numero de personas
		
		lblMximoActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblMximoActividad.text")); //$NON-NLS-1$
		lblMximoActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMximoActividad = new GridBagConstraints();
		gbc_lblMximoActividad.anchor = GridBagConstraints.EAST;
		gbc_lblMximoActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblMximoActividad.gridx = 1;
		gbc_lblMximoActividad.gridy = 8;
		contentPane.add(lblMximoActividad, gbc_lblMximoActividad);
		
		spnMaximoActividad = new JSpinner();
		spnMaximoActividad.setModel(new SpinnerNumberModel(2, 2, 50, 1));
		GridBagConstraints gbc_spnMaximoActividad = new GridBagConstraints();
		gbc_spnMaximoActividad.fill = GridBagConstraints.VERTICAL;
		gbc_spnMaximoActividad.anchor = GridBagConstraints.WEST;
		gbc_spnMaximoActividad.insets = new Insets(0, 0, 5, 5);
		gbc_spnMaximoActividad.gridx = 2;
		gbc_spnMaximoActividad.gridy = 8;
		contentPane.add(spnMaximoActividad, gbc_spnMaximoActividad);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte disenio relacionados con los dos primeros campos similares del formulario
	 * 
	 */
	private void inicializarDatosPrimerAgrupamiento() {
		
		//Datos campos Nombre de Actividad
		
		lblNombreActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblNombreActividad.text")); //$NON-NLS-1$
		lblNombreActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombreActividad = new GridBagConstraints();
		gbc_lblNombreActividad.anchor = GridBagConstraints.EAST;
		gbc_lblNombreActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreActividad.gridx = 1;
		gbc_lblNombreActividad.gridy = 1;
		contentPane.add(lblNombreActividad, gbc_lblNombreActividad);
		
		txtNombreActividad = new JTextField();
		GridBagConstraints gbc_txtNombreActividad = new GridBagConstraints();
		gbc_txtNombreActividad.fill = GridBagConstraints.BOTH;
		gbc_txtNombreActividad.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreActividad.gridx = 2;
		gbc_txtNombreActividad.gridy = 1;
		contentPane.add(txtNombreActividad, gbc_txtNombreActividad);
		txtNombreActividad.setColumns(10);
		
		lblComprobarNombreActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblComprobarNombreActividad.text")); //$NON-NLS-1$
		lblComprobarNombreActividad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblComprobarNombreActividad = new GridBagConstraints();
		gbc_lblComprobarNombreActividad.gridwidth = 2;
		gbc_lblComprobarNombreActividad.anchor = GridBagConstraints.WEST;
		gbc_lblComprobarNombreActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblComprobarNombreActividad.gridx = 3;
		gbc_lblComprobarNombreActividad.gridy = 1;
		contentPane.add(lblComprobarNombreActividad, gbc_lblComprobarNombreActividad);
		
		//Datos campos Descripcion
		
		lblDescripcionActividad = new JLabel(Messages.getString("FormularioRegistroAltaActividad.lblDescripcionActividad.text")); //$NON-NLS-1$
		lblDescripcionActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDescripcionActividad = new GridBagConstraints();
		gbc_lblDescripcionActividad.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcionActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionActividad.gridx = 1;
		gbc_lblDescripcionActividad.gridy = 2;
		contentPane.add(lblDescripcionActividad, gbc_lblDescripcionActividad);
		
		txtDescripcionActividad = new JTextField();
		GridBagConstraints gbc_txtDescripcionActividad = new GridBagConstraints();
		gbc_txtDescripcionActividad.gridwidth = 2;
		gbc_txtDescripcionActividad.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcionActividad.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcionActividad.gridx = 2;
		gbc_txtDescripcionActividad.gridy = 2;
		contentPane.add(txtDescripcionActividad, gbc_txtDescripcionActividad);
		txtDescripcionActividad.setColumns(10);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte de diseño al inicializar es estilo que tendra esta parte de la aplicacion
	 * 
	 */
	private void inicializarDatosFormularioAlta() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Messages.getString("FormularioRegistroAltaActividad.this.title")); //$NON-NLS-1$
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioRegistroAltaActividad.class.getResource("/recursos/Form.png")));
		
		setFont(new Font("Segoe UI", Font.BOLD, 16));
		setBounds(new Rectangle(50, 50, 500, 625));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), Messages.getString("FormularioRegistroAltaActividad.contentPane.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{83, 132, 127, 84, 113, 47, 0};
		gbl_contentPane.rowHeights = new int[]{54, 29, 33, 30, 31, 30, 32, 36, 37, 31, 33, 32, 32, 32, 0, 32, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//Permite al pulsat INTRO desplazarte entre campos
		
		Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
        teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
        
        getContentPane().setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, teclas);
		
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrarel registro
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra cerrar el registro
	 */
	private int dialogoCerrarRegistro() {
		
		int opcion = -1;
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarRegistroMensaje = new JLabel("¿Está seguro que desea cerrar el registro? Los datos no seran guardados.");
		labelDialogoCerrarRegistroMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		if (MiPanelEditarActividad.frame_registro_actividad_alta != null) {
			opcion = JOptionPane.showOptionDialog(MiPanelEditarActividad.frame_registro_actividad_alta, labelDialogoCerrarRegistroMensaje, "Aviso de cierre registro.", 0, 2, null, botones_list, null);
		}
		
		return opcion;
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
		
		JOptionPane.showMessageDialog(MiPanelEditarActividad.frame_registro_actividad_alta, labelDialogoRegistroIncompletoMensaje, "Campos incompletos.", 2);
		
	}
	
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que sus datos han sigo registrados correctamente
	 * 
	 */
	private void dialogoRegistroExitoso() {
				
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos han sido registrados correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(MiPanelEditarActividad.frame_registro_actividad_alta, labelDialogoRegistroCorrectoMensaje, "Datos guardados.", 1);
			
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que sus datos no han sigo registrados
	 * 
	 */
	private void dialogoErrorRegistro() {
		
		//Datos dialogo error registrar datos
		
		JLabel labelDialogoRegistroErrorMensaje = new JLabel("No se han podido registrar los datos.");
		labelDialogoRegistroErrorMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JOptionPane.showMessageDialog(MiPanelEditarActividad.frame_registro_actividad_alta, labelDialogoRegistroErrorMensaje, "Error registro.", 0);
			
	}
	
}
