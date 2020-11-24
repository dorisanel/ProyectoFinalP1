package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.Juego;
import logical.SerieNacional;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setResizable(false);
		setTitle("Serie Nacional de Béisbol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 362);
		dim = getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Jugador");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarJugador eq = new RegistrarJugador("Registrar Jugador",0, null);
				eq.setVisible(true);
				eq.setLocationRelativeTo(null);
				eq.setResizable(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Juego");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Listados");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Lista de Jugadores");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Lista de Equipos");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Lista de Juegos");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Estad\u00EDsticas");
		menuBar.add(mntmNewMenuItem_6);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pr\u00F3ximos Juegos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(1229, 426, 365, 371);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		String[] columns = {"Casa","Visitante", "Fecha", "Estadio"};
		modelo.setColumnIdentifiers(columns);
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setEnabled(false);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		cargarTabla();
	}

	private void cargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];

		for(Juego juego : SerieNacional.getInstance().getMisJuegos()) {
			
			if(juego.isEstado()) {

				fila[0] = juego.getLocal();
				fila[1] = juego.getVisitante(); 
				fila[2] = juego.getFecha();
				fila[3] = juego.getEstadio();
			}

			modelo.addRow(fila);

		}

	}
}
