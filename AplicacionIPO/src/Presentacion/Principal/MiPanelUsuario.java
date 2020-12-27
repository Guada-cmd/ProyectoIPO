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
import javax.swing.SwingConstants;

public class MiPanelUsuario extends JPanel {
	
	private JScrollPane scrollPane;
	private JLabel lblInformacionUsuarioAvatar;
	private JLabel lblInformacionUsuarioNombre;
	private JLabel lblInformacionUsuarioTelefono;
	private JLabel lblInformacionUsuarioCorreoElectronico;
	private JLabel lblEdicionDatosInformacionUsuario;
	private JLabel lblHoraUltimoAcceso;
	private JLabel lblNombreUsuario;
	private JLabel lblTipoDeEmpleado;
	private JLabel lblNivelDeEstudios_1;
	private JLabel lblInformacionUsuarioTelefono_2;
	private JLabel lblInformacionUsuarioTelefono_1;
	private JLabel lblltimoAccesso;

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
		gridBagLayout.columnWidths = new int[]{69, 84, 61, 53, 61, 0, 65, 54, 54, 41, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{124, 17, 22, 19, 7, 34, 32, 39, 23, 21, 20, 20, 16, 22, 15, 29, 28, 63, 44, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
	private void inicializarDatosInformacionUsuario() {
		
		//Etiqueta que sirve de titulo
		
		lblEdicionDatosInformacionUsuario = new JLabel("Información actualizada del perfil de Usuario");
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
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		lblInformacionUsuarioAvatar.setIcon(new ImageIcon(MiPanelUsuario.class.getResource("/recursos/Avatar.png")));
		lblInformacionUsuarioAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblInformacionUsuarioAvatar);
		
		lblltimoAccesso = new JLabel("Información de accesso");
		lblltimoAccesso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblltimoAccesso = new GridBagConstraints();
		gbc_lblltimoAccesso.anchor = GridBagConstraints.SOUTH;
		gbc_lblltimoAccesso.gridwidth = 2;
		gbc_lblltimoAccesso.insets = new Insets(0, 0, 5, 5);
		gbc_lblltimoAccesso.gridx = 4;
		gbc_lblltimoAccesso.gridy = 3;
		add(lblltimoAccesso, gbc_lblltimoAccesso);
		
		lblHoraUltimoAcceso = new JLabel("Último accesso:");
		lblHoraUltimoAcceso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHoraUltimoAcceso = new GridBagConstraints();
		gbc_lblHoraUltimoAcceso.anchor = GridBagConstraints.EAST;
		gbc_lblHoraUltimoAcceso.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraUltimoAcceso.gridx = 4;
		gbc_lblHoraUltimoAcceso.gridy = 5;
		add(lblHoraUltimoAcceso, gbc_lblHoraUltimoAcceso);
		
		lblNombreUsuario = new JLabel("Usuario:");
		lblNombreUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombreUsuario = new GridBagConstraints();
		gbc_lblNombreUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreUsuario.gridx = 4;
		gbc_lblNombreUsuario.gridy = 6;
		add(lblNombreUsuario, gbc_lblNombreUsuario);
		
		//Datos relacionados con el nombre
		
		lblInformacionUsuarioNombre = new JLabel("Nombre y apellidos:");
		lblInformacionUsuarioNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioNombre = new GridBagConstraints();
		gbc_lblInformacionUsuarioNombre.gridwidth = 2;
		gbc_lblInformacionUsuarioNombre.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioNombre.gridx = 1;
		gbc_lblInformacionUsuarioNombre.gridy = 9;
		add(lblInformacionUsuarioNombre, gbc_lblInformacionUsuarioNombre);
		
		lblTipoDeEmpleado = new JLabel("");
		lblTipoDeEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTipoDeEmpleado = new GridBagConstraints();
		gbc_lblTipoDeEmpleado.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDeEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeEmpleado.gridx = 3;
		gbc_lblTipoDeEmpleado.gridy = 10;
		add(lblTipoDeEmpleado, gbc_lblTipoDeEmpleado);
		
		//Datos relacionados con el correo electronico
		
		lblInformacionUsuarioCorreoElectronico = new JLabel("Correo electrónico:");
		lblInformacionUsuarioCorreoElectronico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioCorreoElectronico = new GridBagConstraints();
		gbc_lblInformacionUsuarioCorreoElectronico.gridwidth = 2;
		gbc_lblInformacionUsuarioCorreoElectronico.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioCorreoElectronico.gridx = 1;
		gbc_lblInformacionUsuarioCorreoElectronico.gridy = 11;
		add(lblInformacionUsuarioCorreoElectronico, gbc_lblInformacionUsuarioCorreoElectronico);
		
		//Datos relacionados con el telefono
		
		lblInformacionUsuarioTelefono = new JLabel("Teléfono:");
		lblInformacionUsuarioTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioTelefono = new GridBagConstraints();
		gbc_lblInformacionUsuarioTelefono.gridwidth = 2;
		gbc_lblInformacionUsuarioTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioTelefono.gridx = 1;
		gbc_lblInformacionUsuarioTelefono.gridy = 12;
		add(lblInformacionUsuarioTelefono, gbc_lblInformacionUsuarioTelefono);
		
		lblInformacionUsuarioTelefono_2 = new JLabel("Idiomas:");
		lblInformacionUsuarioTelefono_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioTelefono_2 = new GridBagConstraints();
		gbc_lblInformacionUsuarioTelefono_2.gridwidth = 2;
		gbc_lblInformacionUsuarioTelefono_2.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioTelefono_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioTelefono_2.gridx = 1;
		gbc_lblInformacionUsuarioTelefono_2.gridy = 14;
		add(lblInformacionUsuarioTelefono_2, gbc_lblInformacionUsuarioTelefono_2);
		
		lblInformacionUsuarioTelefono_1 = new JLabel("Disponibilidad:");
		lblInformacionUsuarioTelefono_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInformacionUsuarioTelefono_1 = new GridBagConstraints();
		gbc_lblInformacionUsuarioTelefono_1.gridwidth = 2;
		gbc_lblInformacionUsuarioTelefono_1.anchor = GridBagConstraints.EAST;
		gbc_lblInformacionUsuarioTelefono_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionUsuarioTelefono_1.gridx = 1;
		gbc_lblInformacionUsuarioTelefono_1.gridy = 15;
		add(lblInformacionUsuarioTelefono_1, gbc_lblInformacionUsuarioTelefono_1);
		
		lblNivelDeEstudios_1 = new JLabel("Nivel de estudios:");
		lblNivelDeEstudios_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNivelDeEstudios_1 = new GridBagConstraints();
		gbc_lblNivelDeEstudios_1.gridwidth = 2;
		gbc_lblNivelDeEstudios_1.anchor = GridBagConstraints.EAST;
		gbc_lblNivelDeEstudios_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelDeEstudios_1.gridx = 1;
		gbc_lblNivelDeEstudios_1.gridy = 16;
		add(lblNivelDeEstudios_1, gbc_lblNivelDeEstudios_1);
		
	}

}
