package Presentacion.rutas;

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
import Persistencia.gestorRutas;
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

public class MiPanelRutasOfertadas extends JPanel {
	
	private JScrollPane scrollPaneFoto;
	private JLabel lblFotoRutaSeleccionada;
	private JScrollPane scrollPane;
	private JTable table;
	
	private gestorRutas r = new gestorRutas();
	
	private JLabel lblBarraBusquedaRuta;
	private JTextField txtBuscadorRuta;
	private JLabel lblNombreRutaDB;
	private JLabel lblIconCalendarRuta;
	private JLabel lblHorarioRutaDB;
	private JLabel lblDescripcionRutaDB;
	private JLabel lblIconoUbicacionRuta;
	private JLabel lblUbicacionRutaDB;
	private JLabel lblIconoGruposRuta;
	private JLabel lblGrupoRutaDB;
	private JLabel lblIconoDinero;
	private JLabel lblDineroDB;
	private JLabel lblEquipamiento;
	private JLabel lblEquipaminetoDB;
	private JLabel lblLupaIconoRuta;

	/**
	 * Create the panel.
	 */
	public MiPanelRutasOfertadas() {
		setBackground(new Color(255, 255, 255));
		
		setLayout(null);
		
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
		model.addColumn("Fecha");
		model.addColumn("Hora Inicio");
		model.addColumn("Hora Fin");
		model.addColumn("Ofertada");
		model.addColumn("Dificultad");


		table.setModel(model);
		
		ListSelectionModel rowSM = table.getSelectionModel();
		
		rowSM.addListSelectionListener(new MiListSelectionListenerVentanaTabla());
		
		table.setRowHeight(30);
		insertData(model);
		
		scrollPane.setViewportView(table);
		
		lblBarraBusquedaRuta = new JLabel("¿Desea buscar alguna ruta?");
		lblBarraBusquedaRuta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBarraBusquedaRuta.setBounds(59, 15, 234, 19);
		add(lblBarraBusquedaRuta);
		
		txtBuscadorRuta = new JTextField();
		txtBuscadorRuta.setBounds(59, 44, 234, 24);
		add(txtBuscadorRuta);
		txtBuscadorRuta.setColumns(10);
		
		lblNombreRutaDB = new JLabel("");
		lblNombreRutaDB.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNombreRutaDB.setBounds(327, 247, 192, 19);
		add(lblNombreRutaDB);
		
		lblIconCalendarRuta = new JLabel("");
		lblIconCalendarRuta.setVisible(false);
		lblIconCalendarRuta.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/calendar.png")));
		lblIconCalendarRuta.setBounds(327, 286, 21, 33);
		add(lblIconCalendarRuta);
		
		lblHorarioRutaDB = new JLabel("");
		lblHorarioRutaDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHorarioRutaDB.setBounds(361, 286, 428, 33);
		add(lblHorarioRutaDB);
		
		lblDescripcionRutaDB = new JLabel("");
		lblDescripcionRutaDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDescripcionRutaDB.setBounds(327, 266, 462, 24);
		add(lblDescripcionRutaDB);
		
		lblIconoUbicacionRuta = new JLabel("");
		lblIconoUbicacionRuta.setLocation(new Point(330, 335));
		lblIconoUbicacionRuta.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/ubicacion.png")));
		lblIconoUbicacionRuta.setVisible(false);
		lblIconoUbicacionRuta.setBounds(327, 320, 21, 24);
		add(lblIconoUbicacionRuta);
		
		lblUbicacionRutaDB = new JLabel("");
		lblUbicacionRutaDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUbicacionRutaDB.setBounds(361, 321, 224, 23);
		add(lblUbicacionRutaDB);
		
		lblIconoGruposRuta = new JLabel("");
		lblIconoGruposRuta.setVisible(false);
		lblIconoGruposRuta.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/grupo.png")));
		lblIconoGruposRuta.setBounds(327, 352, 30, 19);
		add(lblIconoGruposRuta);
		
		lblGrupoRutaDB = new JLabel("");
		lblGrupoRutaDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblGrupoRutaDB.setBounds(362, 352, 234, 19);
		add(lblGrupoRutaDB);
		
		lblIconoDinero = new JLabel("");
		lblIconoDinero.setVisible(false);
		lblIconoDinero.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/dinero.png")));
		lblIconoDinero.setBounds(327, 381, 30, 17);
		add(lblIconoDinero);
		
		lblDineroDB = new JLabel("");
		lblDineroDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDineroDB.setBounds(362, 376, 157, 24);
		add(lblDineroDB);
		
		lblEquipamiento = new JLabel("Equipamineto necesario para la ruta:");
		lblEquipamiento.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblEquipamiento.setVisible(false);
		lblEquipamiento.setBounds(325, 402, 218, 24);
		add(lblEquipamiento);
		
		lblEquipaminetoDB = new JLabel("");
		lblEquipaminetoDB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEquipaminetoDB.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		lblEquipaminetoDB.setBounds(533, 402, 124, 24);
		add(lblEquipaminetoDB);
		
		lblLupaIconoRuta = new JLabel("");
		lblLupaIconoRuta.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/lupa.png")));
		lblLupaIconoRuta.setBounds(303, 44, 38, 24);
		add(lblLupaIconoRuta);
		
	}
	
	public void insertData(DefaultTableModel model) {
		
		//System.out.println(r.numeroFilasTablaRutas());
		
		String [] fila = new String [6];
		String a = "";
		int e = r.numeroFilasTablaRutas();
		
		//Image image_ruta = null;
		Icon icon;
		
		for(int i = 1; i<=e; i++) {
			
			//a = a + (r.crearTableRuta("Nombre", i));
			
			fila[0] = r.crearTableRuta("Nombre", i);
			fila[1] = r.crearTableRuta("Fecha", i);
			fila[2] = r.crearTableRuta("HoraInicio", i);
			fila[3] = r.crearTableRuta("HoraFin", i);
			fila[4] = r.crearTableRuta("Ofertada", i);
			fila[5] = r.crearTableRuta("Dificultad", i);
			
		
	
			
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
				lblNombreRutaDB.setText("Fila "+filaSeleccionada+" seleccionada");
				//MiModeloTabla modeloTabla = (MiModeloTabla) table.getModel();
				int n= table.getSelectedRow();
				
				if (n != -1) {
					
					String contenido = ""+table.getValueAt(n, 0);
					String contenido1 = ""+table.getValueAt(n, 1);
					String contenidoHoras =  r.buscarRuta("HoraInicio", contenido)+" - "+r.buscarRuta("HoraFin", contenido);
					String contenido2 = r.buscarRuta("Descripcion", contenido);
					String contenido3 = r.buscarRuta("PuntoEncuentro", contenido);
					String contenido4 = r.buscarRuta("Minimo", contenido)+" - "+r.buscarRuta("Maximo", contenido);
					//String contenido5 = r.buscarActividad("PrecioMes", contenido);
					String contenido6 = r.buscarRuta("Equipamiento", contenido);
					String contenido7 = r.buscarRuta("Foto", contenido);
					
					lblNombreRutaDB.setText(contenido);
					lblHorarioRutaDB.setText(contenido1+" Duracion horas aprox. "+contenidoHoras);
					lblDescripcionRutaDB.setText(contenido2);
					lblUbicacionRutaDB.setText(contenido3);
					lblGrupoRutaDB.setText(contenido4);
					//lblDineroDB.setText(contenido5);
					lblEquipaminetoDB.setText(contenido6);
					
					
					lblIconCalendarRuta.setVisible(true);
					lblIconoUbicacionRuta.setVisible(true);
					lblIconoGruposRuta.setVisible(true);
					//lblIconoDinero.setVisible(true);
					lblEquipamiento.setVisible(true);
					
					scrollPaneFoto.setVisible(true);
					
					
					
					if (contenido7 != null) {
						lblFotoRutaSeleccionada.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(contenido7)).getImage().getScaledInstance(246, 172, Image.SCALE_SMOOTH)));
						//lblFotoRutaSeleccionada.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/Actividad/noDisponible.jpg")));
						
					}
					else {
						lblFotoRutaSeleccionada.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Actividad/noDisponible.jpg")).getImage().getScaledInstance(246, 172, Image.SCALE_SMOOTH)));
						//lblFotoRutaSeleccionada.setIcon(new ImageIcon(MiPanelRutasOfertadas.class.getResource("/recursos/Actividad/noDisponible.jpg")));
						
					}
					
					scrollPaneFoto.setColumnHeaderView(lblFotoRutaSeleccionada);
					lblFotoRutaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
					lblFotoRutaSeleccionada.setVisible(true);
					
					
					//String contenido = "Nombre :"+ table.getValueAt(n, 0)+":\n"+"Raza: "+ table.getValueAt(n, 1)+"\n";
					//contenido += (Boolean) modeloTabla.getValueAt(n, 3)?"Vacunado": "No Vacunado\n";NO NECESARIO
					//lblNombreActividadDB.setText(contenido);
					//lblFoto.setIcon((ImageIcon)modeloTabla.getValueAt(n, 2)); NO NECESARIO
				}
			}
		}
	}
}
