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
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Reserva {

	private JFrame frame;
	private JTextField textApellidos;
	
	private JLabel lblTipoParcela = new JLabel("Tipo de parcela:");
	private JComboBox<String> comboTipoParcela = new JComboBox<String>();
	private JLabel lblSelectorParcela = new JLabel("Selector de parcela:");
	private JList<String> listSelectorParcela = new JList<String>();
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
	private JEditorPane editorInformacion = new JEditorPane();
	private JButton btnRegistrar = new JButton("Realizar registro");
	private JPanel panelExplorar = new JPanel();
	private JPanel panelParcela = new JPanel();
	
	private Vector<Vector<Object>> vEstancias = new Vector<Vector<Object>>();
	private int idEstancia;
	private Vector<Vector<Object>> reservas;
	private final JTextField textNombre = new JTextField();
	
	private final String PANE_PARCELAS = "paneParcelas";
	private final String PANE_CABANAS = "paneCabanas";
	private final String PANE_EXPLORAR = "paneExplorar";
	private final String PANE_REGISTRO = "paneRegistro";
	private final JTextPane textInformacionParcela = new JTextPane();
	private final JList<String> listReservas = new JList<String>();
	private final JTextPane textInformacionReservas = new JTextPane();
	private final JButton btnFinalizarReserva = new JButton("Finalizar reserva");
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
		textNombre.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		frame.getContentPane().add(panelParcela, PANE_PARCELAS);
		GridBagLayout gbl_panelParcela = new GridBagLayout();
		gbl_panelParcela.columnWidths = new int[]{93, 238, 75, 0};
		gbl_panelParcela.rowHeights = new int[]{19, 96, 101, 21, 0};
		gbl_panelParcela.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelParcela.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panelParcela.setLayout(gbl_panelParcela);
		
		
		GridBagConstraints gbc_lblTipoParcela = new GridBagConstraints();
		gbc_lblTipoParcela.anchor = GridBagConstraints.EAST;
		gbc_lblTipoParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoParcela.gridx = 0;
		gbc_lblTipoParcela.gridy = 0;
		panelParcela.add(lblTipoParcela, gbc_lblTipoParcela);
		comboTipoParcela.setModel(new DefaultComboBoxModel(new String[] {"pequeña", "mediana", "grande"}));
		comboTipoParcela.addActionListener(new ComboTipoParcelaActionListener());
		
		
		GridBagConstraints gbc_comboTipoParcela = new GridBagConstraints();
		gbc_comboTipoParcela.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipoParcela.anchor = GridBagConstraints.NORTH;
		gbc_comboTipoParcela.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoParcela.gridx = 1;
		gbc_comboTipoParcela.gridy = 0;
		panelParcela.add(comboTipoParcela, gbc_comboTipoParcela);
		
		
		GridBagConstraints gbc_lblSelectorParcela = new GridBagConstraints();
		gbc_lblSelectorParcela.anchor = GridBagConstraints.EAST;
		gbc_lblSelectorParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectorParcela.gridx = 0;
		gbc_lblSelectorParcela.gridy = 1;
		panelParcela.add(lblSelectorParcela, gbc_lblSelectorParcela);
		listSelectorParcela.addInputMethodListener(new ListSelectorParcelaInputMethodListener());
		listSelectorParcela.addListSelectionListener(new ListSelectorParcelaListSelectionListener());
		
		
		GridBagConstraints gbc_listSelectorParcela = new GridBagConstraints();
		gbc_listSelectorParcela.fill = GridBagConstraints.BOTH;
		gbc_listSelectorParcela.insets = new Insets(0, 0, 5, 0);
		gbc_listSelectorParcela.gridx = 1;
		gbc_listSelectorParcela.gridy = 1;
		panelParcela.add(listSelectorParcela, gbc_listSelectorParcela);
		
		GridBagConstraints gbc_textInformacionParcela = new GridBagConstraints();
		gbc_textInformacionParcela.gridwidth = 3;
		gbc_textInformacionParcela.insets = new Insets(0, 0, 5, 5);
		gbc_textInformacionParcela.fill = GridBagConstraints.BOTH;
		gbc_textInformacionParcela.gridx = 0;
		gbc_textInformacionParcela.gridy = 2;
		panelParcela.add(textInformacionParcela, gbc_textInformacionParcela);
		
		
		GridBagConstraints gbc_lblPrecioNombreParcela = new GridBagConstraints();
		gbc_lblPrecioNombreParcela.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioNombreParcela.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecioNombreParcela.gridx = 0;
		gbc_lblPrecioNombreParcela.gridy = 3;
		panelParcela.add(lblPrecioNombreParcela, gbc_lblPrecioNombreParcela);
		btnEjecutarParcela.setEnabled(false);
		
		
		btnEjecutarParcela.addActionListener(new BtnEjecutarParcelaActionListener());
		
		
		GridBagConstraints gbc_lblPrecioParcela = new GridBagConstraints();
		gbc_lblPrecioParcela.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrecioParcela.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecioParcela.gridx = 1;
		gbc_lblPrecioParcela.gridy = 3;
		panelParcela.add(lblPrecioParcela, gbc_lblPrecioParcela);
		GridBagConstraints gbc_btnEjecutarParcela = new GridBagConstraints();
		gbc_btnEjecutarParcela.gridx = 2;
		gbc_btnEjecutarParcela.gridy = 3;
		panelParcela.add(btnEjecutarParcela, gbc_btnEjecutarParcela);
		
		
		frame.getContentPane().add(panelCabana, PANE_CABANAS);
		GridBagLayout gbl_panelCabana = new GridBagLayout();
		gbl_panelCabana.columnWidths = new int[]{92, 6, 251, 75, 0};
		gbl_panelCabana.rowHeights = new int[]{109, 115, 21, 0};
		gbl_panelCabana.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCabana.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCabana.setLayout(gbl_panelCabana);
		listSelectorCabana.addListSelectionListener(new ListSelectorCabanaListSelectionListener());
		
		
		GridBagConstraints gbc_lblSelectorCabana = new GridBagConstraints();
		gbc_lblSelectorCabana.anchor = GridBagConstraints.EAST;
		gbc_lblSelectorCabana.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectorCabana.gridx = 0;
		gbc_lblSelectorCabana.gridy = 0;
		panelCabana.add(lblSelectorCabana, gbc_lblSelectorCabana);
		
		
		GridBagConstraints gbc_listSelectorCabana = new GridBagConstraints();
		gbc_listSelectorCabana.fill = GridBagConstraints.BOTH;
		gbc_listSelectorCabana.insets = new Insets(0, 0, 5, 0);
		gbc_listSelectorCabana.gridwidth = 3;
		gbc_listSelectorCabana.gridx = 1;
		gbc_listSelectorCabana.gridy = 0;
		panelCabana.add(listSelectorCabana, gbc_listSelectorCabana);
		
		
		GridBagConstraints gbc_textInformacionCabana = new GridBagConstraints();
		gbc_textInformacionCabana.fill = GridBagConstraints.BOTH;
		gbc_textInformacionCabana.insets = new Insets(0, 0, 5, 0);
		gbc_textInformacionCabana.gridwidth = 4;
		gbc_textInformacionCabana.gridx = 0;
		gbc_textInformacionCabana.gridy = 1;
		panelCabana.add(textInformacionCabana, gbc_textInformacionCabana);
		btnEjecutarCabana.setEnabled(false);
		
		
		btnEjecutarCabana.addActionListener(new BtnEjecutarCabanaActionListener());
		
		
		GridBagConstraints gbc_lblPrecioNombreCabana = new GridBagConstraints();
		gbc_lblPrecioNombreCabana.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioNombreCabana.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecioNombreCabana.gridx = 0;
		gbc_lblPrecioNombreCabana.gridy = 2;
		panelCabana.add(lblPrecioNombreCabana, gbc_lblPrecioNombreCabana);
		
		
		GridBagConstraints gbc_lblPrecioCabana = new GridBagConstraints();
		gbc_lblPrecioCabana.anchor = GridBagConstraints.WEST;
		gbc_lblPrecioCabana.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecioCabana.gridx = 1;
		gbc_lblPrecioCabana.gridy = 2;
		panelCabana.add(lblPrecioCabana, gbc_lblPrecioCabana);
		GridBagConstraints gbc_btnEjecutarCabana = new GridBagConstraints();
		gbc_btnEjecutarCabana.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEjecutarCabana.gridx = 3;
		gbc_btnEjecutarCabana.gridy = 2;
		panelCabana.add(btnEjecutarCabana, gbc_btnEjecutarCabana);
		
		
		frame.getContentPane().add(panelRegistro, PANE_REGISTRO);
		GridBagLayout gbl_panelRegistro = new GridBagLayout();
		gbl_panelRegistro.columnWidths = new int[]{75, 38, 100, 176, 0};
		gbl_panelRegistro.rowHeights = new int[]{13, 19, 20, 13, 141, 21, 0};
		gbl_panelRegistro.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelRegistro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRegistro.setLayout(gbl_panelRegistro);
		
		
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panelRegistro.add(lblNombre, gbc_lblNombre);
		
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 2;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		panelRegistro.add(textNombre, gbc_textNombre);
		
		
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 1;
		panelRegistro.add(lblApellidos, gbc_lblApellidos);
		
		textApellidos = new JTextField();
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.anchor = GridBagConstraints.NORTH;
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_textApellidos.gridwidth = 3;
		gbc_textApellidos.gridx = 1;
		gbc_textApellidos.gridy = 1;
		panelRegistro.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);
		btnRegistrar.addActionListener(new BtnRegistrarActionListener());
		
		
		GridBagConstraints gbc_lblNPersonas = new GridBagConstraints();
		gbc_lblNPersonas.anchor = GridBagConstraints.EAST;
		gbc_lblNPersonas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNPersonas.gridx = 0;
		gbc_lblNPersonas.gridy = 2;
		panelRegistro.add(lblNPersonas, gbc_lblNPersonas);
		
		
		GridBagConstraints gbc_spinnerNPersonas = new GridBagConstraints();
		gbc_spinnerNPersonas.anchor = GridBagConstraints.NORTH;
		gbc_spinnerNPersonas.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerNPersonas.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNPersonas.gridx = 1;
		gbc_spinnerNPersonas.gridy = 2;
		panelRegistro.add(spinnerNPersonas, gbc_spinnerNPersonas);
		
		
		GridBagConstraints gbc_lblInformacionAdicional = new GridBagConstraints();
		gbc_lblInformacionAdicional.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInformacionAdicional.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacionAdicional.gridwidth = 2;
		gbc_lblInformacionAdicional.gridx = 0;
		gbc_lblInformacionAdicional.gridy = 3;
		panelRegistro.add(lblInformacionAdicional, gbc_lblInformacionAdicional);
		
		
		GridBagConstraints gbc_editorInformacion = new GridBagConstraints();
		gbc_editorInformacion.fill = GridBagConstraints.BOTH;
		gbc_editorInformacion.insets = new Insets(0, 0, 5, 0);
		gbc_editorInformacion.gridwidth = 4;
		gbc_editorInformacion.gridx = 0;
		gbc_editorInformacion.gridy = 4;
		panelRegistro.add(editorInformacion, gbc_editorInformacion);
		
		
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.anchor = GridBagConstraints.NORTH;
		gbc_btnRegistrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrar.gridx = 3;
		gbc_btnRegistrar.gridy = 5;
		panelRegistro.add(btnRegistrar, gbc_btnRegistrar);
		
		
		
		
		frame.getContentPane().add(panelExplorar, PANE_EXPLORAR);
		GridBagLayout gbl_panelExplorar = new GridBagLayout();
		gbl_panelExplorar.columnWidths = new int[]{247, 16, 155, 0};
		gbl_panelExplorar.rowHeights = new int[]{156, 207, 0, 0};
		gbl_panelExplorar.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelExplorar.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelExplorar.setLayout(gbl_panelExplorar);
		
		GridBagConstraints gbc_listReservas = new GridBagConstraints();
		gbc_listReservas.insets = new Insets(0, 0, 5, 0);
		gbc_listReservas.gridwidth = 3;
		gbc_listReservas.fill = GridBagConstraints.BOTH;
		gbc_listReservas.gridx = 0;
		gbc_listReservas.gridy = 0;
		listReservas.addListSelectionListener(new ListReservasListSelectionListener());
		panelExplorar.add(listReservas, gbc_listReservas);
		
		GridBagConstraints gbc_textInformacionReservas = new GridBagConstraints();
		gbc_textInformacionReservas.insets = new Insets(0, 0, 5, 0);
		gbc_textInformacionReservas.gridwidth = 3;
		gbc_textInformacionReservas.fill = GridBagConstraints.BOTH;
		gbc_textInformacionReservas.gridx = 0;
		gbc_textInformacionReservas.gridy = 1;
		panelExplorar.add(textInformacionReservas, gbc_textInformacionReservas);
		
		GridBagConstraints gbc_btnFinalizarReserva = new GridBagConstraints();
		gbc_btnFinalizarReserva.gridx = 2;
		gbc_btnFinalizarReserva.gridy = 2;
		btnFinalizarReserva.addActionListener(new BtnEliminarReservaActionListener());
		btnFinalizarReserva.setEnabled(false);
		panelExplorar.add(btnFinalizarReserva, gbc_btnFinalizarReserva);
	}

	private class BtnEjecutarParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			showRegistroPane();
			
			
		}
	}
	private class BtnEjecutarCabanaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			showRegistroPane();
		}
	}
	private class ComboTipoParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mostrarParcelas();
			comboTipoParcela.hidePopup();
		}
	}
	private class ListSelectorParcelaListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {		
			idEstancia = (int)listSelectorParcela.getSelectedIndex();
			btnEjecutarParcela.setEnabled(true);
			textInformacionParcela.setText((String) vEstancias.get(idEstancia).get(3));
			lblPrecioParcela.setText((String)vEstancias.elementAt(idEstancia).elementAt(4));
		}
	}
	private class ListSelectorCabanaListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			idEstancia = listSelectorCabana.getSelectedIndex();
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
			frame.dispose();
		}
	}
	private class ListSelectorParcelaInputMethodListener implements InputMethodListener {
		public void caretPositionChanged(InputMethodEvent arg0) {
		}
		public void inputMethodTextChanged(InputMethodEvent arg0) {
		}
	}
	private class ListReservasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			
			int index = listReservas.getSelectedIndex();
			textInformacionReservas.setText("ID Reserva: " + reservas.elementAt(index).elementAt(0) +
					"\nNombre: "+ reservas.elementAt(index).elementAt(1) + " " + reservas.elementAt(index).elementAt(2)+
					"\nNúmero de personas: " + reservas.elementAt(index).elementAt(3) +
					"\nID estancia: "+ reservas.elementAt(index).elementAt(4) +
					"\nEstado: " + reservas.elementAt(index).elementAt(5) +
					"\nInformación adicional: " + reservas.elementAt(index).elementAt(6));
			if(reservas.elementAt(index).elementAt(5).equals("en proceso"))
				btnFinalizarReserva.setEnabled(true);
			else
				btnFinalizarReserva.setEnabled(false);
				
		}
	}
	private class BtnEliminarReservaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			GestorReservas g = new GestorReservas();
			GestorEstancias g2 = new GestorEstancias();
			g.cambiarEstadoReserva((int)reservas.elementAt(listReservas.getSelectedIndex()).elementAt(0));
			g2.setNoReservado((int)reservas.elementAt(listReservas.getSelectedIndex()).elementAt(4));
			frame.dispose();
		}
	}
	public void mostrarParcelas() {
		GestorEstancias g = new GestorEstancias();
		vEstancias = g.leerParcelas((String)comboTipoParcela.getSelectedItem());
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listSelectorParcela.setModel(listModel);
		for(int i=0;i<vEstancias.size();i++) {
			listModel.addElement("Parcela " + vEstancias.get(i).get(0));
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
	
	public void mostrarReservas() {
		GestorReservas g = new GestorReservas();
		reservas = g.leerReservas("en proceso");
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		listReservas.setModel(modelo);
		reservas.addAll(g.leerReservas("finalizada"));
		for (int i = 0; i < reservas.size(); i++) 
			modelo.addElement("Reserva " + reservas.elementAt(i).elementAt(0) + ": " + reservas.elementAt(i).elementAt(1) + " " + reservas.elementAt(i).elementAt(2) + ", reserva " + reservas.elementAt(i).elementAt(5));
	}
	public JFrame getJFrame() {
		return frame;
	}
	public void showParcelasPane() {
		 CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		 cl.show(frame.getContentPane(), PANE_PARCELAS);
	}
	public void showCabanasPane() {
		 CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		 cl.show(frame.getContentPane(), PANE_CABANAS);
	}
	public void showExplorarPane() {
		 CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		 cl.show(frame.getContentPane(), PANE_EXPLORAR);
	}
	public void showRegistroPane() {
		 CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		 cl.show(frame.getContentPane(), PANE_REGISTRO);
	}
	public boolean comprobarSubstring(String sub, String string) {
		if(string.indexOf(sub) !=-1) {
			return true;
		}else
			return false;
	}
}
