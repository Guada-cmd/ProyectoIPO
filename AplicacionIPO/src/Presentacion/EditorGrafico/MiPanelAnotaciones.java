package Presentacion.EditorGrafico;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MiPanelAnotaciones extends JPanel {
	
	private JButton btnColorRojo;
	private JButton btnColorNaranja;
	private JButton btnColorAmarillo;
	private JButton btnColorVerde;
	private JButton btnColorAzul;
	private JButton btnColorGris;
	private JButton btnColorBlanco;
	private JButton btnColorNegro;
	private JButton btnTextoAnotacion;
	private JButton btnFormaRectangulo;
	private JButton btnFormaCirculo;
	private JButton btnFormaTriangulo;
	private JButton btnFormaLinea;
	
	private JLabel lblTituloFormas;
	private JLabel lblTituloColores;
	private JLabel lblTituloTexto;
	
	//variable constantes
	
	private final int FORMA_RECTANGULO = 1;
	private final int FORMA_LINEA = 2;
	private final int FORMA_CIRCULO = 3;
	private final int FORMA_TRIANGULO = 4;
	
	private final int TEXTO = 5;
	
	//variable constantes
	
	private final int ROJO = 1;
	private final int NARANJA = 2;
	private final int AMARILLO = 3;
	private final int VERDE = 4;
	private final int AZUL = 5;
	private final int GRIS = 6;
	private final int BLANCO = 7;
	private final int NEGRO = 8;

	
	/**
	 * Create the panel.
	 */
	public MiPanelAnotaciones() {
		
		//Metodo con el codigo de inicializacion del panel que se nos genera automaticamente
		inicializarPanel();
		
		//Metodo con el codigo de inicializacion de las etiquetas que se nos genera automaticamente
		inicializarEtiquetas();
		
		//Metodo con el codigo de inicializacion de las etiquetas que se nos genera automaticamente
		inicializarBotones();
		
		//Metodo para asociar los oyentes a los botones de las formas
		asignacionOyentesBotonesFormas();
		
		//Metodo para asociar los oyentes a los botones de las formas
		asignacionOyentesBotonesColores();
		
		//Metodo para asociar el oyente al boton texto
		asignacionOyenteBotonTexto();
		
		
	}
	/**
	 * 
	 * Descripcion: Metodo para inicializar el panel
	 * 
	 */
	public void inicializarPanel() {
		
		setBackground(new Color(255, 255, 255));
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{11, 0, 0, 16, 0};
		gridBagLayout.rowHeights = new int[]{36, 34, 34, 37, 33, 30, 29, 31, 31, 31, 27, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	/**
	 * 
	 * Descripcion: Metodo para inicializar las etiquetas
	 * 
	 */
	public void inicializarEtiquetas() {
		
		//Etiqueta con el nombre de Color
		
		lblTituloColores = new JLabel("Colores:");
		lblTituloColores.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_lblTituloColores = new GridBagConstraints();
		gbc_lblTituloColores.gridwidth = 2;
		gbc_lblTituloColores.insets = new Insets(0, 0, 5, 5);
		gbc_lblTituloColores.gridx = 1;
		gbc_lblTituloColores.gridy = 0;
		add(lblTituloColores, gbc_lblTituloColores);
		
		//Boton color rojo
		
		btnColorRojo = new JButton("");
		btnColorRojo.setSize(new Dimension(10, 10));
		btnColorRojo.setBackground(Color.RED);
		GridBagConstraints gbc_btnColorRojo = new GridBagConstraints();
		gbc_btnColorRojo.fill = GridBagConstraints.VERTICAL;
		gbc_btnColorRojo.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorRojo.gridx = 1;
		gbc_btnColorRojo.gridy = 1;
		add(btnColorRojo, gbc_btnColorRojo);
		
		//Boton color naranja
		
		btnColorNaranja = new JButton("");
		btnColorNaranja.setBackground(Color.ORANGE);
		GridBagConstraints gbc_btnColorNaranja = new GridBagConstraints();
		gbc_btnColorNaranja.fill = GridBagConstraints.BOTH;
		gbc_btnColorNaranja.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorNaranja.gridx = 2;
		gbc_btnColorNaranja.gridy = 1;
		add(btnColorNaranja, gbc_btnColorNaranja);
		
		//Boton color amarillo
		
		btnColorAmarillo = new JButton("");
		btnColorAmarillo.setBackground(new Color(255, 255, 0));
		GridBagConstraints gbc_btnColorAmarillo = new GridBagConstraints();
		gbc_btnColorAmarillo.fill = GridBagConstraints.VERTICAL;
		gbc_btnColorAmarillo.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorAmarillo.gridx = 1;
		gbc_btnColorAmarillo.gridy = 2;
		add(btnColorAmarillo, gbc_btnColorAmarillo);
		
		//Boton color verde
		
		btnColorVerde = new JButton("");
		btnColorVerde.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_btnColorVerde = new GridBagConstraints();
		gbc_btnColorVerde.fill = GridBagConstraints.BOTH;
		gbc_btnColorVerde.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorVerde.gridx = 2;
		gbc_btnColorVerde.gridy = 2;
		add(btnColorVerde, gbc_btnColorVerde);
		
		//Boton color azul
		
		btnColorAzul = new JButton("");
		btnColorAzul.setBackground(new Color(0, 0, 139));
		GridBagConstraints gbc_btnColorAzul = new GridBagConstraints();
		gbc_btnColorAzul.fill = GridBagConstraints.VERTICAL;
		gbc_btnColorAzul.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorAzul.gridx = 1;
		gbc_btnColorAzul.gridy = 3;
		add(btnColorAzul, gbc_btnColorAzul);
		
		//Boton color morado
		
		btnColorGris = new JButton("");
		btnColorGris.setBackground(new Color(128, 128, 128));
		GridBagConstraints gbc_btnColorGris = new GridBagConstraints();
		gbc_btnColorGris.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorGris.fill = GridBagConstraints.BOTH;
		gbc_btnColorGris.gridx = 2;
		gbc_btnColorGris.gridy = 3;
		add(btnColorGris, gbc_btnColorGris);
		
		//Boton color blanco
		
		btnColorBlanco = new JButton("");
		btnColorBlanco.setSize(new Dimension(10, 10));
		btnColorBlanco.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnColorBlanco = new GridBagConstraints();
		gbc_btnColorBlanco.fill = GridBagConstraints.VERTICAL;
		gbc_btnColorBlanco.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorBlanco.gridx = 1;
		gbc_btnColorBlanco.gridy = 4;
		add(btnColorBlanco, gbc_btnColorBlanco);
		
		//Boton color negro
		
		btnColorNegro = new JButton("");
		btnColorNegro.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnColorNegro = new GridBagConstraints();
		gbc_btnColorNegro.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorNegro.fill = GridBagConstraints.BOTH;
		gbc_btnColorNegro.gridx = 2;
		gbc_btnColorNegro.gridy = 4;
		add(btnColorNegro, gbc_btnColorNegro);
		
		//Etiqueta con el nombre de Formas
		
		lblTituloFormas = new JLabel("Formas:");
		lblTituloFormas.setBackground(new Color(255, 255, 255));
		lblTituloFormas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_lblTituloFormas = new GridBagConstraints();
		gbc_lblTituloFormas.gridwidth = 2;
		gbc_lblTituloFormas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTituloFormas.gridx = 1;
		gbc_lblTituloFormas.gridy = 5;
		add(lblTituloFormas, gbc_lblTituloFormas);
		
		//Botones formas
		
		//Boton rectangulo
		
		btnFormaRectangulo = new JButton("");
		btnFormaRectangulo.setIcon(new ImageIcon(MiPanelAnotaciones.class.getResource("/recursos/rectangle.png")));
		GridBagConstraints gbc_btnFormaRectangulo = new GridBagConstraints();
		gbc_btnFormaRectangulo.gridwidth = 2;
		
		btnFormaRectangulo.setBackground(new Color(251, 251, 251));
		
		gbc_btnFormaRectangulo.fill = GridBagConstraints.VERTICAL;
		gbc_btnFormaRectangulo.insets = new Insets(0, 0, 5, 5);
		gbc_btnFormaRectangulo.gridx = 1;
		gbc_btnFormaRectangulo.gridy = 6;
		add(btnFormaRectangulo, gbc_btnFormaRectangulo);
		
		//Boton linea
		
		btnFormaLinea = new JButton("");
		btnFormaLinea.setIcon(new ImageIcon(MiPanelAnotaciones.class.getResource("/recursos/line.png")));
		GridBagConstraints gbc_btnFormaLinea = new GridBagConstraints();
		gbc_btnFormaLinea.gridwidth = 2;
		
		btnFormaLinea.setBackground(new Color(251, 251, 251));
		
		gbc_btnFormaLinea.fill = GridBagConstraints.VERTICAL;
		gbc_btnFormaLinea.insets = new Insets(0, 0, 5, 5);
		gbc_btnFormaLinea.gridx = 1;
		gbc_btnFormaLinea.gridy = 7;
		add(btnFormaLinea, gbc_btnFormaLinea);
		
		//Boton triangulo
		
		btnFormaTriangulo = new JButton("");
		btnFormaTriangulo.setIcon(new ImageIcon(MiPanelAnotaciones.class.getResource("/recursos/triangle.png")));
		GridBagConstraints gbc_btnFormaTriangulo = new GridBagConstraints();
		gbc_btnFormaTriangulo.gridwidth = 2;
		
		btnFormaTriangulo.setBackground(new Color(251, 251, 251));
		
		gbc_btnFormaTriangulo.fill = GridBagConstraints.VERTICAL;
		gbc_btnFormaTriangulo.insets = new Insets(0, 0, 5, 5);
		gbc_btnFormaTriangulo.gridx = 1;
		gbc_btnFormaTriangulo.gridy = 8;
		add(btnFormaTriangulo, gbc_btnFormaTriangulo);
		
		//Boton circulo
		
		btnFormaCirculo = new JButton("");
		btnFormaCirculo.setIcon(new ImageIcon(MiPanelAnotaciones.class.getResource("/recursos/circle.png")));
		GridBagConstraints gbc_btnFormaCirculo = new GridBagConstraints();
		gbc_btnFormaCirculo.gridwidth = 2;
		
		btnFormaCirculo.setBackground(new Color(251, 251, 251));
		
		gbc_btnFormaCirculo.fill = GridBagConstraints.VERTICAL;
		gbc_btnFormaCirculo.insets = new Insets(0, 0, 5, 5);
		gbc_btnFormaCirculo.gridx = 1;
		gbc_btnFormaCirculo.gridy = 9;
		add(btnFormaCirculo, gbc_btnFormaCirculo);
		
	}
	/**
	 * 
	 * Descripcion: Metodo para inicializar los botones
	 * 
	 */
	public void inicializarBotones() {
		
		//Etiqueta con el nombre de Texto
		
		lblTituloTexto = new JLabel("Texto:");
		lblTituloTexto.setBackground(new Color(255, 255, 255));
		lblTituloTexto.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_lblTituloTexto = new GridBagConstraints();
		gbc_lblTituloTexto.gridwidth = 2;
		gbc_lblTituloTexto.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloTexto.gridx = 1;
		gbc_lblTituloTexto.gridy = 10;
		add(lblTituloTexto, gbc_lblTituloTexto);
		
		//Boton para escribir texto
		
		//Boton anotacion
		
		btnTextoAnotacion = new JButton("");
		btnTextoAnotacion.setIcon(new ImageIcon(MiPanelAnotaciones.class.getResource("/recursos/text.png")));
		
		btnTextoAnotacion.setBackground(new Color(251, 251, 251));
		
		GridBagConstraints gbc_btnTextoAnotacion = new GridBagConstraints();
		gbc_btnTextoAnotacion.insets = new Insets(0, 0, 0, 5);
		gbc_btnTextoAnotacion.gridwidth = 2;
		gbc_btnTextoAnotacion.fill = GridBagConstraints.VERTICAL;
		gbc_btnTextoAnotacion.gridx = 1;
		gbc_btnTextoAnotacion.gridy = 11;
		add(btnTextoAnotacion, gbc_btnTextoAnotacion);
	
	}
	public void asignacionOyentesBotonesFormas() {
		
		btnFormaRectangulo.addActionListener(new BtnFormaRectanguloActionListener());
		btnFormaLinea.addActionListener(new BtnFormaLineaActionListener());
		btnFormaCirculo.addActionListener(new BtnFormaCirculoActionListener());
		btnFormaTriangulo.addActionListener(new  BtnFormaTrianguloActionListener());
		
	}
	
	public void asignacionOyentesBotonesColores() {
		
		btnColorRojo.addActionListener(new BtnColorRojoActionListener());
		btnColorNaranja.addActionListener(new BtnColorNaranjaActionListener());
		btnColorAmarillo.addActionListener(new BtnColorAmarilloActionListener());
		btnColorVerde.addActionListener(new BtnColorVerdeActionListener());
		btnColorAzul.addActionListener(new BtnColorAzulActionListener());
		btnColorGris.addActionListener(new BtnColorGrisActionListener());
		btnColorBlanco.addActionListener(new BtnColorBlancoActionListener());
		btnColorNegro.addActionListener(new BtnColorNegroActionListener());
		
	}
	
	public void asignacionOyenteBotonTexto() {
		
		btnTextoAnotacion.addActionListener(new BtnTxtoAnotacionActionListener());
		
	}
	private class BtnTxtoAnotacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.modo = TEXTO;
			
		}
	}
	
	private class BtnColorRojoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = ROJO;
			
		}
	}
	private class BtnColorNaranjaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = NARANJA;
			
		}
	}
	
	private class BtnColorAmarilloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = AMARILLO;
			
		}
	}
	private class BtnColorVerdeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = VERDE;
			
		}
	}
	private class BtnColorAzulActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = AZUL;
			
		}
	}
	private class BtnColorGrisActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = GRIS;
			
		}
	}
	private class BtnColorBlancoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = BLANCO;
			
		}
	}
	private class BtnColorNegroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.color = NEGRO;
			
		}
	}
	
	private class BtnFormaRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.modo = FORMA_RECTANGULO;
			
		}
	}
	private class BtnFormaLineaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.modo = FORMA_LINEA;
			
		}
	}
	private class BtnFormaCirculoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.modo = FORMA_CIRCULO;
			
		}
	}
	private class BtnFormaTrianguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			EditorGraficoRuta.modo = FORMA_TRIANGULO;
			
		}
	}
}
