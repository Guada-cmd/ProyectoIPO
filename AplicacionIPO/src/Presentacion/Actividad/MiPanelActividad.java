package Presentacion.Actividad;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import Persistencia.gestorActividad;
import Presentacion.EditorGrafico.EditorGraficoRuta;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MiPanelActividad extends JPanel {
	
	private JLabel lblBarraBusqueda;
	
	private JScrollPane scrollPaneFoto;
	private JLabel lblFotoRutaSeleccionada;
	private JScrollPane scrollPane;
	private JTable table;
	
	private gestorActividad r = new gestorActividad();
	
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNombreActividadDB;
	private JLabel lblNewLabel_2;
	private JLabel lblIconCalendar;
	private JLabel lblHorarioDB;
	private JLabel lblDescripcionDB;

	/**
	 * Create the panel.
	 */
	public MiPanelActividad() {
		
		setLayout(null);
		
		lblBarraBusqueda = new JLabel("");
		lblBarraBusqueda.setBounds(521, 98, 45, 13);
		add(lblBarraBusqueda);
		
		scrollPaneFoto = new JScrollPane();
		scrollPaneFoto.setBounds(59, 257, 258, 175);
		add(scrollPaneFoto);
		
		lblFotoRutaSeleccionada = new JLabel("");
		scrollPaneFoto.setViewportView(lblFotoRutaSeleccionada);
		lblFotoRutaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 78, 730, 159);
		add(scrollPane);
		
		table = new JTable();
	
		table.setFocusable(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
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
		
		lblNombreActividadDB = new JLabel("");
		lblNombreActividadDB.setBounds(327, 257, 192, 19);
		add(lblNombreActividadDB);
		
		lblNewLabel_2 = new JLabel("*Todas las actividades se imparten durante los meses de Junio, Julio y Agosto");
		lblNewLabel_2.setBounds(327, 413, 447, 19);
		add(lblNewLabel_2);
		
		lblIconCalendar = new JLabel("");
		lblIconCalendar.setVisible(false);
		lblIconCalendar.setIcon(new ImageIcon(MiPanelActividad.class.getResource("/recursos/calendar.png")));
		lblIconCalendar.setBounds(329, 302, 30, 24);
		add(lblIconCalendar);
		
		lblHorarioDB = new JLabel("");
		lblHorarioDB.setBounds(362, 302, 204, 24);
		add(lblHorarioDB);
		
		lblDescripcionDB = new JLabel("");
		lblDescripcionDB.setBounds(327, 278, 462, 24);
		add(lblDescripcionDB);
		
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
					
					//System.out.println(table.getValueAt(n, 1));
					lblNombreActividadDB.setText(contenido);
					lblHorarioDB.setText(contenido1);
					lblDescripcionDB.setText(contenido2);
					
					lblIconCalendar.setVisible(true);
					
					//String contenido = "Nombre :"+ table.getValueAt(n, 0)+":\n"+"Raza: "+ table.getValueAt(n, 1)+"\n";
					//contenido += (Boolean) modeloTabla.getValueAt(n, 3)?"Vacunado": "No Vacunado\n";NO NECESARIO
					//lblNombreActividadDB.setText(contenido);
					//lblFoto.setIcon((ImageIcon)modeloTabla.getValueAt(n, 2)); NO NECESARIO
				}
			}
		}
	}
}
