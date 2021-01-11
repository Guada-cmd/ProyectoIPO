package Presentacion.EditorGrafico;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiPanelIconos extends JPanel {
	
	private JLabel lblTituloIconos;
	private JLabel lblTramos;
	
	private JButton btnUbicacion;
	private JButton btnPuente;
	private JButton btnRio;
	private JButton btnMerendero;
	private JButton btnAcampada;
	private JButton btnAnimales;
	private JButton btnNoTiene;
	private JButton btnBaja;
	private JButton btnIntermedio;
	private JButton btnExperto;
	
	private final int FORMA_UBICACION = 10;
	private final int FORMA_PUENTE = 11;
	private final int FORMA_RIO = 12;
	private final int FORMA_MERENDEREO = 13;
	private final int FORMA_ACAMPADA = 14;
	private final int FORMA_ANIMAL = 15;
	
	private final int FORMA_NO_TIENE = 20;
	private final int FORMA_BAJA = 21;
	private final int FORMA_INTERMEDIO = 22;
	private final int FORMA_EXPERTO = 23;

	
	/**
	 * Create the panel.
	 */
	public MiPanelIconos() {
		
		inicializarDatosPanel();
		
		inicializarDatosPanelIconos();
		
		asignacionOyentePanelIconos();
	}
	/**
	 * 
	 * Descripcion: Personalizar los distintos cursores
	 * 
	 */
	public void asignacionOyentePanelIconos() {
		
		btnUbicacion.addActionListener(new BtnIconosActionListener());
		btnPuente.addActionListener(new BtnIconosActionListener());
		btnRio.addActionListener(new BtnIconosActionListener());
		btnMerendero.addActionListener(new BtnIconosActionListener());
		btnAcampada.addActionListener(new BtnIconosActionListener());
		btnAnimales.addActionListener(new BtnIconosActionListener());
		
		
		btnNoTiene.addActionListener(new BtnIconosTramosActionListener());
		btnBaja.addActionListener(new BtnIconosTramosActionListener());
		btnIntermedio.addActionListener(new BtnIconosTramosActionListener());
		btnExperto.addActionListener(new BtnIconosTramosActionListener());
		
	}
	/**
	 * 
	 * Descripcion: Inicializar los modos de los iconos para los tramos
	 *
	 */
	private class BtnIconosTramosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			if(arg0.getSource() == btnNoTiene) {
				
				EditorGraficoRuta.modo = FORMA_NO_TIENE;
				
			}
			else if(arg0.getSource() == btnBaja) {
				
				EditorGraficoRuta.modo = FORMA_BAJA;
				
			}
			else if(arg0.getSource() == btnIntermedio) {
				
				EditorGraficoRuta.modo = FORMA_INTERMEDIO;
				
			}
			else if(arg0.getSource() == btnExperto) {
				
				EditorGraficoRuta.modo = FORMA_EXPERTO;
				
			}
			
		}
	}
	/**
	 * 
	 * Descripcion: Incializar los modos de los distintos iconos
	 *
	 */
	private class BtnIconosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
	
			if(arg0.getSource() == btnUbicacion) {
				
				EditorGraficoRuta.modo = FORMA_UBICACION;
				
			}
			else if(arg0.getSource() == btnPuente) {
				
				EditorGraficoRuta.modo = FORMA_PUENTE;
				
			}
			else if(arg0.getSource() == btnRio) {
				
				EditorGraficoRuta.modo = FORMA_RIO;
				
			}
			else if(arg0.getSource() == btnMerendero) {
				
				EditorGraficoRuta.modo = FORMA_MERENDEREO;
				
			}
			else if(arg0.getSource() == btnAcampada) {
				
				EditorGraficoRuta.modo = FORMA_ACAMPADA;
				
			}
			else if(arg0.getSource() == btnAnimales) {
				
				EditorGraficoRuta.modo = FORMA_ANIMAL;
				
			}
		}
	}
	/**
	 * 
	 * Descripcion: inicializar los datos del panel de iconos
	 * 
	 */
	public void inicializarDatosPanel() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 50, 700));
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{24, 26, 0, -4, 0};
		gridBagLayout.rowHeights = new int[]{40, 38, 33, 34, 35, 36, 33, 37, 34, 34, 33, 33, 31, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTituloIconos = new JLabel("Iconos:");
		lblTituloIconos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_lblTituloIconos = new GridBagConstraints();
		gbc_lblTituloIconos.gridwidth = 3;
		gbc_lblTituloIconos.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloIconos.gridx = 1;
		gbc_lblTituloIconos.gridy = 0;
		add(lblTituloIconos, gbc_lblTituloIconos);
		
		btnUbicacion = new JButton("");
		btnUbicacion.setBackground(new Color(251, 251, 251));
		btnUbicacion.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/ubicacion.png")));
		GridBagConstraints gbc_btnUbicacion = new GridBagConstraints();
		gbc_btnUbicacion.gridwidth = 3;
		gbc_btnUbicacion.fill = GridBagConstraints.VERTICAL;
		gbc_btnUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_btnUbicacion.gridx = 1;
		gbc_btnUbicacion.gridy = 1;
		add(btnUbicacion, gbc_btnUbicacion);
		
		btnPuente = new JButton("");
		btnPuente.setBackground(new Color(251, 251, 251));
		btnPuente.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/puentes.png")));
		GridBagConstraints gbc_btnPuente = new GridBagConstraints();
		gbc_btnPuente.gridwidth = 3;
		gbc_btnPuente.fill = GridBagConstraints.VERTICAL;
		gbc_btnPuente.insets = new Insets(0, 0, 5, 0);
		gbc_btnPuente.gridx = 1;
		gbc_btnPuente.gridy = 2;
		add(btnPuente, gbc_btnPuente);
		
		btnRio = new JButton("");
		btnRio.setBackground(new Color(251, 251, 251));
		btnRio.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/rio.png")));
		GridBagConstraints gbc_btnRio = new GridBagConstraints();
		gbc_btnRio.gridwidth = 3;
		gbc_btnRio.fill = GridBagConstraints.VERTICAL;
		gbc_btnRio.insets = new Insets(0, 0, 5, 0);
		gbc_btnRio.gridx = 1;
		gbc_btnRio.gridy = 3;
		add(btnRio, gbc_btnRio);
		
		btnMerendero = new JButton("");
		btnMerendero.setBackground(new Color(251, 251, 251));
		btnMerendero.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/rest-area.png")));
		GridBagConstraints gbc_btnMerendero = new GridBagConstraints();
		gbc_btnMerendero.fill = GridBagConstraints.VERTICAL;
		gbc_btnMerendero.gridwidth = 3;
		gbc_btnMerendero.insets = new Insets(0, 0, 5, 0);
		gbc_btnMerendero.gridx = 1;
		gbc_btnMerendero.gridy = 4;
		add(btnMerendero, gbc_btnMerendero);
		
		btnAcampada = new JButton("");
		btnAcampada.setBackground(new Color(251, 251, 251));
		btnAcampada.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/noche.png")));
		GridBagConstraints gbc_btnAcampada = new GridBagConstraints();
		gbc_btnAcampada.fill = GridBagConstraints.VERTICAL;
		gbc_btnAcampada.gridwidth = 3;
		gbc_btnAcampada.insets = new Insets(0, 0, 5, 0);
		gbc_btnAcampada.gridx = 1;
		gbc_btnAcampada.gridy = 5;
		add(btnAcampada, gbc_btnAcampada);
		
		btnAnimales = new JButton("");
		btnAnimales.setBackground(new Color(251, 251, 251));
		btnAnimales.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/pata.png")));
		GridBagConstraints gbc_btnAnimales = new GridBagConstraints();
		gbc_btnAnimales.fill = GridBagConstraints.VERTICAL;
		gbc_btnAnimales.gridwidth = 3;
		gbc_btnAnimales.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnimales.gridx = 1;
		gbc_btnAnimales.gridy = 6;
		add(btnAnimales, gbc_btnAnimales);
		
		lblTramos = new JLabel("Tramos:");
		lblTramos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_lblTramos = new GridBagConstraints();
		gbc_lblTramos.gridwidth = 3;
		gbc_lblTramos.insets = new Insets(0, 0, 5, 0);
		gbc_lblTramos.gridx = 1;
		gbc_lblTramos.gridy = 7;
		add(lblTramos, gbc_lblTramos);
		
		btnNoTiene = new JButton("");
		btnNoTiene.setBackground(new Color(251, 251, 251));
		btnNoTiene.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/NoTiene.png")));
		GridBagConstraints gbc_btnNoTiene = new GridBagConstraints();
		gbc_btnNoTiene.fill = GridBagConstraints.VERTICAL;
		gbc_btnNoTiene.gridwidth = 3;
		gbc_btnNoTiene.insets = new Insets(0, 0, 5, 0);
		gbc_btnNoTiene.gridx = 1;
		gbc_btnNoTiene.gridy = 8;
		add(btnNoTiene, gbc_btnNoTiene);
		
		btnBaja = new JButton("");
		btnBaja.setBackground(new Color(251, 251, 251));
		btnBaja.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/baja.png")));
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.fill = GridBagConstraints.VERTICAL;
		gbc_btnBaja.gridwidth = 3;
		gbc_btnBaja.insets = new Insets(0, 0, 5, 0);
		gbc_btnBaja.gridx = 1;
		gbc_btnBaja.gridy = 9;
		add(btnBaja, gbc_btnBaja);
		
		btnIntermedio = new JButton("");
		btnIntermedio.setBackground(new Color(251, 251, 251));
		btnIntermedio.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/Intermedio.png")));
		GridBagConstraints gbc_btnIntermedio = new GridBagConstraints();
		gbc_btnIntermedio.fill = GridBagConstraints.VERTICAL;
		gbc_btnIntermedio.gridwidth = 3;
		gbc_btnIntermedio.insets = new Insets(0, 0, 5, 0);
		gbc_btnIntermedio.gridx = 1;
		gbc_btnIntermedio.gridy = 10;
		add(btnIntermedio, gbc_btnIntermedio);
		
		btnExperto = new JButton("");
		btnExperto.setBackground(new Color(251, 251, 251));
		btnExperto.setIcon(new ImageIcon(MiPanelIconos.class.getResource("/recursos/Rutas/Experto.png")));
		GridBagConstraints gbc_btnExperto = new GridBagConstraints();
		gbc_btnExperto.fill = GridBagConstraints.VERTICAL;
		gbc_btnExperto.gridwidth = 3;
		gbc_btnExperto.insets = new Insets(0, 0, 5, 0);
		gbc_btnExperto.gridx = 1;
		gbc_btnExperto.gridy = 11;
		add(btnExperto, gbc_btnExperto);
		
	}
	/**
	 * 
	 * Descripcion: inicializar los datos de los botones del panel iconos
	 * 
	 */
	public void inicializarDatosPanelIconos() {
		
	}
}
