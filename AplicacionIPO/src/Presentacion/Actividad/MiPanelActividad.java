package Presentacion.Actividad;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Persistencia.gestorActividad;
import Presentacion.EditorGrafico.EditorGraficoRuta;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.Color;

public class MiPanelActividad extends JPanel {
	
	private JLabel lblBarraBusqueda;
	
	private JScrollPane scrollPaneFoto;
	private JLabel lblFotoRutaSeleccionada;
	private JScrollPane scrollPane;
	private JTable table;
	
	private gestorActividad r = new gestorActividad();
	
	private JLabel lblTituloActividad;
	private JTextField textField;
	private JLabel lblNombreActividadDB;
	private JLabel lblIconCalendar;
	private JLabel lblHorarioDB;
	private JLabel lblDescripcionDB;
	private JLabel lblIconoUbicacion;
	private JLabel lblUbicacionDB;
	private JLabel lblIconoGrupos;
	private JLabel lblGrupoDB;
	private JLabel lblIconoDinero;
	private JLabel lblDineroDB;
	private JLabel lblEquipamiento;
	private JLabel lblMaterialDB;
	private JLabel lblLupaIcono;

	/**
	 * Create the panel.
	 */
	public MiPanelActividad() {
		setBackground(new Color(255, 255, 255));
		
		setLayout(null);
		
		lblBarraBusqueda = new JLabel("");
		lblBarraBusqueda.setBounds(521, 98, 45, 13);
		add(lblBarraBusqueda);
		
		scrollPaneFoto = new JScrollPane();
		scrollPaneFoto.setVisible(false);
		scrollPaneFoto.setBounds(59, 250, 248, 171);
		add(scrollPaneFoto);
		
		lblFotoRutaSeleccionada = new JLabel("");
		lblFotoRutaSeleccionada.setVisible(false);
		
		lblFotoRutaSeleccionada.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Actividad/Piscina.jpg")).getImage().getScaledInstance(246, 175, Image.SCALE_SMOOTH)));
		//lblFotoRutaSeleccionada.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/Actividad/Piscina.jpg")));
		scrollPaneFoto.setColumnHeaderView(lblFotoRutaSeleccionada);
		lblFotoRutaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		lblTituloActividad = new JLabel("¿Desea buscar alguna actividad?");
		lblTituloActividad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTituloActividad.setBounds(59, 15, 234, 19);
		add(lblTituloActividad);
		
		textField = new JTextField();
		textField.setBounds(59, 44, 234, 24);
		add(textField);
		textField.setColumns(10);
		
		lblNombreActividadDB = new JLabel("");
		lblNombreActividadDB.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNombreActividadDB.setBounds(327, 247, 192, 19);
		add(lblNombreActividadDB);
		
		lblIconCalendar = new JLabel("");
		lblIconCalendar.setVisible(false);
		lblIconCalendar.setIcon(new ImageIcon(MiPanelActividad.class.getResource("/recursos/calendar.png")));
		lblIconCalendar.setBounds(327, 286, 21, 33);
		add(lblIconCalendar);
		
		lblHorarioDB = new JLabel("");
		lblHorarioDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHorarioDB.setBounds(361, 286, 224, 33);
		add(lblHorarioDB);
		
		lblDescripcionDB = new JLabel("");
		lblDescripcionDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDescripcionDB.setBounds(327, 266, 462, 24);
		add(lblDescripcionDB);
		
		lblIconoUbicacion = new JLabel("");
		lblIconoUbicacion.setLocation(new Point(330, 335));
		lblIconoUbicacion.setIcon(new ImageIcon(MiPanelActividad.class.getResource("/recursos/ubicacion.png")));
		lblIconoUbicacion.setVisible(false);
		lblIconoUbicacion.setBounds(327, 320, 21, 24);
		add(lblIconoUbicacion);
		
		lblUbicacionDB = new JLabel("");
		lblUbicacionDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUbicacionDB.setBounds(361, 321, 224, 23);
		add(lblUbicacionDB);
		
		lblIconoGrupos = new JLabel("");
		lblIconoGrupos.setVisible(false);
		lblIconoGrupos.setIcon(new ImageIcon(MiPanelActividad.class.getResource("/recursos/grupo.png")));
		lblIconoGrupos.setBounds(327, 352, 30, 19);
		add(lblIconoGrupos);
		
		lblGrupoDB = new JLabel("");
		lblGrupoDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblGrupoDB.setBounds(362, 352, 234, 19);
		add(lblGrupoDB);
		
		lblIconoDinero = new JLabel("");
		lblIconoDinero.setVisible(false);
		lblIconoDinero.setIcon(new ImageIcon(MiPanelActividad.class.getResource("/recursos/dinero.png")));
		lblIconoDinero.setBounds(327, 381, 30, 17);
		add(lblIconoDinero);
		
		lblDineroDB = new JLabel("");
		lblDineroDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDineroDB.setBounds(362, 376, 157, 24);
		add(lblDineroDB);
		
		lblEquipamiento = new JLabel("Material necesario para la actividad:");
		lblEquipamiento.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblEquipamiento.setVisible(false);
		lblEquipamiento.setBounds(325, 402, 218, 24);
		add(lblEquipamiento);
		
		lblMaterialDB = new JLabel("");
		lblMaterialDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblMaterialDB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		lblMaterialDB.setBounds(527, 402, 130, 24);
		add(lblMaterialDB);
		
		lblLupaIcono = new JLabel("");
		lblLupaIcono.setIcon(new ImageIcon(MiPanelActividad.class.getResource("/recursos/lupa.png")));
		lblLupaIcono.setBounds(303, 44, 38, 24);
		add(lblLupaIcono);
		
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
				lblNombreActividadDB.setText("Fila "+filaSeleccionada+" seleccionada");
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
					String contenido7 = r.buscarActividad("Foto", contenido);
					
					//System.out.println(table.getValueAt(n, 1));
					lblNombreActividadDB.setText(contenido);
					lblHorarioDB.setText(contenido1);
					lblDescripcionDB.setText(contenido2);
					lblUbicacionDB.setText(contenido3);
					lblGrupoDB.setText(contenido4);
					lblDineroDB.setText(contenido5);
					lblMaterialDB.setText(contenido6);
					
					
					lblIconCalendar.setVisible(true);
					lblIconoUbicacion.setVisible(true);
					lblIconoGrupos.setVisible(true);
					lblIconoDinero.setVisible(true);
					lblEquipamiento.setVisible(true);
					
					scrollPaneFoto.setVisible(true);
					
					if (contenido7 != null) {
						lblFotoRutaSeleccionada.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(contenido7)).getImage().getScaledInstance(246, 172, Image.SCALE_SMOOTH)));
						//lblFotoRutaSeleccionada.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/Actividad/noDisponible.jpg")));
						scrollPaneFoto.setColumnHeaderView(lblFotoRutaSeleccionada);
						lblFotoRutaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
						lblFotoRutaSeleccionada.setVisible(true);
					}
					else {
						lblFotoRutaSeleccionada.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Actividad/noDisponible.jpg")).getImage().getScaledInstance(246, 172, Image.SCALE_SMOOTH)));
						//lblFotoRutaSeleccionada.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/Actividad/noDisponible.jpg")));
						scrollPaneFoto.setColumnHeaderView(lblFotoRutaSeleccionada);
						lblFotoRutaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
						lblFotoRutaSeleccionada.setVisible(true);
					}
					
					
					
					
					//String contenido = "Nombre :"+ table.getValueAt(n, 0)+":\n"+"Raza: "+ table.getValueAt(n, 1)+"\n";
					//contenido += (Boolean) modeloTabla.getValueAt(n, 3)?"Vacunado": "No Vacunado\n";NO NECESARIO
					//lblNombreActividadDB.setText(contenido);
					//lblFoto.setIcon((ImageIcon)modeloTabla.getValueAt(n, 2)); NO NECESARIO
				}
			}
		}
	}
}
