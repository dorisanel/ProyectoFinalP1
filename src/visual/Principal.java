package visual;

import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.EventQueue;

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


import logical.Equipo;
import logical.Juego;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;


public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JMenuItem listaEquipoBtn;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				FileInputStream serieN;
				FileOutputStream serieN2;
				ObjectInputStream serieRead;
				ObjectOutputStream serieWrite;
				try {
					serieN = new FileInputStream("SerieNacional.dat");
					serieRead = new ObjectInputStream(serieN); 
					SerieNacional temp = (SerieNacional)serieRead.readObject();
					SerieNacional.setSerieNacional(temp);
					serieN.close();
					serieRead.close();
				} catch (FileNotFoundException e) {
					try {
						serieN2 = new FileOutputStream("SerieNacional.dat");
						serieWrite = new ObjectOutputStream(serieN2);
						serieWrite.writeObject(SerieNacional.getInstance());
					} catch (FileNotFoundException e1) {

					} catch (IOException e1) {

					}
				} catch (IOException e) {

				} catch (ClassNotFoundException e) {
					
				}

				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				try {
					
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
		});

		/////////////////////////TEST////////////////////////////////////////
		
		/////////////////////////////////////////////////////////////////////


		setMaximumSize(new Dimension(2080, 1960));
		setTitle("Serie Nacional de B�isbol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2396, 1257);
		dim = getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setRequestFocusEnabled(false);
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Registro");
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
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Top 10 Jugadores");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top10 dialog = new Top10();
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Estad\u00EDsticas Jugadores");
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

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pr\u00F3ximos juegos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(883, 363, 550, 414);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();
		String[] columns = {"Casa","Visitante", "Fecha/Hora", "Estadio"};
		modelo.setColumnIdentifiers(columns);
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		cargarTabla();
	}

	private void cargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date;
		for(Juego juego : SerieNacional.getInstance().getMisJuegos()) {
			date = simpleDateFormat.format(juego.getFecha());
			if(!juego.isTerminado()) {
				fila[0] = juego.getLocal();
				fila[1] = juego.getVisitante(); 
				fila[2] = date;
				fila[3] = juego.getEstadio();
			}
			modelo.addRow(fila);

		}

	}
}
