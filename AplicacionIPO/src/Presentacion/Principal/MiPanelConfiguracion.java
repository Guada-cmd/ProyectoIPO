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

import Dominio.Perfil;
import Dominio.Usuario;
import Presentacion.InicioSesion.VentanaInicio;

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
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class MiPanelConfiguracion extends JPanel {
	
	private JScrollPane scrollPane;
	private JLabel lblInformacionUsuarioAvatar;
	private JLabel lblEdicionDatosInformacionUsuario;
	
	//Objeto que permite inicializar los datos de los usuarios
	
	private Usuario usuario_datos_configuracion;
	private Perfil datos_perfil;
	private JButton btnCambiarFoto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JCheckBox chckbxPermitirEdicion;


	/**
	 * Create the panel.
	 */
	public MiPanelConfiguracion(Usuario usuario_datos_configuracion, Perfil datos_perfil) {
		setBackground(new Color(255, 255, 255));
		
		this.usuario_datos_configuracion = usuario_datos_configuracion;
		this.datos_perfil = datos_perfil;
		
		inicializarDatosPanelInformacionUsuario();
		
		//Inicializacion de los datos respecto a la parte de la imagen del usuario
		inicializarDatosImagenUsuario();
		
		//Inicializacion de los datos respecto a la parte de edicion de datos de la configuracion
		inicializarCamposInformacionUsuario();
		
		//Informacion Usuario
		inicializarDatosUsuario();
		
		//Datos perfil
		inicializarDatosPerfilUsuario();
					
		//Oyentes del panel configuracion
		asociacionOyentesInformacionUsuario();
		
	}
	/**
	 * 
	 * Descripcion: muestra los datos del perfil usuario iniciados por defectos en la configuracion
	 * 
	 */
	private void inicializarDatosPerfilUsuario() {
		
		if(VentanaInicio.usuario_sistema != null) {
		
		
			
		}
		
	}
	/**
	 * 
	 * Descripcion: muestra los datos del usuario en la configuracion
	 * 
	 */
	private void inicializarDatosUsuario() {
		
		if(VentanaInicio.usuario_sistema != null) {
			
			
			
		}
		
	}
	private String comprobarTelefono(String cadena_telefono) {
		
		String cadena_comprobada = cadena_telefono;
		
		for(int i = 0; i<cadena_comprobada.length(); i++) {
			if (cadena_comprobada.charAt(i) == '*') {
				cadena_comprobada = "Ninguno";
			}
		}
		
		return cadena_comprobada;
		
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
		gridBagLayout.columnWidths = new int[]{112, 84, 61, 53, 61, 0, 65, 54, 54, 41, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{216, 17, 22, 19, 7, 34, 32, 39, 30, 21, 20, 20, 16, 22, 15, 29, 28, 63, 44, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	/**
	 * 
	 * Descripcion: metodo generado de la parte de disenio relacionado con la edicion de la imagen del Usuario
	 * 
	 */
	private void inicializarDatosImagenUsuario() {
		
	}
	/**
	 * 
	 * Descripcion: datos generado de la parte de disenio para que el usuario edite los datos
	 * 
	 */
	private void inicializarCamposInformacionUsuario() {
		
		//Etiqueta que sirve de titulo
		
		lblEdicionDatosInformacionUsuario = new JLabel("Editar información del Usuario");
		lblEdicionDatosInformacionUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblEdicionDatosInformacionUsuario = new GridBagConstraints();
		gbc_lblEdicionDatosInformacionUsuario.gridwidth = 4;
		gbc_lblEdicionDatosInformacionUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblEdicionDatosInformacionUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionDatosInformacionUsuario.gridx = 1;
		gbc_lblEdicionDatosInformacionUsuario.gridy = 1;
		add(lblEdicionDatosInformacionUsuario, gbc_lblEdicionDatosInformacionUsuario);
		
		//Componente scrollPane para la imagen del Usuario
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		//Etiqueta que permite seleccionar la foto
		
		lblInformacionUsuarioAvatar = new JLabel("");
		lblInformacionUsuarioAvatar.setBackground(new Color(255, 255, 255));
		lblInformacionUsuarioAvatar.setIcon(new ImageIcon(MiPanelConfiguracion.class.getResource("/recursos/Avatar.png")));
		lblInformacionUsuarioAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblInformacionUsuarioAvatar);
		
		chckbxPermitirEdicion = new JCheckBox("");
		chckbxPermitirEdicion.setBackground(Color.WHITE);
		GridBagConstraints gbc_chckbxPermitirEdicion = new GridBagConstraints();
		gbc_chckbxPermitirEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPermitirEdicion.gridx = 5;
		gbc_chckbxPermitirEdicion.gridy = 3;
		add(chckbxPermitirEdicion, gbc_chckbxPermitirEdicion);
		
		lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 5;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 7;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 7;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 8;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 8;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnCambiarFoto = new JButton("Cargar...");
		GridBagConstraints gbc_btnCambiarFoto = new GridBagConstraints();
		gbc_btnCambiarFoto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCambiarFoto.gridwidth = 2;
		gbc_btnCambiarFoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarFoto.gridx = 1;
		gbc_btnCambiarFoto.gridy = 9;
		add(btnCambiarFoto, gbc_btnCambiarFoto);
		
		btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 9;
		add(btnNewButton, gbc_btnNewButton);
		
	}

}
