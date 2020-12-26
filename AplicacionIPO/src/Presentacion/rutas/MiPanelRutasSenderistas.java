package Presentacion.rutas;

import javax.swing.JPanel;
import javax.swing.JLabel;
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

import Presentacion.EditorGrafico.EditorGraficoRuta;

public class MiPanelRutasSenderistas extends JPanel {

	private JTextField txtBarraBusqueda;
	private JLabel lblBarraBusqueda;
	private JLabel lblTituloPanelRutas;
	private JScrollPane scrollPane;
	private JTable table;
	
	private ArrayList<Ruta> List_rutas_ofertadas = new ArrayList<Ruta>();

	/**
	 * Create the panel.
	 */
	public MiPanelRutasSenderistas() {
		
		setLayout(null);
		
		txtBarraBusqueda = new JTextField();
		txtBarraBusqueda.setBounds(60, 84, 339, 27);
		add(txtBarraBusqueda);
		txtBarraBusqueda.setColumns(10);
		
		lblBarraBusqueda = new JLabel("");
		lblBarraBusqueda.setBounds(521, 98, 45, 13);
		add(lblBarraBusqueda);
		
		lblTituloPanelRutas = new JLabel("Rutas gratuitas ofertadas.");
		lblTituloPanelRutas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTituloPanelRutas.setBounds(60, 45, 183, 20);
		add(lblTituloPanelRutas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 214, 877, 198);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Foto", "Equipamiento", "Descripcion", "Dificultad", "Num. m\u00E1ximo", "N\u00FAm. m\u00EDnimo", "Punto Encuentro", "Monitor/es", "Hora Final", "Hora Inicio"
			}
		));
		scrollPane.setViewportView(table);
		
		inicializarDatosTablaRutas();
	}
	private void inicializarDatosTablaRutas() {
		
		Ruta ruta = new Ruta();
		
	}
}
