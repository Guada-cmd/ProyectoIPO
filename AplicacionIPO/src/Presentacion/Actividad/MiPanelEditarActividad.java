package Presentacion.Actividad;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Persistencia.gestorActividad;
import Presentacion.InicioSesion.VentanaInicio;

@SuppressWarnings("serial")
public class MiPanelEditarActividad extends JPanel {
	
	
	private JScrollPane scrollPane;
	
	private JTable table;
	
	private JLabel lblBarraBusqueda;
	private JLabel lblNewLabel;
	private JLabel lblLupaIcono;
	private JLabel lblTituloEditarActividad;
	private JLabel lblEditarDatoPrecio;
	private JLabel lblEditarDatoMaterial;
	private JLabel lblEditarDatoArea;
	
	private JCheckBox chckbxPermitirEdicionActividad;
	
	private JComboBox cmbEditarMaterialActividad;
	private JComboBox cmbEditarAreaActividad;
	
	private JTextField txtEditarPrecioActividad;
	private JTextField textField;
	
	private JButton btnGuardarDatosActividad;
	
	
	private JButton btnDarAltaActividad;
	private JButton btnDarBajaActivida;
	private JLabel lbldeseaDarDe;
	private JLabel lbldeseaDarDe_2;
	
	private Color colorVerde = new Color(0, 143, 57);

	
	private Color colorBlanco = new Color (255,255,255);
	private Color colorResaltado = new Color (255,255,210);	
	
	//Creaccion de atributos privados a nivel de clase para determinar mediante colores acciones correctas o no
	
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(colorVerde);
	
	private gestorActividad r = new gestorActividad();
	private JLabel lblActividadEditar;
	
	public static FormularioRegistroBajaActividad frame_registro_actividad_baja;
	public static FormularioRegistroAltaActividad frame_registro_actividad_alta;

	/**
	 * Create the panel.
	 */
	public MiPanelEditarActividad() {
		setBackground(new Color(255, 255, 255));
		
		setLayout(null);
		
		lblBarraBusqueda = new JLabel("");
		lblBarraBusqueda.setBounds(521, 98, 45, 13);
		add(lblBarraBusqueda);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 85, 730, 149);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionBackground(new Color(255, 255, 240));
	
		table.setFocusable(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JTableHeader header = table.getTableHeader();
		

	    header.setBackground(new Color(51, 51, 51));
	    header.setForeground(new Color(255, 255, 255));
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Nombre");
		model.addColumn("Horario");
		model.addColumn("Destinada");
		model.addColumn("Precio");
	

		table.setModel(model);
		
		ListSelectionModel rowSM = table.getSelectionModel();
		
		rowSM.addListSelectionListener(new MiListSelectionListenerVentanaTabla());
		
		table.setRowHeight(30);
		insertData(model);
		
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("¿Desea buscar alguna actividad?");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(59, 15, 234, 19);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(59, 44, 234, 24);
		add(textField);
		textField.setColumns(10);
		
		lblLupaIcono = new JLabel("");
		lblLupaIcono.setIcon(new ImageIcon(MiPanelEditarActividad.class.getResource("/recursos/lupa.png")));
		lblLupaIcono.setBounds(303, 44, 38, 24);
		add(lblLupaIcono);
		
		lblTituloEditarActividad = new JLabel("Modificación datos:\r\n\r\n");
		lblTituloEditarActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTituloEditarActividad.setBounds(86, 239, 125, 32);
		add(lblTituloEditarActividad);
		
		chckbxPermitirEdicionActividad = new JCheckBox("");
		chckbxPermitirEdicionActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxPermitirEdicionActividad.isSelected()) {
					
					
					cmbEditarMaterialActividad.setEnabled(true);
					cmbEditarAreaActividad.setEnabled(true);
					txtEditarPrecioActividad.setEnabled(true);
					
					btnGuardarDatosActividad.setEnabled(true);
					
					lblEditarDatoPrecio.setEnabled(true);
					lblEditarDatoMaterial.setEnabled(true);
					lblEditarDatoArea.setEnabled(true);
					
			
				}
				
				
			}
		});
		chckbxPermitirEdicionActividad.setIcon(new ImageIcon(MiPanelEditarActividad.class.getResource("/recursos/pencil.png")));
		chckbxPermitirEdicionActividad.setBackground(Color.WHITE);
		chckbxPermitirEdicionActividad.setBounds(59, 242, 21, 24);
		add(chckbxPermitirEdicionActividad);
		
		lblEditarDatoPrecio = new JLabel("Precio:\r\n");
		lblEditarDatoPrecio.setEnabled(false);
		lblEditarDatoPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEditarDatoPrecio.setBounds(59, 368, 59, 19);
		add(lblEditarDatoPrecio);
		
		lblEditarDatoMaterial = new JLabel("Material:");
		lblEditarDatoMaterial.setEnabled(false);
		lblEditarDatoMaterial.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEditarDatoMaterial.setBounds(59, 320, 59, 32);
		add(lblEditarDatoMaterial);
		
		lblEditarDatoArea = new JLabel("Area:");
		lblEditarDatoArea.setEnabled(false);
		lblEditarDatoArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEditarDatoArea.setBounds(59, 286, 59, 24);
		add(lblEditarDatoArea);
		
		cmbEditarMaterialActividad = new JComboBox();
		cmbEditarMaterialActividad.setEnabled(false);
		cmbEditarMaterialActividad.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Bañador", "Ropa Tenis", "Equipación baloncesto", "Zapato deportivo", "Chandal"}));
		cmbEditarMaterialActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbEditarMaterialActividad.setBackground(new Color(248, 248, 255));
		cmbEditarMaterialActividad.setBounds(128, 324, 165, 24);
		add(cmbEditarMaterialActividad);
		
		cmbEditarAreaActividad = new JComboBox();
		cmbEditarAreaActividad.setEnabled(false);
		cmbEditarAreaActividad.setModel(new DefaultComboBoxModel(new String[] {"Pistas", "Piscina", "Gimnasio", "Carpa", "Zona de práctica tiro con arco", "Patio zona alta"}));
		cmbEditarAreaActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbEditarAreaActividad.setBackground(new Color(248, 248, 255));
		cmbEditarAreaActividad.setBounds(128, 286, 165, 24);
		add(cmbEditarAreaActividad);
		
		txtEditarPrecioActividad = new JTextField();
		txtEditarPrecioActividad.setEnabled(false);
		txtEditarPrecioActividad.setBounds(128, 368, 165, 24);
		add(txtEditarPrecioActividad);
		txtEditarPrecioActividad.setColumns(10);
		
		btnGuardarDatosActividad = new JButton("Actualizar");
		btnGuardarDatosActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtEditarPrecioActividad.getText().isEmpty()) {
					
					dialogoCamposIncompletos();
					
					txtEditarPrecioActividad.setBorder(bordeRojo);
					
				}
				
				else {
					
					txtEditarPrecioActividad.setBorder(bordeVerde);
					
					if(lblActividadEditar.getText() != null ) {
						
						int validar_nueva_actividad = r.updateActividad(lblActividadEditar.getText().toString(), txtEditarPrecioActividad.getText().toString(),
								(String)cmbEditarAreaActividad.getSelectedItem(), (String)cmbEditarMaterialActividad.getSelectedItem());
						
								
						
						if(validar_nueva_actividad != -1) {
							
						
							dialogoRegistroExitoso();
							
							
							//System.exit(0);
							
							
						}
						else {
							
							errorUpdateDialogo();
							
						}
						
					}

				}
				
			}
		});
		btnGuardarDatosActividad.setFocusable(false);
		btnGuardarDatosActividad.setFocusPainted(false);
		btnGuardarDatosActividad.setFocusTraversalKeysEnabled(false);
		btnGuardarDatosActividad.setBounds(185, 413, 108, 24);
		
		btnGuardarDatosActividad.setEnabled(false);
		btnGuardarDatosActividad.setForeground(Color.WHITE);
		btnGuardarDatosActividad.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardarDatosActividad.setBackground(new Color(51, 51, 51));
		
		add(btnGuardarDatosActividad);
		
		btnDarAltaActividad = new JButton("Dar alta");
		btnDarAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Aparece un panel con el formulario dar de alta actividad 
				
				frame_registro_actividad_alta = new FormularioRegistroAltaActividad();
				
				//Para situarlo en el centro de la pantalla
				
				frame_registro_actividad_alta.setLocationRelativeTo(null);
				frame_registro_actividad_alta.setVisible(true);
			}
		});
		btnDarAltaActividad.setForeground(Color.WHITE);
		btnDarAltaActividad.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDarAltaActividad.setFocusable(false);
		btnDarAltaActividad.setFocusTraversalKeysEnabled(false);
		btnDarAltaActividad.setFocusPainted(false);
		btnDarAltaActividad.setBackground(new Color(51, 51, 51));
		btnDarAltaActividad.setBounds(609, 305, 108, 24);
		add(btnDarAltaActividad);
		
		btnDarBajaActivida = new JButton("Dar baja");
		btnDarBajaActivida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Aparece un panel con el formulario dar de baja actividad 
				
				frame_registro_actividad_baja = new FormularioRegistroBajaActividad();
				
				//Para situarlo en el centro de la pantalla
				
				frame_registro_actividad_baja.setLocationRelativeTo(null);
				frame_registro_actividad_baja.setVisible(true);
				
			}
		});
		btnDarBajaActivida.setForeground(Color.WHITE);
		btnDarBajaActivida.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDarBajaActivida.setFocusable(false);
		btnDarBajaActivida.setFocusTraversalKeysEnabled(false);
		btnDarBajaActivida.setFocusPainted(false);
		btnDarBajaActivida.setBackground(new Color(51, 51, 51));
		btnDarBajaActivida.setBounds(609, 352, 108, 24);
		add(btnDarBajaActivida);
		
		lbldeseaDarDe = new JLabel("¿Desea dar de alta alguna actividad?");
		lbldeseaDarDe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbldeseaDarDe.setBounds(351, 308, 234, 19);
		add(lbldeseaDarDe);
		
		lbldeseaDarDe_2 = new JLabel("¿Desea dar de baja alguna actividad?");
		lbldeseaDarDe_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbldeseaDarDe_2.setBounds(351, 352, 234, 24);
		add(lbldeseaDarDe_2);
		
		lblActividadEditar = new JLabel("");
		lblActividadEditar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblActividadEditar.setBounds(223, 244, 148, 27);
		add(lblActividadEditar);
		
	}
	
	public void insertData(DefaultTableModel model) {
		
		//System.out.println(r.numeroFilasTablaRutas());
		
		String [] fila = new String [4];
		String a = "";
		int e = r.numeroFilasTablaActividad();
		
		//Image image_ruta = null;
		Icon icon;
		
		for(int i = 1; i<=e; i++) {
			
			//a = a + (r.crearTableRuta("Nombre", i));
			
			fila[0] = r.crearTableActividad("Nombre", i);
			fila[1] = r.crearTableActividad("Horario", i);
			fila[2] = r.crearTableActividad("Destinada", i);
			fila[3] = r.crearTableActividad("PrecioMes", i);
			
		
	
			
			//if(r.buscarFotoRuta(i) != null) {
				
				//icon = new ImageIcon(r.buscarFotoRuta(6));
				
				//lblNewLabel_1.setIcon(icon);
				
			//} else{
		    
			//	JOptionPane.showMessageDialog(this,"No existe foto para ID ");
		        
		   // }
			
			
			model.addRow(fila);
			
		}
		System.out.println(a);
	}
	class MiListSelectionListenerVentanaTabla implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			
			ListSelectionModel lsm = (ListSelectionModel) arg0.getSource();
			
			if (!lsm.isSelectionEmpty()) {
				int filaSeleccionada = lsm.getMinSelectionIndex() + 1;
				//lblNombreActividadDB.setText("Fila "+filaSeleccionada+" seleccionada");
				//MiModeloTabla modeloTabla = (MiModeloTabla) table.getModel();
				int n= table.getSelectedRow();
				
				if (n != -1) {
					
					String contenido = ""+table.getValueAt(n, 0);
					String contenido1 = ""+table.getValueAt(n, 1);
					String contenido2 = ""+r.buscarActividad("Descripcion", contenido);
					String contenido3 = ""+r.buscarActividad("Area", contenido);
					String contenido4 = r.buscarActividad("MinimoActividad", contenido)+" - "+r.buscarActividad("MaximoActividad", contenido);
					String contenido5 = r.buscarActividad("PrecioMes", contenido);
					String contenido6 = r.buscarActividad("Material", contenido);
				
					
					//System.out.println(table.getValueAt(n, 1));
					lblActividadEditar.setText(contenido);
					//lblHorarioDB.setText(contenido1);
					//lblDescripcionDB.setText(contenido2);
					//lblUbicacionDB.setText(contenido3);
					//lblGrupoDB.setText(contenido4);
					//lblDineroDB.setText(contenido5);
					//lblMaterialDB.setText(contenido6);
					

					
					//String contenido = "Nombre :"+ table.getValueAt(n, 0)+":\n"+"Raza: "+ table.getValueAt(n, 1)+"\n";
					//contenido += (Boolean) modeloTabla.getValueAt(n, 3)?"Vacunado": "No Vacunado\n";NO NECESARIO
					//lblNombreActividadDB.setText(contenido);
					//lblFoto.setIcon((ImageIcon)modeloTabla.getValueAt(n, 2)); NO NECESARIO
				}
			}
		}
	}
	private void dialogoRegistroExitoso() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos han sido actualizados correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos guardados.", 1);
			
	}
	private void errorUpdateDialogo() {
		
		//Datos dialogo exito en el registro
		
		JLabel labelDialogoRegistroCorrectoMensaje = new JLabel("Los datos no han sido registrados correctamente.");
		labelDialogoRegistroCorrectoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroCorrectoMensaje, "Datos no guardados.", 0);
			
	}
	private void dialogoCamposIncompletos() {
		
		//Datos dialogo aviso en el registro
		
		JLabel labelDialogoRegistroIncompletoMensaje = new JLabel("Termine de completar los campos que faltan.");
		labelDialogoRegistroIncompletoMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		//Mensaje
		
		JOptionPane.showMessageDialog(VentanaInicio.frame_registro, labelDialogoRegistroIncompletoMensaje, "Campos incompletos.", 2);
		
		}
}
