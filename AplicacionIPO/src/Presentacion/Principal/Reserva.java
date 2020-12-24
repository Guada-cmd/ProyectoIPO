package Presentacion.Principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Reserva {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textBuscador;

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
		
		JPanel panelParcela = new JPanel();
		frame.getContentPane().add(panelParcela, "name_434725706504700");
		panelParcela.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(75dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblTipoParcela = new JLabel("Tipo de parcela:");
		panelParcela.add(lblTipoParcela, "2, 2, right, default");
		
		JComboBox comboTipoParcela = new JComboBox();
		panelParcela.add(comboTipoParcela, "4, 2, fill, default");
		
		JLabel lblSelectorParcela = new JLabel("Selector de parcela:");
		panelParcela.add(lblSelectorParcela, "2, 4, right, default");
		
		JList listSelectorParcela = new JList();
		panelParcela.add(listSelectorParcela, "4, 4, 3, 1, fill, fill");
		
		JTextPane textInformacionParcela = new JTextPane();
		panelParcela.add(textInformacionParcela, "2, 6, 5, 1, right, fill");
		
		JLabel lblPrecioNombreParcela = new JLabel("Precio:");
		panelParcela.add(lblPrecioNombreParcela, "2, 8, right, default");
		
		JLabel lblPrecioParcela = new JLabel("0");
		panelParcela.add(lblPrecioParcela, "4, 8");
		
		JButton btnEjecutarParcela = new JButton("Registrar");
		panelParcela.add(btnEjecutarParcela, "6, 8");
		
		JPanel panelCabana = new JPanel();
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
		
		JLabel lblSelectorCabana = new JLabel("Selector de caba\u00F1a:");
		panelCabana.add(lblSelectorCabana, "2, 2, right, default");
		
		JList listSelectorCabana = new JList();
		panelCabana.add(listSelectorCabana, "4, 2, 3, 1, fill, fill");
		
		JTextPane textInformacionCabana = new JTextPane();
		panelCabana.add(textInformacionCabana, "2, 4, 5, 1, fill, fill");
		
		JLabel lblPrecioNombreCabana = new JLabel("Precio:");
		panelCabana.add(lblPrecioNombreCabana, "2, 6, right, default");
		
		JLabel lblPrecioCabana = new JLabel("0");
		panelCabana.add(lblPrecioCabana, "4, 6, left, default");
		
		JButton btnEjecutarCabana = new JButton("Registrar");
		panelCabana.add(btnEjecutarCabana, "6, 6");
		
		JPanel panelRegistro = new JPanel();
		frame.getContentPane().add(panelRegistro, "name_434734742935100");
		panelRegistro.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(54dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(27dlu;default)"),
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
		
		JLabel lblNombre = new JLabel("Nombre:");
		panelRegistro.add(lblNombre, "2, 2, right, default");
		
		textNombre = new JTextField();
		panelRegistro.add(textNombre, "4, 2, 3, 1, fill, default");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		panelRegistro.add(lblApellidos, "2, 4, right, default");
		
		textApellidos = new JTextField();
		panelRegistro.add(textApellidos, "4, 4, 5, 1, fill, default");
		textApellidos.setColumns(10);
		
		JLabel lblNPersonas = new JLabel("Num. pers:");
		panelRegistro.add(lblNPersonas, "2, 6, right, default");
		
		JSpinner spinnerNPersonas = new JSpinner();
		panelRegistro.add(spinnerNPersonas, "4, 6");
		
		JLabel lblInformacionAdicional = new JLabel("Informaci\u00F3n adicional:");
		panelRegistro.add(lblInformacionAdicional, "2, 8, 3, 1, right, default");
		
		JEditorPane editorInformacion = new JEditorPane();
		panelRegistro.add(editorInformacion, "2, 10, 7, 1, fill, fill");
		
		JButton btnRegistrar = new JButton("Realizar registro");
		panelRegistro.add(btnRegistrar, "8, 12");
		
		JPanel panelExplorar = new JPanel();
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
		
		JLabel lblIconoBuscador = new JLabel("ICO");
		lblIconoBuscador.setVerticalAlignment(SwingConstants.BOTTOM);
		panelExplorar.add(lblIconoBuscador, "4, 2");
		
		JTextPane textResultados = new JTextPane();
		panelExplorar.add(textResultados, "2, 4, 3, 1, fill, fill");
	}

}
