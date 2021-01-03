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
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton btnNewButton;
	
	gestorRutas r = new gestorRutas();

	/**
	 * Create the panel.
	 */
	public MiPanelRutasSenderistas() {
		
		setLayout(null);
		
		lblBarraBusqueda = new JLabel("");
		lblBarraBusqueda.setBounds(521, 98, 45, 13);
		add(lblBarraBusqueda);
		
		scrollPaneFoto = new JScrollPane();
		scrollPaneFoto.setBounds(59, 46, 274, 175);
		add(scrollPaneFoto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 242, 730, 170);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		ModeloDinamicoTabla table_d = new ModeloDinamicoTabla();
		table.setModel(table_d);
		
		insertData(table_d);
		
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(356, 46, 433, 175);
		add(scrollPane_1);
		
		lblFotoRutaSeleccionada = new JLabel("");
		lblFotoRutaSeleccionada.setBounds(59, 59, 272, 173);
		add(lblFotoRutaSeleccionada);
		lblFotoRutaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gestorRutas r = new gestorRutas();
				r.buscarRuta();
				System.out.println(r.buscarRuta());
			}
		});
		btnNewButton.setBounds(248, 15, 85, 21);
		add(btnNewButton);
		
	}
	
	public void insertData(ModeloDinamicoTabla modeloTabla) {
		
		System.out.println(r.buscarRuta());
		
		
		
	}
}
