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
	private JLabel lblIconoBuscador = new JLabel("");
	private JEditorPane editorInformacion = new JEditorPane();
	private JButton btnRegistrar = new JButton("Realizar registro");
	private JPanel panelExplorar = new JPanel();
	private JPanel panelParcela = new JPanel();
	
	private Vector<Vector<Object>> vEstancias = new Vector<Vector<Object>>();
	private int idEstancia;
	private final JTable tableReservas = new JTable();
	private final JCheckBox chckbxMostrarReservasFinalizadas = new JCheckBox("Mostrar reservas finalizadas");
	private Vector<Vector<Object>> reservas;
	private final JTextField textNombre = new JTextField();
	
	private final String PANE_PARCELAS = "paneParcelas";
	private final String PANE_CABANAS = "paneCabanas";
	private final String PANE_EXPLORAR = "paneExplorar";
	private final String PANE_REGISTRO = "paneRegistro";
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
		gbl_panelParcela.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		listSelectorParcela.addListSelectionListener(new ListSelectorParcelaListSelectionListener());
		
		
		GridBagConstraints gbc_listSelectorParcela = new GridBagConstraints();
		gbc_listSelectorParcela.fill = GridBagConstraints.BOTH;
		gbc_listSelectorParcela.insets = new Insets(0, 0, 5, 0);
		gbc_listSelectorParcela.gridwidth = 2;
		gbc_listSelectorParcela.gridx = 1;
		gbc_listSelectorParcela.gridy = 1;
		panelParcela.add(listSelectorParcela, gbc_listSelectorParcela);
		
		
		GridBagConstraints gbc_textInformacionParcela = new GridBagConstraints();
		gbc_textInformacionParcela.fill = GridBagConstraints.VERTICAL;
		gbc_textInformacionParcela.gridwidth = 3;
		gbc_textInformacionParcela.insets = new Insets(0, 0, 5, 0);
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
		gbl_panelExplorar.rowHeights = new int[]{21, 230, 0};
		gbl_panelExplorar.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelExplorar.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelExplorar.setLayout(gbl_panelExplorar);
		tableReservas.addInputMethodListener(new TableReservasInputMethodListener());
		tableReservas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID reserva", "Apellidos", "Nombre", "N Pers", "ID estancia", "Estado", "Finalizar reserva"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableReservas.getColumnModel().getColumn(6).setResizable(false);
		tableReservas.getColumnModel().getColumn(6).setPreferredWidth(93);
		
		textBuscador = new JTextField();
		textBuscador.addActionListener(new TextBuscadorActionListener());
		textBuscador.addFocusListener(new TextBuscadorFocusListener());
		textBuscador.setText("Introduzca aqu\u00ED la b\u00FAsqueda deseada...");
		GridBagConstraints gbc_textBuscador = new GridBagConstraints();
		gbc_textBuscador.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBuscador.insets = new Insets(0, 0, 5, 5);
		gbc_textBuscador.gridx = 0;
		gbc_textBuscador.gridy = 0;
		panelExplorar.add(textBuscador, gbc_textBuscador);
		textBuscador.setColumns(10);
		lblIconoBuscador.setIcon(new ImageIcon(Reserva.class.getResource("/recursos/lupa.png")));
		
		
		lblIconoBuscador.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblIconoBuscador = new GridBagConstraints();
		gbc_lblIconoBuscador.anchor = GridBagConstraints.WEST;
		gbc_lblIconoBuscador.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconoBuscador.gridx = 1;
		gbc_lblIconoBuscador.gridy = 0;
		panelExplorar.add(lblIconoBuscador, gbc_lblIconoBuscador);
		chckbxMostrarReservasFinalizadas.addActionListener(new ChckbxMostrarReservasFinalizadasActionListener());
		
		GridBagConstraints gbc_chckbxMostrarReservasFinalizadas = new GridBagConstraints();
		gbc_chckbxMostrarReservasFinalizadas.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxMostrarReservasFinalizadas.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxMostrarReservasFinalizadas.gridx = 2;
		gbc_chckbxMostrarReservasFinalizadas.gridy = 0;
		panelExplorar.add(chckbxMostrarReservasFinalizadas, gbc_chckbxMostrarReservasFinalizadas);
		
		GridBagConstraints gbc_tableReservas = new GridBagConstraints();
		gbc_tableReservas.fill = GridBagConstraints.BOTH;
		gbc_tableReservas.gridwidth = 3;
		gbc_tableReservas.gridx = 0;
		gbc_tableReservas.gridy = 1;
		panelExplorar.add(tableReservas, gbc_tableReservas);
	}

	private class BtnEjecutarParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout)frame.getLayout()).show(panelRegistro, PANE_REGISTRO);
			
			
		}
	}
	private class BtnEjecutarCabanaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout)frame.getLayout()).show(panelRegistro, PANE_REGISTRO);
		}
	}
	private class ComboTipoParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mostrarParcelas();
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
		}
	}
	private class TableReservasInputMethodListener implements InputMethodListener {
		public void inputMethodTextChanged(InputMethodEvent arg0) {
			if((String) reservas.elementAt(tableReservas.getSelectedRow()).elementAt(5) == "en proceso") {
				GestorReservas g = new GestorReservas();
				GestorEstancias g2= new GestorEstancias();
				g.cambiarEstadoReserva((int)reservas.elementAt(tableReservas.getSelectedRow()).elementAt(0));
				mostrarReservas(chckbxMostrarReservasFinalizadas.isSelected());
			}
		}
		public void caretPositionChanged(InputMethodEvent arg0) {
		}
	}
	private class ChckbxMostrarReservasFinalizadasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mostrarReservas(chckbxMostrarReservasFinalizadas.isSelected());
		}
	}
	private class TextBuscadorFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			textBuscador.setText("");
		}
	}
	private class TextBuscadorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			DefaultTableModel modelo = new DefaultTableModel();
			tableReservas.setModel(modelo);
			for (int i = 0; i < reservas.size(); i++) {
				if(comprobarSubstring(textBuscador.getText(),(String)reservas.elementAt(i).elementAt(0)) || 
					comprobarSubstring(textBuscador.getText(),(String)reservas.elementAt(i).elementAt(1)) || 
					comprobarSubstring(textBuscador.getText(),(String)reservas.elementAt(i).elementAt(2)) || 
					comprobarSubstring(textBuscador.getText(),(String)reservas.elementAt(i).elementAt(3)) ||
					comprobarSubstring(textBuscador.getText(),(String)reservas.elementAt(i).elementAt(4))){
					Object[] linea = {reservas.elementAt(i).elementAt(0),
							reservas.elementAt(i).elementAt(3),
							reservas.elementAt(i).elementAt(2),
							reservas.elementAt(i).elementAt(4),
							reservas.elementAt(i).elementAt(1),
							reservas.elementAt(i).elementAt(5),
							(((String)reservas.elementAt(i).elementAt(5)).equals("en proceso"))?true:false};
					modelo.addRow(linea);
				}
			}
			
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
	
	public void mostrarReservas(boolean mostrarReservasFinalizadas) {
		GestorReservas g = new GestorReservas();
		reservas = g.leerReservas("en proceso");
		DefaultTableModel modelo = new DefaultTableModel();
		tableReservas.setModel(modelo);
		for (int i = 0; i < reservas.size(); i++) {
			Object[] linea = {reservas.elementAt(i).elementAt(0),
					reservas.elementAt(i).elementAt(3),
					reservas.elementAt(i).elementAt(2),
					reservas.elementAt(i).elementAt(4),
					reservas.elementAt(i).elementAt(1),
					reservas.elementAt(i).elementAt(5),
					false};
			modelo.addRow(linea);
		}
		
		if(mostrarReservasFinalizadas) {
			Vector<Vector<Object>> reservasFinalizadas = g.leerReservas("finalizada");
			reservas.addAll(reservasFinalizadas);
			for (int i = 0; i < reservasFinalizadas.size(); i++) {
				Object[] linea = {reservasFinalizadas.elementAt(i).elementAt(0),
						reservasFinalizadas.elementAt(i).elementAt(3),
						reservasFinalizadas.elementAt(i).elementAt(2),
						reservasFinalizadas.elementAt(i).elementAt(4),
						reservasFinalizadas.elementAt(i).elementAt(1),
						reservasFinalizadas.elementAt(i).elementAt(5),
						true};
				modelo.addRow(linea);
			}
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
