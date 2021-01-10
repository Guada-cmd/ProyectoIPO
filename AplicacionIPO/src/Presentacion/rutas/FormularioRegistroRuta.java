package Presentacion.rutas;

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

public class FormularioRegistroRuta extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtNombreRuta;
	private JTextField txtDescripcionRuta;
	
	private JLabel lblDescripcionRuta;
	private JLabel lblNombreRuta;
	private JLabel lblEquipamiento;
	private JLabel lblDificultad;
	private JLabel lblHoraInicio;
	private JLabel lblEncuentro;
	private JLabel lblMximo;
	private JLabel lblComprobarNombreRuta;
	private JLabel lblFechaRuta;
	
	private JComboBox cmbPuntoEncuentro;
	private JComboBox cmbDificultad;
	private JComboBox cmbEquipamiento;
	
	private JSpinner spnMaximo;

	private JDateChooser dcFechaRuta; 
	
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
	
	private gestorRutas metodos_gestor_rutas = new gestorRutas();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioRegistroRuta frame = new FormularioRegistroRuta();
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
	public FormularioRegistroRuta() {
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
		txtNombreRuta.addFocusListener(new TxtFormularioRegistroFocusListener());
			
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
		
		if (MiPanelCrearRuta.frame_registro_rutas != null) {
			opcion = JOptionPane.showOptionDialog(MiPanelCrearRuta.frame_registro_rutas, labelDialogoCerrarRegistroMensaje, "Aviso de cierre registro.", 0, 2, null, botones_list, null);
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
			
			if (MiPanelCrearRuta.frame_registro_rutas != null) {
				opcion_registro = dialogoCerrarRegistro();
				if(opcion_registro == 0) {
					MiPanelCrearRuta.frame_registro_rutas.dispose();
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
	
	
	private int ComprobacionNombreRutaRegistrado() {
		
		
		int comprobar_nombre_registrado = -1;
		
		if (txtNombreRuta.getText() != null) {
			comprobar_nombre_registrado = metodos_gestor_rutas.buscarNombreRutaRegistrado(txtNombreRuta.getText().toString());
			if(comprobar_nombre_registrado == 0) {
				lblComprobarNombreRuta.setText("Nombre en uso");
				txtNombreRuta.setBorder(bordeRojo);
			}
		}
		
		return comprobar_nombre_registrado;
		
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
		
		JOptionPane.showMessageDialog(MiPanelCrearRuta.frame_registro_rutas, labelDialogoRegistroIncompletoMensaje, "Campos incompletos.", 2);
		
	}
	
	private class BtnFinalizarRegistroActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			int comprobar_usuario_nombre_ruata = ComprobacionNombreRutaRegistrado();
			int validacion = 0;
			
			
			if (txtNombreRuta.getText().equals("") || comprobar_usuario_nombre_ruata == 0 || txtDescripcionRuta.getText().equals("") || dcFechaRuta.getDate() == null) {
				
				dialogoCamposIncompletos();
				
				if (lblComprobarNombreRuta.getText().equals("Nombre en uso")) {
					txtNombreRuta.setBorder(bordeRojo);
				}
				
				if (txtNombreRuta.getText().equals("")) {
					txtNombreRuta.setBorder(bordeRojo);
				}
				
				if(dcFechaRuta.getDate() == null) {
					dcFechaRuta.setBorder(bordeRojo);
				}
				
				comprobarDatosFormularioRegistroRuta();
				
				
			}
			else {
							
				txtNombreRuta.setBorder(bordeVerde);
				txtDescripcionRuta.setBorder(bordeVerde);
					
				validacion = insertarDatosRuta();
					
				//Para cerrar la ventana del formulario y no se puedan introducir mas datos
					
				if (MiPanelCrearRuta.frame_registro_rutas != null) {	
					MiPanelCrearRuta.frame_registro_rutas.dispose();	
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
	

	private int insertarDatosRuta() {
		
		int comprobacion = 0;
		String cadena_formato_fecha = null;
		
		//Codigo que permite insertar los datos en la base de datos
		
		
		
		if (dcFechaRuta.getDate() == null) {
			
			comprobacion = metodos_gestor_rutas.insertarRuta(txtNombreRuta.getText().toString(), "Fecha no disponible", 
					"Hora Inicio no disponible", "Hora Fin no disponible", AplicacionPrincipal.usuario_actual.getNombreUsuario().toString(), (String)cmbPuntoEncuentro.getSelectedItem(), 2, 
					(Integer) spnMaximo.getValue(), (String)cmbDificultad.getSelectedItem(), (String)cmbEquipamiento.getSelectedItem(), txtDescripcionRuta.getText().toString());
			
					
		} else {
			
			cadena_formato_fecha = dcFechaRuta.getCalendar().get(Calendar.DAY_OF_MONTH)+"/"+ dcFechaRuta.getCalendar().get(Calendar.MONTH)+"/"+
					dcFechaRuta.getCalendar().get(Calendar.YEAR);
			
			comprobacion = metodos_gestor_rutas.insertarRuta(txtNombreRuta.getText().toString(), cadena_formato_fecha, 
					"Hora Inicio no disponible", "Hora Fin no disponible", AplicacionPrincipal.usuario_actual.getNombreUsuario().toString(), (String)cmbPuntoEncuentro.getSelectedItem(), 2, 
					(Integer) spnMaximo.getValue(), (String)cmbDificultad.getSelectedItem(), (String)cmbEquipamiento.getSelectedItem(), txtDescripcionRuta.getText().toString());
			
		}
		
	
		return comprobacion;
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
	
		JOptionPane.showMessageDialog(MiPanelCrearRuta.frame_registro_rutas, labelDialogoRegistroCorrectoMensaje, "Datos guardados.", 1);
			
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
		
		JOptionPane.showMessageDialog(MiPanelCrearRuta.frame_registro_rutas, labelDialogoRegistroErrorMensaje, "Error registro.", 0);
			
	}
	/**
	 * 
	 * Descripcion: creaccion de un dialogo que avisa al usuario que las contrasenas no coinciden
	 * 
	 */
	private void dialogoContrasenasDistintas() {
		
		//Datos dialogo error contrasena
			
		JLabel labelDialogoContrasenasMensaje = new JLabel("Las contraseñas no coinciden.");
		labelDialogoContrasenasMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(MiPanelCrearRuta.frame_registro_rutas, labelDialogoContrasenasMensaje, "Contraseñas no válidas.", 0);
		
		
			
	}
	/**
	 * 
	 * Descripcion: Datos generados de la parte de diseño al inicializar es estilo que tendra esta parte de la aplicacion
	 * 
	 */
	private void inicializarDatosFormularioRegistro() {
		
		setTitle("Ventana Formulario Ruta.");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioRegistroRuta.class.getResource("/recursos/Form.png")));
		
		setFont(new Font("Segoe UI", Font.BOLD, 16));
		setBounds(new Rectangle(50, 50, 500, 625));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		contentPane.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{145, 132, 73, 84, 113, 47, 0};
		gbl_contentPane.rowHeights = new int[]{54, 29, 33, 30, 31, 30, 32, 36, 29, 31, 33, 32, 32, 32, 0, 32, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
	 * Descripcion: Datos generados de la parte disenio relacionados con los dos primeros campos similares del formulario
	 * 
	 */
	private void inicializarDatosPrimerAgrupamiento() {
		
		//Datos campos Nombre de Usuario
		
		lblNombreRuta = new JLabel("Nombre ruta:");
		lblNombreRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombreRuta = new GridBagConstraints();
		gbc_lblNombreRuta.anchor = GridBagConstraints.EAST;
		gbc_lblNombreRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreRuta.gridx = 1;
		gbc_lblNombreRuta.gridy = 1;
		contentPane.add(lblNombreRuta, gbc_lblNombreRuta);
		
		txtNombreRuta = new JTextField();
		GridBagConstraints gbc_txtNombreRuta = new GridBagConstraints();
		gbc_txtNombreRuta.fill = GridBagConstraints.BOTH;
		gbc_txtNombreRuta.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreRuta.gridx = 2;
		gbc_txtNombreRuta.gridy = 1;
		contentPane.add(txtNombreRuta, gbc_txtNombreRuta);
		txtNombreRuta.setColumns(10);
		
		lblComprobarNombreRuta = new JLabel("");
		lblComprobarNombreRuta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblComprobarNombreRuta = new GridBagConstraints();
		gbc_lblComprobarNombreRuta.gridwidth = 2;
		gbc_lblComprobarNombreRuta.anchor = GridBagConstraints.WEST;
		gbc_lblComprobarNombreRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblComprobarNombreRuta.gridx = 3;
		gbc_lblComprobarNombreRuta.gridy = 1;
		contentPane.add(lblComprobarNombreRuta, gbc_lblComprobarNombreRuta);
		
		//Datos campos Apellido
		
		lblDescripcionRuta = new JLabel("Descripción:");
		lblDescripcionRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDescripcionRuta = new GridBagConstraints();
		gbc_lblDescripcionRuta.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcionRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionRuta.gridx = 1;
		gbc_lblDescripcionRuta.gridy = 2;
		contentPane.add(lblDescripcionRuta, gbc_lblDescripcionRuta);
		
	}
	/**
	 * 
	 * Descripcion: Datos generados con respecto a la parte de disenio del segundo grupo con caracteristicas similares
	 * 
	 */
	private void inicializarDatosSegundoAgrupamiento() {
		
		txtDescripcionRuta = new JTextField();
		GridBagConstraints gbc_txtDescripcionRuta = new GridBagConstraints();
		gbc_txtDescripcionRuta.gridwidth = 2;
		gbc_txtDescripcionRuta.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcionRuta.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcionRuta.gridx = 2;
		gbc_txtDescripcionRuta.gridy = 2;
		contentPane.add(txtDescripcionRuta, gbc_txtDescripcionRuta);
		txtDescripcionRuta.setColumns(10);
		
		// Datos campos contrasenas
		
		lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.anchor = GridBagConstraints.EAST;
		gbc_lblDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultad.gridx = 1;
		gbc_lblDificultad.gridy = 4;
		contentPane.add(lblDificultad, gbc_lblDificultad);
		
		cmbDificultad = new JComboBox();
		cmbDificultad.setModel(new DefaultComboBoxModel(new String[] {"No tiene", "Baja", "Intermedio", "Experto"}));
		cmbDificultad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbDificultad.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbDificultad = new GridBagConstraints();
		gbc_cmbDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbDificultad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDificultad.gridx = 2;
		gbc_cmbDificultad.gridy = 4;
		contentPane.add(cmbDificultad, gbc_cmbDificultad);
		
		
		//Datos campos de confirmacion contrasenas
		
		lblEquipamiento = new JLabel("Equipamiento:");
		lblEquipamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEquipamiento = new GridBagConstraints();
		gbc_lblEquipamiento.anchor = GridBagConstraints.EAST;
		gbc_lblEquipamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipamiento.gridx = 1;
		gbc_lblEquipamiento.gridy = 5;
		contentPane.add(lblEquipamiento, gbc_lblEquipamiento);
		
		cmbEquipamiento = new JComboBox();
		cmbEquipamiento.setModel(new DefaultComboBoxModel(new String[] {"No necesario", "Recomendado", "Obligatorio"}));
		cmbEquipamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbEquipamiento.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_cmbEquipamiento = new GridBagConstraints();
		gbc_cmbEquipamiento.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEquipamiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEquipamiento.gridx = 2;
		gbc_cmbEquipamiento.gridy = 5;
		contentPane.add(cmbEquipamiento, gbc_cmbEquipamiento);
		
		//Datos seleccion tipo de Usuario aplicacion
		
		lblEncuentro = new JLabel("Punto encuentro:\r\n");
		lblEncuentro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEncuentro = new GridBagConstraints();
		gbc_lblEncuentro.anchor = GridBagConstraints.EAST;
		gbc_lblEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncuentro.gridx = 1;
		gbc_lblEncuentro.gridy = 6;
		contentPane.add(lblEncuentro, gbc_lblEncuentro);
		
		cmbPuntoEncuentro = new JComboBox();
		cmbPuntoEncuentro.setBackground(new Color(248, 248, 255));
		cmbPuntoEncuentro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbPuntoEncuentro.setModel(new DefaultComboBoxModel(new String[] {"Entrada", "Salida", "Pistas ", "Mirador", "Zona cabñas", "Zona parcelas"}));
		GridBagConstraints gbc_cmbPuntoEncuentro = new GridBagConstraints();
		gbc_cmbPuntoEncuentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPuntoEncuentro.anchor = GridBagConstraints.NORTH;
		gbc_cmbPuntoEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPuntoEncuentro.gridx = 2;
		gbc_cmbPuntoEncuentro.gridy = 6;
		contentPane.add(cmbPuntoEncuentro, gbc_cmbPuntoEncuentro);
		
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
		
		lblMximo = new JLabel("Máximo:");
		lblMximo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMximo = new GridBagConstraints();
		gbc_lblMximo.anchor = GridBagConstraints.EAST;
		gbc_lblMximo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMximo.gridx = 1;
		gbc_lblMximo.gridy = 7;
		contentPane.add(lblMximo, gbc_lblMximo);
		
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
		
		spnMaximo = new JSpinner();
		spnMaximo.setModel(new SpinnerNumberModel(2, 2, 50, 1));
		GridBagConstraints gbc_spnMaximo = new GridBagConstraints();
		gbc_spnMaximo.fill = GridBagConstraints.VERTICAL;
		gbc_spnMaximo.anchor = GridBagConstraints.WEST;
		gbc_spnMaximo.insets = new Insets(0, 0, 5, 5);
		gbc_spnMaximo.gridx = 2;
		gbc_spnMaximo.gridy = 7;
		contentPane.add(spnMaximo, gbc_spnMaximo);
		
		//Datos campos Telefono
		
		lblHoraInicio = new JLabel("Hora inicio:");
		lblHoraInicio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHoraInicio = new GridBagConstraints();
		gbc_lblHoraInicio.anchor = GridBagConstraints.EAST;
		gbc_lblHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicio.gridx = 1;
		gbc_lblHoraInicio.gridy = 9;
		contentPane.add(lblHoraInicio, gbc_lblHoraInicio);
		
		//Datos campos fecha de nacimiento
		
		lblFechaRuta = new JLabel("Fecha Ruta:");
		lblFechaRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFechaRuta = new GridBagConstraints();
		gbc_lblFechaRuta.anchor = GridBagConstraints.EAST;
		gbc_lblFechaRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaRuta.gridx = 1;
		gbc_lblFechaRuta.gridy = 10;
		contentPane.add(lblFechaRuta, gbc_lblFechaRuta);
		
		dcFechaRuta = new JDateChooser();
		GridBagConstraints gbc_dcFechaRuta = new GridBagConstraints();
		gbc_dcFechaRuta.insets = new Insets(0, 0, 5, 5);
		gbc_dcFechaRuta.fill = GridBagConstraints.BOTH;
		gbc_dcFechaRuta.gridx = 2;
		gbc_dcFechaRuta.gridy = 10;
		contentPane.add(dcFechaRuta, gbc_dcFechaRuta);
		
		//Datos boton Cancelar el registro
		
		btnRegistroRutaCancelado = new JButton("Cancelar");
		btnRegistroRutaCancelado.setForeground(Color.WHITE);
		btnRegistroRutaCancelado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistroRutaCancelado.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnRegistroRutaCancelado = new GridBagConstraints();
		gbc_btnRegistroRutaCancelado.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroRutaCancelado.gridx = 2;
		gbc_btnRegistroRutaCancelado.gridy = 13;
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
		gbc_btnRegistroRutaTerminado.gridy = 13;
		contentPane.add(btnRegistroRutaTerminado, gbc_btnRegistroRutaTerminado);
		
	}
	
	
	private void comprobarDatosFormularioRegistroRuta() {
		
		//Bordes Descripcion
		
		if (txtDescripcionRuta.getText().equals("")) {
			txtDescripcionRuta.setBorder(bordeRojo);
		}
		else {
			txtDescripcionRuta.setBorder(bordeVerde);
		}
		
		if(dcFechaRuta.getDate() == null) {
			dcFechaRuta.setBorder(bordeRojo);
		}
		else {
			dcFechaRuta.setBorder(bordeVerde);
		}
		
		//Bordes Nombre ruta

		if (txtNombreRuta.getText() != null) {
			
			int comprobar_nombre_registrado_sistema =  ComprobacionNombreRutaRegistrado();
			
			if(comprobar_nombre_registrado_sistema == 0) {
				lblComprobarNombreRuta.setText("Nombre en uso");
				txtNombreRuta.setBorder(bordeRojo);
			}
			else if (comprobar_nombre_registrado_sistema != 0 && txtNombreRuta.getText().equals("") == false) {
				txtNombreRuta.setBorder(bordeVerde);
				lblComprobarNombreRuta.setText("Nombre disponible");
			}
		}
		
	}
	
}
