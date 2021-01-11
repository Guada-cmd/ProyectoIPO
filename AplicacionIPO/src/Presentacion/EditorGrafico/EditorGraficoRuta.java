package Presentacion.EditorGrafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.gestorPerfil;
import Persistencia.gestorRutas;
import Presentacion.InicioSesion.FormularioRegistro;
import Presentacion.InicioSesion.VentanaInicio;
import Presentacion.Principal.AplicacionPrincipal;

import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class EditorGraficoRuta extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mArchivo;
	private JMenuItem miAbrir;
	private JMenuItem miNuevo;
	private JMenuItem miGuardar;
	private JSeparator separator;
	private JMenuItem miAcercaEditorGrafico;
	private JMenuItem miSalir;
	private JMenu mVer;
	private JMenuItem miAcercar;
	private JMenuItem miAlejar;
	private JToolBar tbBarraFuncionalidades;
	private JScrollPane scrollPane;
	private JButton btnCargarRuta;
	private JButton btnIconosRepresentativos;
	private JButton btnAnotaciones;
	
	//Creaccion de los atributos para las coordenadas
	
	private int x;
	private int y;
	
	//Variable a la que se le asignara un color depensiendo del boton pulsado
	
	private Color color_forma;
	
	//Variable donde se podra escribir texto
	
	private JTextField txtTexto = new JTextField();
	
	//Como estamos utilizando un JFrame necesitamos crear un atributo privado a nivel de clase
	
	private JFrame frame;
	
	//Area de dibujo personalizada (creada extendiendo de JLabel)
	
	private MiAreaDibujo miAreaDibujo;
	
	//Imagen en la que se cargará el fichero seleccionado por el usuario 
	
	private ImageIcon imagen;
	private JPanel pnlContenido;
	private JPanel pnlIconos;
	private JPanel pnlAnotaciones;
	private JButton btnLimpiar;
	
	//Variable global para pulsar los botones de otros paneles
	
	public static int modo = -1;
	public static int color = -1;
	
	//Variable constantes
	
	private final int RECTANGULO = 1;
	private final int LINEA = 2;
	private final int TRIANGULO = 3;
	private final int CIRCULO = 4;
	private final int TEXTO = 5;
	
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
	
	private ImageIcon imagenNueva;
	
	//Creamos atributos para las distintas imagenes y punteros de raton personalizados usados en la aplicacion
	//Cursores e imagenes
	private Toolkit toolkit;
		
	private Image imagUbicacion;
	private Image imagPuente;
	private Image imagRio;
	private Image imagMerendero;
	private Image imagAcampada;
	private Image imagAnimal;
		
	private Image imagNoTiene;
	private Image imagBaja;
	private Image imagIntermedio;
	private Image imagNoExperto;
		
	private Image imagCursorUbicacion;
	private Image imagCursorPuente;
	private Image imagCursorRio;
	private Image imagCursorMerendero;
	private Image imagCursorAcampada;
	private Image imagCursorAnimal;
		
	private Image imagCursorNoTiene;
	private Image imagCursorBaja;
	private Image imagCursorIntermedio;
	private Image imagCursorExperto;
			
	private Cursor cursorUbicacion;
	private Cursor cursorPuente;
	private Cursor cursorRio;
	private Cursor cursorMerendero;
	private Cursor cursorAcampada;
	private Cursor cursorAnimal;
		
	private Cursor cursorNoTiene;
	private Cursor cursorBaja;
	private Cursor cursorIntermedio;
	private Cursor cursorExperto;

	private String ruta_personalizada;
	private int index_foto;
	
	private gestorRutas metodos_gestor_rutas = new gestorRutas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorGraficoRuta frame = new EditorGraficoRuta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditorGraficoRuta() {
		
		
		inicializarDatosEditorGraficoRutas();
		
		//Inicializacion de los datos de la barra de menu
		inicializarDatosBarraMenu();
		
		//Inicializacion de los datos del panel contenido donde se visualizaran los principales componente y acciones de Editor Grafico
		inicializarDatosPanelPrincipal();
		
		//Inicializacion de los datos de la Barra de Funcionalidades que contiene botones y se encuentarn dentro del Panel Principal
		inicializarDatosBarraFuncionalidades();
		
		//Inicializacion de los datos de la componente Scroll Pane que contendra el area de dibujo
		inicializarDatosComponenteScrollPane();
	
		//Inicializacion de los datos del Panel llamado Panel Contenido 
		inicializarDatosPanelContenido();
		
		//Inicializacion de los datos de mi area de dibujo personalizada
		inicializarDatosAreaDibujoPersonalizada();
		
		//Cerrar editor grafico
		cerrarEditorRutas();
		
		asociacionOyentesEditorGrafico();
		
		personalizarCursorEditorGrafico();
		
		centrarEditorRutas();
		
	}
	/**
	 * 
	 * Descripcion: Metodo que permite crear las imagenes y los cursores personalizados.
	 * 
	 */
	public void personalizarCursorEditorGrafico() {
		
	
		//Creación de imágenes y cursores
		toolkit = Toolkit.getDefaultToolkit();
		
		imagUbicacion = toolkit.getImage(getClass().getClassLoader().getResource("recursos/ubicacion.png"));
		imagPuente = toolkit.getImage(getClass().getClassLoader().getResource("recursos/puentes.png"));
		imagRio = toolkit.getImage(getClass().getClassLoader().getResource("recursos/rio.png"));
		imagMerendero = toolkit.getImage(getClass().getClassLoader().getResource("recursos/rest-area.png"));
		imagAcampada = toolkit.getImage(getClass().getClassLoader().getResource("recursos/noche.png"));
		imagAnimal = toolkit.getImage(getClass().getClassLoader().getResource("recursos/pata.png"));
		
		imagNoTiene = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/NoTiene.png"));
		imagBaja = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/baja.png"));
		imagIntermedio = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/Intermedio.png"));
		imagNoExperto = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/Experto.png"));
		
		imagCursorUbicacion = toolkit.getImage(getClass().getClassLoader().getResource("recursos/ubicacion.png"));
		imagCursorPuente = toolkit.getImage(getClass().getClassLoader().getResource("recursos/puentes.png"));
		imagCursorRio = toolkit.getImage(getClass().getClassLoader().getResource("recursos/rio.png"));
		imagCursorMerendero = toolkit.getImage(getClass().getClassLoader().getResource("recursos/rest-area.png"));
		imagCursorAcampada = toolkit.getImage(getClass().getClassLoader().getResource("recursos/noche.png"));
		imagCursorAnimal = toolkit.getImage(getClass().getClassLoader().getResource("recursos/pata.png"));
		
		imagCursorNoTiene = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/NoTiene.png"));
		imagCursorBaja = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/baja.png"));
		imagCursorIntermedio = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/Intermedio.png"));
		imagCursorExperto = toolkit.getImage(getClass().getClassLoader().getResource("recursos/Rutas/Experto.png"));
		
		//Creación de los cursores
		cursorUbicacion = toolkit.createCustomCursor(imagCursorUbicacion,new Point(0,0),"CURSOR_UBICACION");
		cursorPuente = toolkit.createCustomCursor(imagCursorPuente,new Point(0,0),"CURSOR_PUENTE");
		cursorRio = toolkit.createCustomCursor(imagCursorRio,new Point(0,0),"CURSOR_RIO");
		cursorMerendero = toolkit.createCustomCursor(imagCursorMerendero,new Point(0,0),"CURSOR_MERENDERO");
		cursorAcampada = toolkit.createCustomCursor(imagCursorAcampada,new Point(0,0),"CURSOR_ACAMPADA");
		cursorAnimal = toolkit.createCustomCursor(imagCursorAnimal,new Point(0,0),"CURSOR_ANIMAL");
		
		cursorNoTiene = toolkit.createCustomCursor(imagCursorNoTiene,new Point(0,0),"CURSOR_NOTIENE");
		cursorBaja = toolkit.createCustomCursor(imagCursorBaja,new Point(0,0),"CURSOR_BAJA");
		cursorIntermedio = toolkit.createCustomCursor(imagCursorIntermedio,new Point(0,0),"CURSOR_INTERMEDIO");
		cursorExperto = toolkit.createCustomCursor(imagCursorExperto,new Point(0,0),"CURSOR_EXPERTO");
		

	}
	/**
	 * 
	 * Descripcion: Metodo para centrar el editor de rutas
	 * 
	 */
	private void centrarEditorRutas() {
		
		setLocationRelativeTo(null);
		
	}
	/**
	 * 
	 * Descripcion: Permite cerrar el editor de rutas
	 * 
	 */
	private void cerrarEditorRutas() {
		
		try {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			addWindowListener(new cerrarEditorGraficoWindowAdapter());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	/**
	 * 
	 * Descripcion: Permite cerrar el editor al pulsar la cruz
	 *
	 */
	private class cerrarEditorGraficoWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			
			int confirmar_cerrar_editor = dialogoCerrarEditor();
			
			if (confirmar_cerrar_editor == 0) {
				dispose();
			}
			
		}
	}
	/**
	 * 
	 * Descripcion: creaccion de los botones del dialogo que avisa al usuario de si desea cerrar el editor
	 * 
	 * @return un entero que si tiene el valor de 0 el usuario querra cerrar el editor
	 */
	private int dialogoCerrarEditor() {
		
		//Mensaje de cerrar aplicacion
		
		JLabel labelDialogoCerrarAplicacionMensaje = new JLabel("¿Está seguro que desea cerrar editor? Los datos no seran guardados.");
		labelDialogoCerrarAplicacionMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		//Creaccion de los nombres de los botones
		
		String[] botones_list = {"Aceptar", "Cancelar"};
		
		return JOptionPane.showOptionDialog(this.frame, labelDialogoCerrarAplicacionMensaje, "Aviso de cierre editor grafico.", 0, 2, null, botones_list, null);
	
	}
	/**
	 * 
	 * Descripcion: datos generado de la parte de disenio con respecto al frame del editor
	 * 
	 */
	private void inicializarDatosEditorGraficoRutas() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditorGraficoRuta.class.getResource("/recursos/editorGrafico.png")));
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Segoe UI", Font.PLAIN, 14));
		setForeground(new Color(255, 255, 255));
		setResizable(false);
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Editor gráfico rutas\r\n");
		setBounds(new Rectangle(100, 100, 850, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * 
	 * Descripcion: datos generados de la parte de disenio con respecto a los items de la barra de menu
	 * 
	 */
	private void inicializarDatosBarraMenu() {
		
		// Creaccion de la barra de menu
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		//Inicializacion de los items del Menu Archivo
		
		mArchivo = new JMenu("Archivo");
		menuBar.add(mArchivo);
		
		miNuevo = new JMenuItem("Nuevo");
		miNuevo.setIcon(new ImageIcon(EditorGraficoRuta.class.getResource("/recursos/NuevoArchivo.png")));
		mArchivo.add(miNuevo);
		
		miAbrir = new JMenuItem("Abrir...");
		miAbrir.setIcon(new ImageIcon(EditorGraficoRuta.class.getResource("/recursos/Abrir.png")));
		miAbrir.setName("");
		mArchivo.add(miAbrir);
		
		miGuardar = new JMenuItem("Guardar");
		miGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ruta_personalizada != null) {
					
					String ruta_valida = "/recursos/Perfil/foto_"+index_foto+".png";
					/**
					validar_foto = metodos_gestor_perfil.updateFoto(usuario_datos_configuracion.getNombreUsuario(), ruta_valida);
					
					if(validar_foto == -1) {
						errorConfiguracionDialogo();
					}
					**/
				}
				
			}
		});
		miGuardar.setIcon(new ImageIcon(EditorGraficoRuta.class.getResource("/recursos/Guardar.png")));
		mArchivo.add(miGuardar);
		
		separator = new JSeparator();
		mArchivo.add(separator);
		
		miAcercaEditorGrafico = new JMenuItem("Acerca de Editor gráfico rutas");
		miAcercaEditorGrafico.setIcon(new ImageIcon(EditorGraficoRuta.class.getResource("/recursos/InfoEditor.png")));
		mArchivo.add(miAcercaEditorGrafico);
		
		miSalir = new JMenuItem("Salir");
		miSalir.setIcon(new ImageIcon(EditorGraficoRuta.class.getResource("/recursos/Salir.png")));
		mArchivo.add(miSalir);
		
		//Inicializacion de los items del Menu Ver
		
		mVer = new JMenu("Ver");
		menuBar.add(mVer);
		
		miAcercar = new JMenuItem("Acercar");
		miAcercar.setIcon(new ImageIcon(EditorGraficoRuta.class.getResource("/recursos/ZoomIn.png")));
		mVer.add(miAcercar);
		
		miAlejar = new JMenuItem("Alejar");
		miAlejar.setIcon(new ImageIcon(EditorGraficoRuta.class.getResource("/recursos/zoomOut.png")));
		mVer.add(miAlejar);
		
	}
	/**
	 * 
	 * Descripcion: Metodo generado al crear la parte de disenio para el panel principal del Editor Grafico 
	 * 
	 */
	private void inicializarDatosPanelPrincipal() {
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}
	/**
	 * 
	 * Descripcion: Metodo para inicializar los datos generados de la parte de disenio de los componentes de la barra de funcionalidades
	 * 
	 */
	private void inicializarDatosBarraFuncionalidades() {
		
		//Datos de la barra de funcionalidades
		
		tbBarraFuncionalidades = new JToolBar();
		tbBarraFuncionalidades.setBackground(new Color(255, 255, 255));
		contentPane.add(tbBarraFuncionalidades, BorderLayout.NORTH);
		
		//Creaccion del boton Cargar Ruta
		
		btnCargarRuta = new JButton("Cargar ruta...");
		btnCargarRuta.setFocusPainted(false);
		btnCargarRuta.setFocusTraversalKeysEnabled(false);
		btnCargarRuta.setFocusable(false);
		
		btnCargarRuta.setForeground(new Color(255, 255, 255));
		btnCargarRuta.setBackground(new Color(51, 51, 51));
		btnCargarRuta.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		tbBarraFuncionalidades.add(btnCargarRuta);
		
		//Creaccion del boton que mostrara los iconos
		
		btnIconosRepresentativos = new JButton("Insertar iconos");
		btnIconosRepresentativos.setFocusPainted(false);
		btnIconosRepresentativos.setFocusTraversalKeysEnabled(false);
		btnIconosRepresentativos.setFocusable(false);
		
		btnIconosRepresentativos.setForeground(new Color(255, 255, 255));
		btnIconosRepresentativos.setBackground(new Color(51, 51, 51));
		btnIconosRepresentativos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		tbBarraFuncionalidades.add(btnIconosRepresentativos);
		
		//Creaccion del boton que permitira insertar anotaciones
		
		btnAnotaciones = new JButton("Insertar anotaciones");
		btnAnotaciones.setFocusPainted(false);
		btnAnotaciones.setFocusTraversalKeysEnabled(false);
		btnAnotaciones.setFocusable(false);
		
		btnAnotaciones.setForeground(new Color(255, 255, 255));
		btnAnotaciones.setBackground(new Color(51, 51, 51));
		btnAnotaciones.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		tbBarraFuncionalidades.add(btnAnotaciones);
		
		//Creaccion del boton que limpiara el Edistor Grafico
		
		btnLimpiar = new JButton("Limpiar ");
		btnLimpiar.setFocusPainted(false);
		btnLimpiar.setFocusTraversalKeysEnabled(false);
		btnLimpiar.setFocusable(false);
		
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setBackground(new Color(51, 51, 51));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		tbBarraFuncionalidades.add(btnLimpiar);
		
	}
	/**
	 * 
	 * Descripcion: Metodo para inicializar la componente Scroll Pane que contendra el area de dibujo
	 * 
	 */
	private void inicializarDatosComponenteScrollPane() {
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
	}
	/**
	 * 
	 * Descripcion: Metodo para inicializar los datos del Panel Contenido donde se mostraran dos paneles personalizados, anotaciones e iconos
	 * 
	 */
	private void inicializarDatosPanelContenido() {
		
		pnlContenido = new JPanel();
		pnlContenido.setForeground(new Color(255, 255, 255));
		pnlContenido.setBounds(new Rectangle(0, 0, 30, 0));
		
		contentPane.add(pnlContenido, BorderLayout.WEST);
		pnlContenido.setLayout(new CardLayout(0, 0));
		
		//Aniadimos el panel Iconos al panel contenido
		
		{
			pnlIconos = new MiPanelIconos();
			pnlContenido.add(pnlIconos, "Insertar iconos");
		}
		
		//Aniadimos el panel Anotaciones al panel contenido
		
		{
			pnlAnotaciones = new MiPanelAnotaciones();
			pnlContenido.add(pnlAnotaciones, "Insertar anotaciones");

		}
		
		pnlContenido.setVisible(false);
		
	}
	/**
	 * 
	 * Descripcion: Metodo para inicializar los datos del area de dibujo personalizada
	 * 
	 */
	private void inicializarDatosAreaDibujoPersonalizada() {
		
		//Creación del área de dibujo personalizada
		
		miAreaDibujo = new MiAreaDibujo();		
		miAreaDibujo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		miAreaDibujo.setIcon(null);
		scrollPane.setViewportView(miAreaDibujo);
		
	}
	/**
	 * 
	 * Descripcion: metodo que contiene todos los oyentes del Editor grafico rutas
	 * 
	 */
	private void asociacionOyentesEditorGrafico() {
		
		//IMPORTANTE
		miAbrir.addActionListener(new CargarRutaActionListener());
		
		btnCargarRuta.addActionListener(new CargarRutaActionListener()); //Se asocia un oyente al btnCargarRuta para poder seleccionar un fichero
		btnIconosRepresentativos.addActionListener(new CambiarPanelesPersonalizadosActionListener()); //Oyente para que aparezca el panel iconos
		btnAnotaciones.addActionListener(new CambiarPanelesPersonalizadosActionListener()); //Oyente para que aparexca el panel anotaciones
		
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseDragged());
		
	}
	/**
	 * 
	 * Descripcion: Clase que permite cargar una ruta desde el menu Abrir o desde el boton cargar ruta
	 * 
	 *
	 */
	private class CargarRutaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			Image imagenEscalada, imagenOriginal;
			File file;
			int valorDevuelto = 0;
			index_foto = (int) Math.floor(Math.random()*500+1);
			
			BufferedImage imagen_ruta_personalizada = null;
			
			JFileChooser fcAbrir = new JFileChooser();
			
			//Aplicamos un filtro que solo permita cargar imagenes png y jpg
			fcAbrir.setFileFilter(new ImageFilter());
			
			valorDevuelto = fcAbrir.showOpenDialog(frame);
			
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				
				file = fcAbrir.getSelectedFile();
				imagen = new ImageIcon(file.getAbsolutePath());
				//miAreaDibujo.setIcon(imagen);
				
				try {
					imagen_ruta_personalizada = ImageIO.read(new File(file.getAbsolutePath()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					imagenOriginal= ImageIO.read(file);
					imagenEscalada = imagenOriginal.getScaledInstance(miAreaDibujo.getWidth(), miAreaDibujo.getHeight(), java.awt.Image.SCALE_SMOOTH);
					
					String bd = System.getProperty("user.dir") + "\\src\\recursos\\Perfil\\";
					File outputfile = new File(bd+"foto_"+index_foto+".png");
					ImageIO.write(imagen_ruta_personalizada, "png", outputfile);
					
					ruta_personalizada = bd+"foto_"+index_foto+".png";
					
					imagenNueva = new ImageIcon(imagenEscalada);
					miAreaDibujo.setIcon(imagenNueva);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * Descripcion: Permite cambiar entre los distintos paneles personalizados al pulsar un boton
	 *
	 */
	private class CambiarPanelesPersonalizadosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			CardLayout cardLayoutPanel = (CardLayout)(pnlContenido.getLayout());
			pnlContenido.setVisible(true);
			cardLayoutPanel.show(pnlContenido, arg0.getActionCommand());
			
		}
	}
	/**
	 * 
	 * Descripcion: clase que depensiendo del modo permite pintar una forma al arrastrar un el raton y pulsar el determinado boton
	 *
	 */
	private class MiAreaDibujoMouseDragged extends MouseAdapter{
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTANGULO && imagen!=null) {
				
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
				
			}
		}
	}
	/**
	 * 
	 * Descripcion: Clase que permite realizar distintas acciones dependiendo de los botones que se pulsen
	 *
	 */
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			
			x = e.getX();
			y = e.getY();
			
			toolkit = Toolkit.getDefaultToolkit();
			
			switch(color) {
				case 1:
					color_forma = Color.RED;
					break;
				case 2:
					color_forma = Color.ORANGE;
					break;
				case 3:
					color_forma = Color.YELLOW;
					break;
				case 4:
					color_forma = Color.GREEN;
					break;
				case 5:
					color_forma = Color.BLUE;
					break;
				case 6:
					color_forma = Color.GRAY;
					break;
				case 7:
					color_forma = Color.WHITE;
					break;
				case 8:
					color_forma = Color.BLACK;
					break;
				default:
					color_forma = Color.BLACK;
					break;
				
			}
			
		
		
			if (imagen != null) {
				switch (modo){
				
					case RECTANGULO:
						
						miAreaDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y, color_forma));
						break;
						
					case TEXTO:
						
						
						txtTexto.setBounds(x, y, 200,30);
						txtTexto.setVisible(true);
						txtTexto.requestFocus();
						
						txtTexto.addActionListener(new TxtAnotacionesAreaDibujoActionListener());
								
						miAreaDibujo.add(txtTexto);
						break;
						
					case FORMA_UBICACION:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagUbicacion));
						miAreaDibujo.repaint();
						break;
						
					case FORMA_PUENTE:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagPuente));
						miAreaDibujo.repaint();
						break;
					
					case FORMA_RIO:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagRio));
						miAreaDibujo.repaint();
						break;
					
					case FORMA_MERENDEREO:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagMerendero));
						miAreaDibujo.repaint();
						break;
						
					case FORMA_ACAMPADA:
	
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagAcampada));
						miAreaDibujo.repaint();
						break;
						
					case FORMA_ANIMAL:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagAnimal));
						miAreaDibujo.repaint();
						break;
						
					case FORMA_NO_TIENE:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagNoTiene));
						miAreaDibujo.repaint();
						break;
						
					case FORMA_BAJA:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagBaja));
						miAreaDibujo.repaint();
						break;
						
					case FORMA_INTERMEDIO:
						
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagIntermedio));
						miAreaDibujo.repaint();
						break;
						
					case FORMA_EXPERTO:
	
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagNoExperto));
						miAreaDibujo.repaint();
						break;
				}
			}
		}
	
	}
	
	/**
	 * 
	 * Descripcion: Clase que permite introducir texto en el area de dibujo
	 *
	 */
	private class TxtAnotacionesAreaDibujoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(!txtTexto.getText().equals("")) {
				
				miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(), color_forma));
				txtTexto.setText("");
				txtTexto.setVisible(false);
				miAreaDibujo.repaint();
				
			}	
		}
	}
}

