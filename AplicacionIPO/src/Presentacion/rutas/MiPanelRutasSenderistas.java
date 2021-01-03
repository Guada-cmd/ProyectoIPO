package Presentacion.rutas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Persistencia.gestorRutas;
import Presentacion.EditorGrafico.EditorGraficoRuta;
import javax.swing.SwingConstants;

public class MiPanelRutasSenderistas extends JPanel {
	private JLabel lblBarraBusqueda;
	
	private ArrayList<Ruta> List_rutas_ofertadas = new ArrayList<Ruta>();
	private JScrollPane scrollPaneFoto;
	private JLabel lblFotoRutaSeleccionada;
	private JScrollPane scrollPane;
	private JTable table;
	
	gestorRutas r = new gestorRutas();
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public MiPanelRutasSenderistas() {
		
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
		table.setEnabled(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Nombre");
		model.addColumn("Fecha");
		model.addColumn("Hora Inicio");
		model.addColumn("Hora Fin");
		model.addColumn("Ofertada");
		model.addColumn("Dificultad");

		table.setModel(model);
		
		table.setRowHeight(30);
		insertData(model);
		
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("¿Desea buscar alguna ruta?");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(59, 15, 184, 19);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(59, 44, 234, 24);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(342, 285, 45, 13);
		add(lblNewLabel_1);
		
	}
	
	public void insertData(DefaultTableModel model) {
		
		//System.out.println(r.numeroFilasTablaRutas());
		
		String [] fila = new String [6];
		String a = "";
		int e = r.numeroFilasTablaRutas();
		
		for(int i = 1; i<=e; i++) {
			
			//a = a + (r.crearTableRuta("Nombre", i));
		
			fila[0] = r.crearTableRuta("Nombre", i);
			fila[1] = r.crearTableRuta("Fecha", i);
			fila[2] = r.crearTableRuta("HoraInicio", i);
			fila[3] = r.crearTableRuta("HoraFin", i);
			fila[4] = r.crearTableRuta("Ofertada", i);
			fila[5] = r.crearTableRuta("Dificultad", i);
			
			
			model.addRow(fila);
			
		}
		System.out.println(a);
	}
}
