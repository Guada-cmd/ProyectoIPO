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

public class MiPanelConfiguracion extends JPanel {
	
	private JScrollPane scrollPane;
	private JLabel lblConfiguracionAvatar;
	private JLabel lblTitleConfiguracionFoto;
	private JLabel lblConfiguracionNombre;
	private JLabel lblApellidosConfiguracion;
	private JLabel lblConfiguracionTelefono;
	private JLabel lblConfiguracionCorreoElectronico;
	private JLabel lblConfiguracionIdioma;
	private JLabel lblConfiguracionDisponibilidad;
	private JLabel lblEdicionDatosConfiguracion;
	private JButton btnCambiarFoto;
	private JTextField txtConfiguracionNombre;
	private JTextField txtConfiguracionApellidos;
	private JButton btnPermitirEdicion;
	private JTextField txtConfiguracionCorreoElectronico;
	private JTextField txtConfiguracionTelefono;
	private JTextField txtConfiguracionIdioma;
	private JComboBox comboBoxConfiguracionDisponibilidad;

	/**
	 * Create the panel.
	 */
	public MiPanelConfiguracion() {
		
		inicializarDatosPanelConfiguracion();
		
		//Inicializacion de los datos respecto a la parte de la imagen del usuario
		inicializarDatosImagenUsuario();
		
		//Inicializacion de los datos respecto a la parte de edicion de datos de la configuracion
		inicializarDatosEdicionConfiguracion();
		
		
		//Oyentes del panel configuracion
		asociacionOyentesConfiguracion();
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene los eventos del panel de configuracion
	 * 
	 */
	private void asociacionOyentesConfiguracion() {
		
		btnPermitirEdicion.addActionListener(new BtnPermitirEditarActionListener());
		
	}
	/**
	 * 
	 * Descripcion: Oyente que habilita los campos para editar los datos
	 *
	 */
	private class BtnPermitirEditarActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			

			lblConfiguracionNombre.setEnabled(true);
			txtConfiguracionNombre.setEnabled(true);
			
			lblApellidosConfiguracion.setEnabled(true);
			txtConfiguracionApellidos.setEnabled(true);
			
			lblConfiguracionTelefono.setEnabled(true);
			txtConfiguracionTelefono.setEnabled(true);
			
			lblConfiguracionCorreoElectronico.setEnabled(true);
			txtConfiguracionCorreoElectronico.setEnabled(true);
			
			lblConfiguracionIdioma.setEnabled(true);
			txtConfiguracionIdioma.setEnabled(true);
			
			lblConfiguracionDisponibilidad.setEnabled(true);
			comboBoxConfiguracionDisponibilidad.setEnabled(true);
			
		}
	}
	/**
	 * 
	 * Descripcion: Datos generados parte de disenio al hacer el panel personalizado
	 * 
	 */
	private void inicializarDatosPanelConfiguracion() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 44, 80, 70, 67, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{70, 31, 27, 0, 34, 0, 43, 25, 33, 30, 29, 28, 49, 32, 34, 42, 27, 27, 41, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Etiqueta que sirve de titulo
		
		lblEdicionDatosConfiguracion = new JLabel("Configuraciones de los datos del Usuario");
		lblEdicionDatosConfiguracion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblEdicionDatosConfiguracion = new GridBagConstraints();
		gbc_lblEdicionDatosConfiguracion.anchor = GridBagConstraints.WEST;
		gbc_lblEdicionDatosConfiguracion.gridwidth = 3;
		gbc_lblEdicionDatosConfiguracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdicionDatosConfiguracion.gridx = 2;
		gbc_lblEdicionDatosConfiguracion.gridy = 0;
		add(lblEdicionDatosConfiguracion, gbc_lblEdicionDatosConfiguracion);
		
	}
	/**
	 * 
	 * Descripcion: metodo generado de la parte de disenio relacionado con la edicion de la imagen del Usuario
	 * 
	 */
	private void inicializarDatosImagenUsuario() {
		
		//Etiqueta titulo del apartado imagen
		
		lblTitleConfiguracionFoto = new JLabel("Avatar en la aplicación");
		lblTitleConfiguracionFoto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTitleConfiguracionFoto = new GridBagConstraints();
		gbc_lblTitleConfiguracionFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleConfiguracionFoto.gridx = 2;
		gbc_lblTitleConfiguracionFoto.gridy = 1;
		add(lblTitleConfiguracionFoto, gbc_lblTitleConfiguracionFoto);
		
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
		
		lblConfiguracionAvatar = new JLabel("");
		lblConfiguracionAvatar.setIcon(new ImageIcon(MiPanelConfiguracion.class.getResource("/recursos/User.png")));
		scrollPane.setViewportView(lblConfiguracionAvatar);
		
		//Boton para cambiar la foto
		
		btnCambiarFoto = new JButton("Cambiar Foto...");
		btnCambiarFoto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_btnCambiarFoto = new GridBagConstraints();
		gbc_btnCambiarFoto.fill = GridBagConstraints.BOTH;
		gbc_btnCambiarFoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarFoto.gridx = 3;
		gbc_btnCambiarFoto.gridy = 4;
		add(btnCambiarFoto, gbc_btnCambiarFoto);
		
	}
	/**
	 * 
	 * Descripcion: datos generado de la parte de disenio para que el usuario edite los datos
	 * 
	 */
	private void inicializarDatosEdicionConfiguracion() {
		
		//Boton que permite habilitar los campos para editar
		
		btnPermitirEdicion = new JButton("Edicion...");
		btnPermitirEdicion.setForeground(UIManager.getColor("Button.disabledForeground"));
		btnPermitirEdicion.setBackground(UIManager.getColor("Button.darkShadow"));
		btnPermitirEdicion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_btnPermitirEdicion = new GridBagConstraints();
		gbc_btnPermitirEdicion.fill = GridBagConstraints.BOTH;
		gbc_btnPermitirEdicion.insets = new Insets(0, 0, 5, 5);
		gbc_btnPermitirEdicion.gridx = 2;
		gbc_btnPermitirEdicion.gridy = 8;
		add(btnPermitirEdicion, gbc_btnPermitirEdicion);
		
		//Datos relacionados con el nombre
		
		lblConfiguracionNombre = new JLabel("Nombre:");
		lblConfiguracionNombre.setEnabled(false);
		lblConfiguracionNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfiguracionNombre = new GridBagConstraints();
		gbc_lblConfiguracionNombre.anchor = GridBagConstraints.EAST;
		gbc_lblConfiguracionNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfiguracionNombre.gridx = 2;
		gbc_lblConfiguracionNombre.gridy = 10;
		add(lblConfiguracionNombre, gbc_lblConfiguracionNombre);
		
		txtConfiguracionNombre = new JTextField();
		txtConfiguracionNombre.setEnabled(false);
		GridBagConstraints gbc_txtConfiguracionNombre = new GridBagConstraints();
		gbc_txtConfiguracionNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfiguracionNombre.fill = GridBagConstraints.BOTH;
		gbc_txtConfiguracionNombre.gridx = 3;
		gbc_txtConfiguracionNombre.gridy = 10;
		add(txtConfiguracionNombre, gbc_txtConfiguracionNombre);
		txtConfiguracionNombre.setColumns(10);
		
		//Datos relacionados con el apellido
		
		lblApellidosConfiguracion = new JLabel("Apellidos:");
		lblApellidosConfiguracion.setEnabled(false);
		lblApellidosConfiguracion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblApellidosConfiguracion = new GridBagConstraints();
		gbc_lblApellidosConfiguracion.anchor = GridBagConstraints.EAST;
		gbc_lblApellidosConfiguracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidosConfiguracion.gridx = 2;
		gbc_lblApellidosConfiguracion.gridy = 11;
		add(lblApellidosConfiguracion, gbc_lblApellidosConfiguracion);
		
		txtConfiguracionApellidos = new JTextField();
		txtConfiguracionApellidos.setEnabled(false);
		GridBagConstraints gbc_txtConfiguracionApellidos = new GridBagConstraints();
		gbc_txtConfiguracionApellidos.gridwidth = 2;
		gbc_txtConfiguracionApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfiguracionApellidos.fill = GridBagConstraints.BOTH;
		gbc_txtConfiguracionApellidos.gridx = 3;
		gbc_txtConfiguracionApellidos.gridy = 11;
		add(txtConfiguracionApellidos, gbc_txtConfiguracionApellidos);
		txtConfiguracionApellidos.setColumns(10);
		
		//Datos relacionados con el telefono
		
		lblConfiguracionTelefono = new JLabel("Teléfono:");
		lblConfiguracionTelefono.setEnabled(false);
		lblConfiguracionTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfiguracionTelefono = new GridBagConstraints();
		gbc_lblConfiguracionTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblConfiguracionTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfiguracionTelefono.gridx = 2;
		gbc_lblConfiguracionTelefono.gridy = 13;
		add(lblConfiguracionTelefono, gbc_lblConfiguracionTelefono);
		
		txtConfiguracionTelefono = new JTextField();
		txtConfiguracionTelefono.setEnabled(false);
		txtConfiguracionTelefono.setColumns(10);
		GridBagConstraints gbc_txtConfiguracionTelefono = new GridBagConstraints();
		gbc_txtConfiguracionTelefono.gridwidth = 2;
		gbc_txtConfiguracionTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfiguracionTelefono.fill = GridBagConstraints.BOTH;
		gbc_txtConfiguracionTelefono.gridx = 3;
		gbc_txtConfiguracionTelefono.gridy = 13;
		add(txtConfiguracionTelefono, gbc_txtConfiguracionTelefono);
		
		//Datos relacionados con el correo electronico
		
		lblConfiguracionCorreoElectronico = new JLabel("Correo electrónico:");
		lblConfiguracionCorreoElectronico.setEnabled(false);
		lblConfiguracionCorreoElectronico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfiguracionCorreoElectronico = new GridBagConstraints();
		gbc_lblConfiguracionCorreoElectronico.anchor = GridBagConstraints.EAST;
		gbc_lblConfiguracionCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfiguracionCorreoElectronico.gridx = 2;
		gbc_lblConfiguracionCorreoElectronico.gridy = 14;
		add(lblConfiguracionCorreoElectronico, gbc_lblConfiguracionCorreoElectronico);
		
		txtConfiguracionCorreoElectronico = new JTextField();
		txtConfiguracionCorreoElectronico.setEnabled(false);
		txtConfiguracionCorreoElectronico.setColumns(10);
		GridBagConstraints gbc_txtConfiguracionCorreoElectronico = new GridBagConstraints();
		gbc_txtConfiguracionCorreoElectronico.gridwidth = 2;
		gbc_txtConfiguracionCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfiguracionCorreoElectronico.fill = GridBagConstraints.BOTH;
		gbc_txtConfiguracionCorreoElectronico.gridx = 3;
		gbc_txtConfiguracionCorreoElectronico.gridy = 14;
		add(txtConfiguracionCorreoElectronico, gbc_txtConfiguracionCorreoElectronico);
		
		//Datos relacionados con el idioma
		
		lblConfiguracionIdioma = new JLabel("Idioma:");
		lblConfiguracionIdioma.setEnabled(false);
		lblConfiguracionIdioma.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfiguracionIdioma = new GridBagConstraints();
		gbc_lblConfiguracionIdioma.anchor = GridBagConstraints.EAST;
		gbc_lblConfiguracionIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfiguracionIdioma.gridx = 2;
		gbc_lblConfiguracionIdioma.gridy = 16;
		add(lblConfiguracionIdioma, gbc_lblConfiguracionIdioma);
		
		txtConfiguracionIdioma = new JTextField();
		txtConfiguracionIdioma.setEnabled(false);
		GridBagConstraints gbc_txtConfiguracionIdioma = new GridBagConstraints();
		gbc_txtConfiguracionIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfiguracionIdioma.fill = GridBagConstraints.BOTH;
		gbc_txtConfiguracionIdioma.gridx = 3;
		gbc_txtConfiguracionIdioma.gridy = 16;
		add(txtConfiguracionIdioma, gbc_txtConfiguracionIdioma);
		txtConfiguracionIdioma.setColumns(10);
		
		//Datos relacionados con la restriccion de disponibilidad
		
		lblConfiguracionDisponibilidad = new JLabel("Disponibilidad:");
		lblConfiguracionDisponibilidad.setEnabled(false);
		lblConfiguracionDisponibilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfiguracionDisponibilidad = new GridBagConstraints();
		gbc_lblConfiguracionDisponibilidad.anchor = GridBagConstraints.EAST;
		gbc_lblConfiguracionDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfiguracionDisponibilidad.gridx = 2;
		gbc_lblConfiguracionDisponibilidad.gridy = 17;
		add(lblConfiguracionDisponibilidad, gbc_lblConfiguracionDisponibilidad);
		
		comboBoxConfiguracionDisponibilidad = new JComboBox();
		comboBoxConfiguracionDisponibilidad.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
		comboBoxConfiguracionDisponibilidad.setEnabled(false);
		comboBoxConfiguracionDisponibilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBoxConfiguracionDisponibilidad = new GridBagConstraints();
		gbc_comboBoxConfiguracionDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxConfiguracionDisponibilidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxConfiguracionDisponibilidad.gridx = 3;
		gbc_comboBoxConfiguracionDisponibilidad.gridy = 17;
		add(comboBoxConfiguracionDisponibilidad, gbc_comboBoxConfiguracionDisponibilidad);
		
	}

}
