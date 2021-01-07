package Presentacion.Principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Persistencia.GestorEstancias;
import Persistencia.GestorReservas;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultComboBoxModel;

public class Reserva {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textBuscador;
	
	private JLabel lblTipoParcela = new JLabel("Tipo de parcela:");
	private JComboBox<String> comboTipoParcela = new JComboBox<String>();
	private JLabel lblSelectorParcela = new JLabel("Selector de parcela:");
	private JList<String> listSelectorParcela = new JList<String>();
	private JTextPane textInformacionParcela = new JTextPane();
	private JLabel lblPrecioNombreParcela = new JLabel("Precio:");
	private JLabel lblPrecioParcela = new JLabel("0");
	private JButton btnEjecutarParcela = new JButton("Registrar");
	private JPanel panelCabana = new JPanel();
	private JLabel lblSelectorCabana = new JLabel("Selector de caba\u00F1a:");
	private JList<String> listSelectorCabana = new JList<String>();
	private JTextPane textInformacionCabana = new JTextPane();
	private JLabel lblPrecioNombreCabana = new JLabel("Precio:");
	private JLabel lblPrecioCabana = new JLabel("0");
	private JButton btnEjecutarCabana = new JButton("Registrar");
	private JPanel panelRegistro = new JPanel();
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblApellidos = new JLabel("Apellidos:");
	private JLabel lblNPersonas = new JLabel("Num. pers:");
	private JSpinner spinnerNPersonas = new JSpinner();
	private JLabel lblInformacionAdicional = new JLabel("Informaci\u00F3n adicional:");
	private JLabel lblIconoBuscador = new JLabel("ICO");
	private JTextPane textResultados = new JTextPane();
	private JEditorPane editorInformacion = new JEditorPane();
	private JButton btnRegistrar = new JButton("Realizar registro");
	private JPanel panelExplorar = new JPanel();
	private JPanel panelParcela = new JPanel();
	
	private Vector<Vector<Object>> vEstancias = new Vector<Vector<Object>>();
	private int idEstancia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva window = new Reserva();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reserva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		frame.getContentPane().add(panelParcela, "panelParcela");
		panelParcela.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("93px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("238px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("21px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("96px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("101px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("21px"),}));
		
		
		panelParcela.add(lblTipoParcela, "2, 2, right, center");
		comboTipoParcela.setModel(new DefaultComboBoxModel(new String[] {"pequeña", "mediana", "grande"}));
		comboTipoParcela.addActionListener(new ComboTipoParcelaActionListener());
		
		
		panelParcela.add(comboTipoParcela, "4, 2, fill, top");
		
		
		panelParcela.add(lblSelectorParcela, "2, 4, right, center");
		listSelectorParcela.addListSelectionListener(new ListSelectorParcelaListSelectionListener());
		
		
		panelParcela.add(listSelectorParcela, "4, 4, 3, 1, fill, fill");
		
		
		panelParcela.add(textInformacionParcela, "1, 6, 6, 1, right, fill");
		
		
		panelParcela.add(lblPrecioNombreParcela, "2, 8, right, center");
		
		
		panelParcela.add(lblPrecioParcela, "4, 8, fill, center");
		btnEjecutarParcela.setEnabled(false);
		
		
		btnEjecutarParcela.addActionListener(new BtnEjecutarParcelaActionListener());
		panelParcela.add(btnEjecutarParcela, "6, 8, left, top");
		
		
		frame.getContentPane().add(panelCabana, "name_434732751873000");
		panelCabana.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		
		panelCabana.add(lblSelectorCabana, "2, 2, right, default");
		listSelectorCabana.addListSelectionListener(new ListSelectorCabanaListSelectionListener());
		
		
		panelCabana.add(listSelectorCabana, "4, 2, 3, 1, fill, fill");
		
		
		panelCabana.add(textInformacionCabana, "2, 4, 5, 1, fill, fill");
		
		
		panelCabana.add(lblPrecioNombreCabana, "2, 6, right, default");
		
		
		panelCabana.add(lblPrecioCabana, "4, 6, left, default");
		btnEjecutarCabana.setEnabled(false);
		
		
		btnEjecutarCabana.addActionListener(new BtnEjecutarCabanaActionListener());
		panelCabana.add(btnEjecutarCabana, "6, 6");
		
		
		frame.getContentPane().add(panelRegistro, "name_434734742935100");
		panelRegistro.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(54dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(27dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(126dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(54dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		
		panelRegistro.add(lblNombre, "2, 2, right, default");
		
		
		panelRegistro.add(textNombre, "4, 2, 3, 1, fill, default");
		textNombre.setColumns(10);
		
		
		panelRegistro.add(lblApellidos, "2, 4, right, default");
		
		textApellidos = new JTextField();
		panelRegistro.add(textApellidos, "4, 4, 5, 1, fill, default");
		textApellidos.setColumns(10);
		
		
		panelRegistro.add(lblNPersonas, "2, 6, right, default");
		
		
		panelRegistro.add(spinnerNPersonas, "4, 6");
		
		
		panelRegistro.add(lblInformacionAdicional, "2, 8, 3, 1, right, default");
		
		
		panelRegistro.add(editorInformacion, "2, 10, 7, 1, fill, fill");
		btnRegistrar.addActionListener(new BtnRegistrarActionListener());
		
		
		panelRegistro.add(btnRegistrar, "8, 12");
		
		
		frame.getContentPane().add(panelExplorar, "name_436833961265900");
		panelExplorar.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		textBuscador = new JTextField();
		textBuscador.setText("Introduzca aqu\u00ED la b\u00FAsqueda deseada...");
		panelExplorar.add(textBuscador, "2, 2, fill, default");
		textBuscador.setColumns(10);
		
		
		lblIconoBuscador.setVerticalAlignment(SwingConstants.BOTTOM);
		panelExplorar.add(lblIconoBuscador, "4, 2");
		
		
		panelExplorar.add(textResultados, "2, 4, 3, 1, fill, fill");
	}

	private class BtnEjecutarParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout)frame.getLayout()).show(panelRegistro, arg0.getActionCommand());
			
			
		}
	}
	private class BtnEjecutarCabanaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout)frame.getLayout()).show(panelRegistro, arg0.getActionCommand());
		}
	}
	private class ComboTipoParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			GestorEstancias g = new GestorEstancias();
			vEstancias = g.leerParcelas((String)comboTipoParcela.getSelectedItem());
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			listSelectorParcela.setModel(listModel);
			for(int i=0;i<vEstancias.size();i++) {
				listModel.addElement("Parcela " + vEstancias.get(i).get(0));
			}
		}
	}
	private class ListSelectorParcelaListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			idEstancia = listSelectorParcela.getSelectedIndex();
			textInformacionParcela.setText((String) vEstancias.get(listSelectorParcela.getSelectedIndex()).get(3));
			lblPrecioParcela.setText((String)vEstancias.get(listSelectorParcela.getSelectedIndex()).get(4));
			btnEjecutarParcela.setEnabled(true);
		}
	}
	private class ListSelectorCabanaListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			idEstancia = listSelectorParcela.getSelectedIndex();
			textInformacionCabana.setText((String) vEstancias.get(listSelectorCabana.getSelectedIndex()).get(3));
			lblPrecioCabana.setText((String)vEstancias.get(listSelectorCabana.getSelectedIndex()).get(4));
			btnEjecutarCabana.setEnabled(true);
		}
	}
	private class BtnRegistrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			GestorReservas g = new GestorReservas();
			GestorEstancias g2 = new GestorEstancias();
			g.crearReserva((int)vEstancias.get(idEstancia).get(0), textNombre.getText(), textApellidos.getText(), spinnerNPersonas.getComponentCount(), editorInformacion.getText());
			g2.setReservado((int)vEstancias.get(idEstancia).get(0));
		}
	}
	public void mostrarCabañas() {
		GestorEstancias g = new GestorEstancias();
		vEstancias = g.leerCabañas();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listSelectorCabana.setModel(listModel);
		for(int i=0;i<vEstancias.size();i++) {
			listModel.addElement("Cabaña " + vEstancias.get(i).get(0));
		}
	}
	
	public JFrame getJFrame() {
		return this.frame;
	}
	public JPanel getPanelParcelas(){
		return this.panelParcela;
	}
	public JPanel getPanelCabana(){
		return this.panelCabana;
	}
	public JPanel getPanelExplorar(){
		return this.panelExplorar;
	}
}
