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

public class MiPanelConfiguracionAvanzada extends JPanel {
	
	private JLabel lblContrasenaCA;
	private JLabel lblConfirmarContrasenaCA;
	private JLabel lblEdicionDatosConfiguracion;
	private JButton btnPermitirEdicionCA;
	private JPasswordField pswfContrasenaCA;
	private JPasswordField pswfConfirmarContrasenaCA;
	private JButton btnDarBajaCuente;
	private JLabel lblDatosEmpleados;

	/**
	 * Create the panel.
	 */
	public MiPanelConfiguracionAvanzada() {
		
		inicializarDatosPanelConfiguracionAvanzada();
		
		//Inicializacion de los datos respecto a la parte de la imagen del usuario
		inicializarBotonEdicionConfiguracionAvanzada();
		
		//Inicializacion de los datos respecto a la parte de edicion de datos de la configuracion
		inicializarDatosEdicionConfiguracionAvanzada();
		
		
		//Oyentes del panel configuracion
		asociacionOyentesConfiguracionAvanzada();
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene los eventos del panel de configuracion
	 * 
	 */
	private void asociacionOyentesConfiguracionAvanzada() {
		
		btnPermitirEdicionCA.addActionListener(new BtnPermitirEditarActionListener());
		
	}
	/**
	 * 
	 * Descripcion: Oyente que habilita los campos para editar los datos
	 *
	 */
	private class BtnPermitirEditarActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			lblContrasenaCA.setEnabled(true);
			pswfContrasenaCA.setEnabled(true);
			
			lblConfirmarContrasenaCA.setEnabled(true);
			pswfConfirmarContrasenaCA.setEnabled(true);
			
		}
	}
	/**
	 * 
	 * Descripcion: Datos generados parte de disenio al hacer el panel personalizado
	 * 
	 */
	private void inicializarDatosPanelConfiguracionAvanzada() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 44, 156, 70, 67, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{70, 31, 27, 47, 34, 39, 43, 25, 33, 30, 29, 28, 49, 32, 34, 42, 27, 27, 41, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Etiqueta que sirve de titulo
		
		lblEdicionDatosConfiguracion = new JLabel("Configuraciones avanzada de los datos del Usuario");
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
	 * Descripcion: metodo generado de la parte de disenio relacionado con la creaccion del boton
	 * 
	 */
	private void inicializarBotonEdicionConfiguracionAvanzada() {
		
		//Boton que permite habilitar los campos para editar
		
		btnPermitirEdicionCA = new JButton("Edicion...");
		btnPermitirEdicionCA.setForeground(UIManager.getColor("Button.disabledForeground"));
		btnPermitirEdicionCA.setBackground(UIManager.getColor("Button.darkShadow"));
		btnPermitirEdicionCA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_btnPermitirEdicionCA = new GridBagConstraints();
		gbc_btnPermitirEdicionCA.fill = GridBagConstraints.BOTH;
		gbc_btnPermitirEdicionCA.insets = new Insets(0, 0, 5, 5);
		gbc_btnPermitirEdicionCA.gridx = 2;
		gbc_btnPermitirEdicionCA.gridy = 2;
		add(btnPermitirEdicionCA, gbc_btnPermitirEdicionCA);
		
	}
	/**
	 * 
	 * Descripcion: datos generado de la parte de disenio para que el usuario edite los datos
	 * 
	 */
	private void inicializarDatosEdicionConfiguracionAvanzada() {
		
		//Datos relacionados con la contrasena
		
		lblContrasenaCA = new JLabel("Contraseña:");
		lblContrasenaCA.setEnabled(false);
		lblContrasenaCA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblContrasenaCA = new GridBagConstraints();
		gbc_lblContrasenaCA.anchor = GridBagConstraints.EAST;
		gbc_lblContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasenaCA.gridx = 2;
		gbc_lblContrasenaCA.gridy = 4;
		add(lblContrasenaCA, gbc_lblContrasenaCA);
		
		pswfContrasenaCA = new JPasswordField();
		pswfContrasenaCA.setEnabled(false);
		GridBagConstraints gbc_pswfContrasenaCA = new GridBagConstraints();
		gbc_pswfContrasenaCA.gridwidth = 2;
		gbc_pswfContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_pswfContrasenaCA.fill = GridBagConstraints.BOTH;
		gbc_pswfContrasenaCA.gridx = 3;
		gbc_pswfContrasenaCA.gridy = 4;
		add(pswfContrasenaCA, gbc_pswfContrasenaCA);
		
		//Datos relacionados con la confirmacion contrasena
		
		lblConfirmarContrasenaCA = new JLabel("Confirmar contraseña:");
		lblConfirmarContrasenaCA.setEnabled(false);
		lblConfirmarContrasenaCA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfirmarContrasenaCA = new GridBagConstraints();
		gbc_lblConfirmarContrasenaCA.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmarContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasenaCA.gridx = 2;
		gbc_lblConfirmarContrasenaCA.gridy = 5;
		add(lblConfirmarContrasenaCA, gbc_lblConfirmarContrasenaCA);
		
		pswfConfirmarContrasenaCA = new JPasswordField();
		pswfConfirmarContrasenaCA.setEnabled(false);
		GridBagConstraints gbc_pswfConfirmarContrasenaCA = new GridBagConstraints();
		gbc_pswfConfirmarContrasenaCA.gridwidth = 2;
		gbc_pswfConfirmarContrasenaCA.insets = new Insets(0, 0, 5, 5);
		gbc_pswfConfirmarContrasenaCA.fill = GridBagConstraints.BOTH;
		gbc_pswfConfirmarContrasenaCA.gridx = 3;
		gbc_pswfConfirmarContrasenaCA.gridy = 5;
		add(pswfConfirmarContrasenaCA, gbc_pswfConfirmarContrasenaCA);
		
		lblDatosEmpleados = new JLabel("Informacion para empleados");
		lblDatosEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDatosEmpleados = new GridBagConstraints();
		gbc_lblDatosEmpleados.gridwidth = 2;
		gbc_lblDatosEmpleados.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosEmpleados.gridx = 2;
		gbc_lblDatosEmpleados.gridy = 7;
		add(lblDatosEmpleados, gbc_lblDatosEmpleados);
		
		btnDarBajaCuente = new JButton("Darse de baja");
		btnDarBajaCuente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_btnDarBajaCuente = new GridBagConstraints();
		gbc_btnDarBajaCuente.fill = GridBagConstraints.BOTH;
		gbc_btnDarBajaCuente.insets = new Insets(0, 0, 5, 5);
		gbc_btnDarBajaCuente.gridx = 2;
		gbc_btnDarBajaCuente.gridy = 12;
		add(btnDarBajaCuente, gbc_btnDarBajaCuente);
		
	}

}
