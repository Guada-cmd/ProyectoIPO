package Presentacion.Principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class MiPanelUsuario extends JPanel {
	
	private JScrollPane scrollPane;
	private JLabel lblInformacionUsuarioAvatar;
	private JLabel lblTitleInformacionUsuarioFoto;
	private JLabel lblInformacionUsuarioNombre;
	private JLabel lblApellidosInformacionUsuario;
	private JLabel lblInformacionUsuarioTelefono;
	private JLabel lblInformacionUsuarioCorreoElectronico;
	private JLabel lblInformacionUsuarioIdioma;
	private JLabel lblInformacionUsuarioDisponibilidad;
	private JLabel lblEdicionDatosInformacionUsuario;
	private JComboBox comboBoxInformacionUsuarioDisponibilidad;
	private JLabel lblDatosDisponibles;

	/**
	 * Create the panel.
	 */
	public MiPanelUsuario() {
		
		inicializarDatosPanelInformacionUsuario();
		
		//Inicializacion de los datos respecto a la parte de la imagen del usuario
		inicializarDatosImagenUsuario();
		
		//Inicializacion de los datos respecto a la parte de edicion de datos de la configuracion
		inicializarDatosInformacionUsuario();
				
		//Oyentes del panel configuracion
		asociacionOyentesInformacionUsuario();
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene los eventos del panel de configuracion
	 * 
	 */
	private void asociacionOyentesInformacionUsuario() {
		
	}
	/**
	 * 
	 * Descripcion: Datos generados parte de disenio al hacer el panel personalizado
	 * 
	 */
	private void inicializarDatosPanelInformacionUsuario() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 44, 80, 105, 67, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{70, 31, 27, 0, 34, 0, 43, 25, 33, 30, 29, 28, 49, 32, 34, 42, 27, 27, 41, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Etiqueta que sirve de titulo
		
		lblEdicionDatosInformacionUsuario = new JLabel("Información actualizada del Usuario");
		lblEdicionDatosInformacionUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblEdicionDatosInformacionUsuario = new GridBagConstraints();
		gbc_lblEdicionDatosInformacionUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblEdicionDatosInformacionUsuario.gridwidth = 3;
		gbc_lblEdicionDatosInformacionUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionDatosInformacionUsuario.gridx = 2;
		gbc_lblEdicionDatosInformacionUsuario.gridy = 0;
		add(lblEdicionDatosInformacionUsuario, gbc_lblEdicionDatosInformacionUsuario);
		
	}
	/**
	 * 
	 * Descripcion: metodo generado de la parte de disenio relacionado con la edicion de la imagen del Usuario
	 * 
	 */
	private void inicializarDatosImagenUsuario() {
		
		//Etiqueta titulo del apartado imagen
		
		lblTitleInformacionUsuarioFoto = new JLabel("Avatar en la aplicación");
		lblTitleInformacionUsuarioFoto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTitleInformacionUsuarioFoto = new GridBagConstraints();
		gbc_lblTitleInformacionUsuarioFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleInformacionUsuarioFoto.gridx = 2;
		gbc_lblTitleInformacionUsuarioFoto.gridy = 1;
		add(lblTitleInformacionUsuarioFoto, gbc_lblTitleInformacionUsuarioFoto);
		
		//Componente scrollPane para la imagen del Usuario
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		//Etiqueta que permite seleccionar la foto
		
		lblInformacionUsuarioAvatar = new JLabel("");
		lblInformacionUsuarioAvatar.setIcon(new ImageIcon(MiPanelUsuario.class.getResource("/recursos/User.png")));
		scrollPane.setViewportView(lblInformacionUsuarioAvatar);
		
	}
	/**
	 * 
	 * Descripcion: datos generado de la parte de disenio para que el usuario edite los datos
	 * 
	 */
	private void inicializarDatosInformacionUsuario() {
		
		lblDatosDisponibles = new JLabel("Datos editables del Usuario");
		lblDatosDisponibles.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDatosDisponibles = new GridBagConstraints();
		gbc_lblDatosDisponibles.anchor = GridBagConstraints.WEST;
		gbc_lblDatosDisponibles.gridwidth = 2;
		gbc_lblDatosDisponibles.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosDisponibles.gridx = 2;
		gbc_lblDatosDisponibles.gridy = 8;
		add(lblDatosDisponibles, gbc_lblDatosDisponibles);
		
		//Datos relacionados con el nombre
		
		lblInformacionUsuarioNombre = new JLabel("Nombre:");
		lblInformacionUsuarioNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioNombre = new GridBagConstraints();
		gbc_lblInformacionUsuarioNombre.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioNombre.gridx = 2;
		gbc_lblInformacionUsuarioNombre.gridy = 10;
		add(lblInformacionUsuarioNombre, gbc_lblInformacionUsuarioNombre);
		
		//Datos relacionados con el apellido
		
		lblApellidosInformacionUsuario = new JLabel("Apellidos:");
		lblApellidosInformacionUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblApellidosInformacionUsuario = new GridBagConstraints();
		gbc_lblApellidosInformacionUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblApellidosInformacionUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidosInformacionUsuario.gridx = 2;
		gbc_lblApellidosInformacionUsuario.gridy = 11;
		add(lblApellidosInformacionUsuario, gbc_lblApellidosInformacionUsuario);
		
		//Datos relacionados con el telefono
		
		lblInformacionUsuarioTelefono = new JLabel("Teléfono:");
		lblInformacionUsuarioTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioTelefono = new GridBagConstraints();
		gbc_lblInformacionUsuarioTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioTelefono.gridx = 2;
		gbc_lblInformacionUsuarioTelefono.gridy = 13;
		add(lblInformacionUsuarioTelefono, gbc_lblInformacionUsuarioTelefono);
		
		//Datos relacionados con el correo electronico
		
		lblInformacionUsuarioCorreoElectronico = new JLabel("Correo electrónico:");
		lblInformacionUsuarioCorreoElectronico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioCorreoElectronico = new GridBagConstraints();
		gbc_lblInformacionUsuarioCorreoElectronico.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioCorreoElectronico.gridx = 2;
		gbc_lblInformacionUsuarioCorreoElectronico.gridy = 14;
		add(lblInformacionUsuarioCorreoElectronico, gbc_lblInformacionUsuarioCorreoElectronico);
		
		//Datos relacionados con el idioma
		
		lblInformacionUsuarioIdioma = new JLabel("Idioma:");
		lblInformacionUsuarioIdioma.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioIdioma = new GridBagConstraints();
		gbc_lblInformacionUsuarioIdioma.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioIdioma.gridx = 2;
		gbc_lblInformacionUsuarioIdioma.gridy = 16;
		add(lblInformacionUsuarioIdioma, gbc_lblInformacionUsuarioIdioma);
		
		//Datos relacionados con la restriccion de disponibilidad
		
		lblInformacionUsuarioDisponibilidad = new JLabel("Disponibilidad:");
		lblInformacionUsuarioDisponibilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioDisponibilidad = new GridBagConstraints();
		gbc_lblInformacionUsuarioDisponibilidad.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioDisponibilidad.gridx = 2;
		gbc_lblInformacionUsuarioDisponibilidad.gridy = 17;
		add(lblInformacionUsuarioDisponibilidad, gbc_lblInformacionUsuarioDisponibilidad);
		
		comboBoxInformacionUsuarioDisponibilidad = new JComboBox();
		comboBoxInformacionUsuarioDisponibilidad.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
		comboBoxInformacionUsuarioDisponibilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBoxInformacionUsuarioDisponibilidad = new GridBagConstraints();
		gbc_comboBoxInformacionUsuarioDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxInformacionUsuarioDisponibilidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxInformacionUsuarioDisponibilidad.gridx = 3;
		gbc_comboBoxInformacionUsuarioDisponibilidad.gridy = 17;
		add(comboBoxInformacionUsuarioDisponibilidad, gbc_comboBoxInformacionUsuarioDisponibilidad);
		
	}

}
