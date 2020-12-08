package visual;

import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.geom.transform.CanTransformVec3d;

import logical.Equipo;
import logical.Juego;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;


public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JMenuItem listaEquipoBtn;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JTable table;
	private BufferedImage bimg;
	private JLabel lblFrontIcon;
	private BufferedImage bimg2;
	private JPanel ultimoLbl;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
		addWindowListener(new WindowAdapter() {
			private Window lblFrontIcon;
			@Override
			public void windowActivated(WindowEvent e) {
				try {
					modelo.setRowCount(0);
					cargarTabla();
				}catch(Exception e0) {

				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				
				FileOutputStream Serie2;
				ObjectOutputStream SerieWrite;
				try{
					Serie2 = new FileOutputStream("SerieNacional.dat");
					SerieWrite = new ObjectOutputStream(Serie2);
					SerieWrite.writeObject(SerieNacional.getInstance());
					Serie2.close();
					SerieWrite.close();
				} catch(FileNotFoundException e1) {
					e1.printStackTrace();
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void windowIconified(WindowEvent e) {
				try {
					lblFrontIcon.setBounds(0, 0, 1920, 1024);
				}catch(Exception e0) {
					
				}
				
			}
		});

		/////////////////////////TEST////////////////////////////////////////
		
		/////////////////////////////////////////////////////////////////////


		setMaximumSize(new Dimension(2080, 1960));
		setTitle("Serie Nacional de Béisbol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2665, 1299);
		dim = getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setSize(this.getWidth(), 500);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Cambria", Font.PLAIN, 24));
		menuBar.setBackground(new Color(0, 51, 153));
		
		menuBar.setRequestFocusEnabled(false);
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Registro");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Equipo");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RegistrarEquipo eq = new RegistrarEquipo("Registrar Equipo",0, null);
				eq.setVisible(true);
				eq.setLocationRelativeTo(null);
				eq.setResizable(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem registrarJugadorBtn = new JMenuItem("Registrar Jugador");
		registrarJugadorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarJugador eq = new RegistrarJugador("Registrar Jugador",0, null);
				eq.setVisible(true);
				eq.setLocationRelativeTo(null);
				eq.setResizable(false);
			}
		});
		mnNewMenu.add(registrarJugadorBtn);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Juego");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegJuego rg1 = new RegJuego("Registrar juego", 0, null);
				rg1.setVisible(true);
				rg1.setLocationRelativeTo(null);
				rg1.setResizable(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Listados");
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Lista de Jugadores");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoJugador ljug = new ListadoJugador();
				ljug.setVisible(true);
				ljug.setLocationRelativeTo(null);
				ljug.setResizable(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		listaEquipoBtn = new JMenuItem("Lista de Equipos");
		listaEquipoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEquipos le = new ListarEquipos();
				le.setVisible(true);
				le.setLocationRelativeTo(null);
				le.setResizable(false);
			}
		});
		mnNewMenu_1.add(listaEquipoBtn);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Lista de Juegos");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaJuegos Lj1 = new ListaJuegos();
				Lj1.setVisible(true);
				Lj1.setLocationRelativeTo(null);
				Lj1.setResizable(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem = new JMenuItem("Listado de Lesiones");
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnNewMenu_2 = new JMenu("Estad\u00EDsticas");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Top 10 Jugadores");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top10 dialog = new Top10();
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Estad\u00EDsticas de Equipos");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ListaEstadistica est1 = new ListaEstadistica();
					est1.setVisible(true);
					}catch(ArithmeticException e1) {
					JOptionPane.showMessageDialog(null, "No existen estadisticas definidas.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Estad\u00EDsticad de Jugadores");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EstadisticaJugadores dialog = new EstadisticaJugadores();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}catch(ArithmeticException e1) {
					JOptionPane.showMessageDialog(null, "No existen estadisticas definidas.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		mnNewMenu_2.add(mntmNewMenuItem_4);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficaLesiones eq = new GraficaLesiones();
				eq.setVisible(true);
				eq.setLocationRelativeTo(null);
				eq.setResizable(false);
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lidomLbl = new JLabel("New label");
		lidomLbl.setForeground(new Color(255, 255, 255));
		lidomLbl.setFont(new Font("Candara", Font.BOLD, 23));
		lidomLbl.setBounds(0, 21, 236, 236);
		try {
			 bimg2 = resize("muuSawtA_preview_rev_2.png", lidomLbl.getWidth(),  lidomLbl.getHeight());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon img2 = new ImageIcon(bimg2);
		
	//	if(SerieNacional.getSerieNacional().getUltimoJuego() != null) {
		ultimoLbl = new JPanel();
		ultimoLbl.setBorder(new LineBorder(new Color(0, 0, 128)));
		ultimoLbl.setBackground(new Color(255, 255, 255));
		ultimoLbl.setBounds(831, 68, 605, 257);
		contentPane.add(ultimoLbl);
		ultimoLbl.setLayout(null);
		//}
		
		JLabel lblNewLabel = new JLabel("Resultados del");
		lblNewLabel.setBounds(148, 10, 220, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		ultimoLbl.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vs");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD, 31));
		lblNewLabel_1.setBounds(265, 106, 63, 26);
		ultimoLbl.add(lblNewLabel_1);
		
		JLabel lblLocal = new JLabel("");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(35, 47, 160, 147);
		if(SerieNacional.getSerieNacional().getUltimoJuego() != null) {
			try {
				Image imgIcon3 = SerieNacional.getSerieNacional().getUltimoJuego().getLocal().getImage().getImage().getScaledInstance(160, 147, Image.SCALE_SMOOTH);
				ImageIcon img4 =(ImageIcon) new ImageIcon(imgIcon3); 
				lblLocal.setIcon(img4);
			} catch(Exception e) {
				
			}
			
		}
		ultimoLbl.add(lblLocal);
		
		JLabel lblVisitante = new JLabel("");
		lblVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitante.setBounds(403, 47, 168, 147);
		if(SerieNacional.getSerieNacional().getUltimoJuego() != null) {
			try {
				Image imgIcon = SerieNacional.getSerieNacional().getUltimoJuego().getVisitante().getImage().getImage().getScaledInstance(160, 147, Image.SCALE_SMOOTH);
				ImageIcon img3 =(ImageIcon) new ImageIcon(imgIcon); 
				lblVisitante.setIcon(img3);
			} catch(Exception e) {
				
			}
			
		}
		ultimoLbl.add(lblVisitante);
		
		JLabel cantLocalLbl = new JLabel("New label");
		cantLocalLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cantLocalLbl.setBounds(0, 200, 195, 46);
		cantLocalLbl.setFont(new Font("Tahoma", Font.PLAIN, 44));
		if(SerieNacional.getInstance().getUltimoJuego() != null) {
			cantLocalLbl.setText(String.valueOf(SerieNacional.getSerieNacional().getUltimoJuego().getCantCarrerasL()).toString());
			ultimoLbl.add(cantLocalLbl);
		}
			
		
		JLabel cantVisitanteLbl = new JLabel("New label");
		cantVisitanteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cantVisitanteLbl.setBounds(385, 200, 220, 46);
		cantVisitanteLbl.setFont(new Font("Tahoma", Font.PLAIN, 44));
		if(SerieNacional.getInstance().getUltimoJuego() != null) {
			cantVisitanteLbl.setText(String.valueOf(SerieNacional.getSerieNacional().getUltimoJuego().getCantCarrerasV()).toString());
			ultimoLbl.add(cantVisitanteLbl);
		}
		
		
		JLabel lblFecha = new JLabel("\u00DAltimo Juego");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 21));
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date;
		if(SerieNacional.getSerieNacional().getUltimoJuego() != null) {
			date = simpleDateFormat.format(SerieNacional.getSerieNacional().getUltimoJuego().getFecha());
			lblFecha.setText(date);
		}
		
		lblFecha.setBounds(317, 10, 278, 26);
		ultimoLbl.add(lblFecha);
		lidomLbl.setIcon(img2);
		
		contentPane.add(lidomLbl);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Candara", Font.PLAIN, 15));
		panel.setOpaque(false);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pr\u00F3ximos juegos:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 220, 220)));
		
		panel.setBounds(831, 363, 605, 437);
		
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setForeground(Color.WHITE);
		panel.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();
		String[] columns = {"Casa","Visitante", "Fecha/Hora", "Estadio"};
		modelo.setColumnIdentifiers(columns);
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(0, 0, 128));
		table.setOpaque(false);
		table.setBackground(Color.GRAY);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		lblFrontIcon = new JLabel("New label");
		lblFrontIcon.setVerticalAlignment(SwingConstants.TOP);
		try {
			 bimg = resize("principal.jpg", 1980, 1024);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon img = new ImageIcon(bimg);
		lblFrontIcon.setIcon(img);
		lblFrontIcon.setBounds(0, 0, 1980, 1024);
		contentPane.add(lblFrontIcon);
		lblFrontIcon.setVerticalAlignment(SwingConstants.TOP);
		modelo.setRowCount(0);
		cargarTabla();
	}

	private void cargarTabla() {
		fila = new Object[modelo.getColumnCount()];
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date;
		ArrayList<Juego> juegosNoTerminados = new ArrayList<Juego>();
		for(Juego juego : SerieNacional.getInstance().getMisJuegos()) {
			if(juego.isTerminado() == false && juego.isEstado()) {
				juegosNoTerminados.add(juego);
			}
		}
		for(Juego juego :juegosNoTerminados) {
			date = simpleDateFormat.format(juego.getFecha());
				fila[0] = juego.getLocal().getNombre();
				fila[1] = juego.getVisitante().getNombre(); 
				fila[2] = date;
				fila[3] = juego.getEstadio();
			
			modelo.addRow(fila);

		}

	}
	public BufferedImage resize(String inputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
	
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        return outputImage;
    }
}
